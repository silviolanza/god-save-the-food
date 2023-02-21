package com.OrderService.Order_gsf.service;

import com.OrderService.Order_gsf.model.ItemsGSF;
import com.OrderService.Order_gsf.model.ProductGSF;

import com.OrderService.Order_gsf.repo.ItemsGSFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemsGSFServiceImpl implements ItemsGSFService{

    @Autowired
    private ItemsGSFRepository itemsGSFRepository;


    public static BigDecimal getSubTotalForItem(ProductGSF product, int quantity){
        return (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
    }


    @Override
   public ItemsGSF addNewItem(int idProduct, int quantity) {
        ItemsGSF item=itemsGSFRepository.save(new ItemsGSF(quantity,idProduct,BigDecimal.valueOf(quantity)));
        return item;
    }

    @Override
    public Optional<ItemsGSF> getItem(long id) {
        return itemsGSFRepository.findById(id);
    }

    @Override
    public void changeItemQuantity( int productId, Integer quantity, BigDecimal subtotal) {
        List<ItemsGSF> it= (List<ItemsGSF>) itemsGSFRepository.findAll();
        for (ItemsGSF item : it){
            if(item.getProduct()==productId){
                itemsGSFRepository.deleteById(item.getId());
                item.setQuantity(quantity);
                item.setSubTotal(subtotal);
                itemsGSFRepository.save(item);

            }
        }
    }


    @Override
    public boolean checkIfItemIsExist(Long itemId, int productId) {
        List<ItemsGSF> it= (List<ItemsGSF>) itemsGSFRepository.findAll();
        for (ItemsGSF item : it){
            if(item.getProduct()==productId)
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

    public ItemsGSF saveItem (ItemsGSF item) {
        return itemsGSFRepository.save(item);
    }

}
