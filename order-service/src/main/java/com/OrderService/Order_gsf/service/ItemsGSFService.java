package com.OrderService.Order_gsf.service;

import com.OrderService.Order_gsf.model.ItemsGSF;

import java.math.BigDecimal;
import java.util.List;

public interface ItemsGSFService {
    public void addItem(int productId, int quantity);
    public List<ItemsGSF> getItem(Long itemId);
    public void changeItemQuantity(int productId, Integer quantity, BigDecimal subtotal);
    public void deleteAllItem(Long itemId, int productId);
    public boolean checkIfItemIsExist(Long itemId, int productId);
    public List<ItemsGSF>  getAllItems();
    public void deleteItem(Long itemId);
}

