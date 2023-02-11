package com.OrderService.Order_gsf.service;

import com.OrderService.Order_gsf.model.ItemsGSF;
import java.util.List;

public interface ItemsGSFService {
    public void addItem(Long itemId, Long productId, Integer quantity);
    public List<ItemsGSF> getItem(Long itemId);
    public void changeItemQuantity(Long itemId, Long productId, Integer quantity);
    public void deleteAllItem(Long itemId, Long productId);
    public boolean checkIfItemIsExist(Long itemId, Long productId);
    public List<ItemsGSF>  getAllItems();
    public void deleteItem(Long itemId);
}

