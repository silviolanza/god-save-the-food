package com.OrderService.Order_gsf.service;

import com.OrderService.Order_gsf.model.ItemsGSF;
import com.OrderService.Order_gsf.model.OrderGSF;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ItemsGSFService {
    public ItemsGSF addNewItem(int idProduct, int quantity);
    public Optional<ItemsGSF> getItem(long id);
    public void changeItemQuantity(int productId, Integer quantity, BigDecimal subtotal);
    public boolean checkIfItemIsExist(Long itemId, int productId);
    public List<ItemsGSF>  getAllItems();
    public void deleteItem(Long itemId);
    public ItemsGSF saveItem (ItemsGSF item);

}

