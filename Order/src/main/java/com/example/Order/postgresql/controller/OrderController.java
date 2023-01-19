package com.example.Order.postgresql.controller;

import com.example.Order.postgresql.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{idOrder}")
    public Order getOrderById(long idOrder) {
        return orderService.getOrderById(idOrder);
    }
    @GetMapping ("/order")
    public List<Order> getAllOrder(){
        return orderService.getAllOrderList();
    }

    @PostMapping("/order")
    public Order createOrder(@Validated @RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Update operation
    @PutMapping("/order/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable("id") Long orderId) {
        return orderService.updateOrder(order, orderId);
    }

    // Delete operation
    @DeleteMapping("/order/{id}")
    public String deleteOrderById(@PathVariable("id") Long orderId) {
        orderService.deleteOrderById(orderId);
        return "Deleted Successfully";
    }
}
