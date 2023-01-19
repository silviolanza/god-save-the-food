package com.example.Order.postgresql.controller;

import com.example.Order.postgresql.model.Order;

import java.util.List;

public interface OrderService {
    //save operation
    Order createOrder(Order order);
    // read operation
    List<Order> getAllOrderList();
    Order getOrderById(long idOrder);
    // update operation
    Order updateOrder(Order department, long idOrder);
    // delete operation
    void deleteOrderById(long idOrder);

}
