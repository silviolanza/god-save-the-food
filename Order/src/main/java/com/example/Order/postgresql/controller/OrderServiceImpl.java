package com.example.Order.postgresql.controller;

import com.example.Order.postgresql.controller.OrderService;
import com.example.Order.postgresql.model.Order;
import com.example.Order.postgresql.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrderList() {
        return (List<Order>) orderRepository.findAll();
    }
    public Order getOrderById(long idOrder){
        return  orderRepository.findById(idOrder).get();
    }

    @Override
    public Order updateOrder(Order order, long idOrder) {
        Order orderDB = orderRepository.findById(idOrder).get();

        if (Objects.nonNull(order.getTotal()) )
            orderDB.setTotal(order.getTotal());
        if (Objects.nonNull(order.getState()) && !"".equalsIgnoreCase(order.getState()))
            orderDB.setState(order.getState());

        return orderRepository.save(orderDB);
    }


    @Override
    public void deleteOrderById(long idOrder) {
        orderRepository.deleteById(idOrder);
    }
}
