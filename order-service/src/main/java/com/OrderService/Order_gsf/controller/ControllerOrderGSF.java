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



    @PostMapping(value = "/orders/create")
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
        List<ItemsGSF> arr= new ArrayList();
        ItemsGSF it1= new ItemsGSF(1,10,BigDecimal.valueOf(10.12));
        arr.add(it1);
        order.setItem(arr);
        order.setUser(user);
        //order.setTotal(BigDecimal.valueOf(10.10));
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
    @GetMapping("/orders")
    public List<OrderGSF> getAllItems() {
        System.out.println("Get all order...");
        List<OrderGSF> order = new ArrayList<>();
        order= orderGSFService.getAllOrder();
        return order;
    }
    @GetMapping("/orders/init")
    public ResponseEntity<?> init(){
        //creazione di un ordine
        ItemsGSF it1= new ItemsGSF(1,10,BigDecimal.valueOf(10.12));
        ItemsGSF it2= new ItemsGSF(6,3,BigDecimal.valueOf(11.00));
        ItemsGSF it3= new ItemsGSF(12,14,BigDecimal.valueOf(11.00));
        ItemsGSF it4= new ItemsGSF(32,1,BigDecimal.valueOf(70.00));
        ItemsGSF it5= new ItemsGSF(2,2,BigDecimal.valueOf(25.00));
        ItemsGSF it6= new ItemsGSF(2,22,BigDecimal.valueOf(5.00));

        List<ItemsGSF> item1=new ArrayList<>();
        List<ItemsGSF> item2=new ArrayList<>();
        List<ItemsGSF> item3=new ArrayList<>();
        List<ItemsGSF> item4=new ArrayList<>();
        List<ItemsGSF> item5=new ArrayList<>();
        item1.add(it1);
        item2.add(it4);
        item3.add(0,it2);
        item3.add(1,it3);
        item4.add(it5);
        item5.add(0,it5);
        item5.add(1,it6);
        System.out.println("Order creation started...");
        orderGSFService.saveOrder(new OrderGSF("federico.gallarati", LocalDate.now(), BigDecimal.valueOf(70.00), "PAYMENT_EXPECTED",item2));
        orderGSFService.saveOrder(new OrderGSF("luca.oddone", LocalDate.now(), BigDecimal.valueOf(30.00), "PAYMENT_EXPECTED",item5));
        orderGSFService.saveOrder(new OrderGSF("pietro.esposito", LocalDate.now(), BigDecimal.valueOf(25.00), "PAYMENT_EXPECTED",item4));
        orderGSFService.saveOrder(new OrderGSF("silvio.lanza", LocalDate.now(), BigDecimal.valueOf(22.00), "PAYMENT_EXPECTED",item3));
        orderGSFService.saveOrder(new OrderGSF("ciro.rossi", LocalDate.now(), BigDecimal.valueOf(10.12), "PAYMENT_EXPECTED",item1));
        System.out.println("Order creation complete...");
        //cerca oggetto tramite il nome
        return ResponseEntity.status(200).body("Init complete...");
    }

}
