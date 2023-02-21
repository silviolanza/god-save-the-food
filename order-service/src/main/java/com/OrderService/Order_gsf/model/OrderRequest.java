package com.OrderService.Order_gsf.model;

import java.util.List;

public class OrderRequest {
    private String userId;
    private  List<ItemsGSF> items;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ItemsGSF> getItems() {
        return items;
    }

    public void setItems(List<ItemsGSF> items) {
        this.items = items;
    }
}
