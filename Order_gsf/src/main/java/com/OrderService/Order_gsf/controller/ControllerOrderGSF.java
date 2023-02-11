package com.OrderService.Order_gsf.controller;

import com.OrderService.Order_gsf.model.ItemsGSF;
import com.OrderService.Order_gsf.model.OrderGSF;
import com.OrderService.Order_gsf.model.UsersGSF;
import com.OrderService.Order_gsf.other_client.UserGSFClient;

import com.OrderService.Order_gsf.service.ItemsGSFService;
import com.OrderService.Order_gsf.service.OrderGSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ControllerOrderGSF {

    @Autowired
    private OrderGSFService orderGSFService;
    @Autowired
    private ItemsGSFService itemGSFService;

    private UserGSFClient userGSFClient;


    @PostMapping(value = "/order/{userId}")
    public ResponseEntity<OrderGSF> saveOrder(@PathVariable("userId") Long userId, @PathVariable("id") Long itemId) {

       List<ItemsGSF> items = itemGSFService.getItem(itemId);
        UsersGSF user = userGSFClient.getUserById(userId);
        if (items != null && user != null) {
            OrderGSF order = this.createOrder(items,user);
            try {
                orderGSFService.saveOrder(order);
                itemGSFService.deleteItem(itemId);
                return new ResponseEntity<OrderGSF>(order, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new ResponseEntity<OrderGSF>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<OrderGSF>(HttpStatus.NOT_FOUND);
    }

    private OrderGSF createOrder(List<ItemsGSF> item, UsersGSF user) {
        OrderGSF order = new OrderGSF();
        order.setItem(item);
        order.setUser(user);
        order.setTotal(countTotalPrice(item));
        order.setDate(LocalDate.now());
        order.setStatus("PAYMENT_EXPECTED");
        return order;
    }

    public static BigDecimal countTotalPrice(List<ItemsGSF> item){
        BigDecimal total = BigDecimal.ZERO;
        for(int i = 0; i < item.size(); i++){
            total = total.add(item.get(i).getSubTotal());
        }
        return total;
    }
    @GetMapping("/order")
    public List<OrderGSF> getAllItems() {
        System.out.println("Get all order...");
        List<OrderGSF> order = new ArrayList<>();
        order= orderGSFService.getAllOrder();
        return order;
    }
}
