package com.OrderService.Order_gsf.controller;

import com.OrderService.Order_gsf.model.*;


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



    @PostMapping(value = "/order/create")
     public ResponseEntity saveOrder(@RequestBody OrderRequest items) {
        String userId="Giuseppe";
       List<ItemsGSF> item_id = items.getItems();
        if (items!=null && userId != null) {
            OrderGSF order = this.createOrder(item_id,userId);
            try {
                orderGSFService.saveOrder(order);
                return new ResponseEntity(order, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new ResponseEntity<OrderGSF>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<OrderGSF>(HttpStatus.NOT_FOUND);
    }

    private OrderGSF createOrder(List<ItemsGSF> item, String user) {
        OrderGSF order = new OrderGSF();
        order.setItem(item);
        order.setUser(user);
        order.setTotal(BigDecimal.valueOf(12.00));
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
