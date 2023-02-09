package com.OrderService.Order_gsf.service;

import com.OrderService.Order_gsf.model.ItemsGSF;
import com.OrderService.Order_gsf.model.OrderGSF;
import com.OrderService.Order_gsf.model.ProductGSF;
import com.OrderService.Order_gsf.other_client.ProductGSFClient;
import com.OrderService.Order_gsf.repo.ItemsGSFRepository;
import com.OrderService.Order_gsf.repo.OrderGSFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ItemsGSFServiceImpl implements ItemsGSFService{

    @Autowired
    private ItemsGSFRepository itemsGSFRepository;
    private ProductGSFClient productClient;

    public static BigDecimal getSubTotalForItem(ProductGSF product, int quantity){
        return (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
    }


    @Override
    public void addItem(Long itemId, Long productId, Integer quantity) {
        ProductGSF prod=productClient.getProductById(productId);
        ItemsGSF item=new ItemsGSF(quantity,prod,getSubTotalForItem(prod,quantity));
        itemsGSFRepository.save(item);
    }

    @Override
    public List<ItemsGSF> getItem(Long itemId) {
        return (List<ItemsGSF>) itemsGSFRepository.findAllById(Collections.singleton(itemId));
    }

    @Override
    public void changeItemQuantity(Long itemId, Long productId, Integer quantity) {
        List<ItemsGSF> it= (List<ItemsGSF>) itemsGSFRepository.findAll();
        for (ItemsGSF item : it){
            if(item.getProduct().getId()==productId){
                itemsGSFRepository.deleteById(item.getId());
                item.setQuantity(quantity);
                item.setSubTotal(getSubTotalForItem(item.getProduct(),quantity));
                itemsGSFRepository.save(item);

            }
        }
    }

    @Override
    public void deleteAllItem(Long itemId, Long productId) {
        List<ItemsGSF> it= (List<ItemsGSF>) itemsGSFRepository.findAll();
        for (ItemsGSF item : it){
            if(item.getProduct().getId()==productId)
                itemsGSFRepository.deleteById(item.getId());

        }
    }

    @Override
    public boolean checkIfItemIsExist(Long itemId, Long productId) {
        List<ItemsGSF> it= (List<ItemsGSF>) itemsGSFRepository.findAll();
        for (ItemsGSF item : it){
            if(item.getProduct().getId()==productId)
                return true;
        }
        return false;
    }

    @Override
    public List<ItemsGSF> getAllItems() {
        List<ItemsGSF> it= new ArrayList();
        itemsGSFRepository.findAll().forEach(it :: add);
        return it;
    }
    @Override
    public void deleteItem(Long itemId) {
        itemsGSFRepository.deleteById(itemId);
    }



}
