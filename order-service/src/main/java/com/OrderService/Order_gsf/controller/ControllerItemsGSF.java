package com.OrderService.Order_gsf.controller;

import com.OrderService.Order_gsf.model.ItemsGSF;
import com.OrderService.Order_gsf.model.OrderGSF;
import com.OrderService.Order_gsf.service.ItemsGSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class ControllerItemsGSF {
   @Autowired
   private ItemsGSFService itemGSFService;

    @GetMapping (value = "/orders/item/{id}" )
   public ResponseEntity<?>getItems ( @PathVariable("id") long id){
        Optional<ItemsGSF> item= itemGSFService.getItem(id);
        if(item!=null)
            return new ResponseEntity<>(item,HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @GetMapping("/orders/item")
    public List<ItemsGSF> getAllItems() {
        System.out.println("Get all items...");
        List<ItemsGSF> items = new ArrayList<>();
        items= itemGSFService.getAllItems();
        return items;
    }

    @PostMapping(value = "/orders/item/create")
    public ResponseEntity<?> addItem(@RequestBody ItemsGSF item) {
        int p=5;
        int qta=7;
        itemGSFService.addNewItem(p, qta);
        /*else{
            if(itemGSFService.checkIfItemIsExist(itemId, productId))
                itemGSFService.changeItemQuantity(productId, quantity, BigDecimal.valueOf(quantity));
            else
                itemGSFService.addItem(productId, quantity);
        }*/

        return new ResponseEntity<List<Object>>(HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/orders/item/delete/{id}")
    public ResponseEntity<?> removeItem( @PathVariable("id") long id){
        Optional<ItemsGSF> item = itemGSFService.getItem(id);
        if(item != null) {
            itemGSFService.deleteItem(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
    }
    @GetMapping("/orders/item/init")
    public ResponseEntity<?> init(){
        //creazione di un ordine
        System.out.println("init item...");
        itemGSFService.saveItem(new ItemsGSF(1,10,BigDecimal.valueOf(10.12)));
        itemGSFService.saveItem(new ItemsGSF(6,3,BigDecimal.valueOf(11.00)));
        itemGSFService.saveItem(new ItemsGSF(12,14,BigDecimal.valueOf(11.00)));
        itemGSFService.saveItem(new ItemsGSF(32,1,BigDecimal.valueOf(70.00)));
        itemGSFService.saveItem(new ItemsGSF(2,2,BigDecimal.valueOf(25.00)));
        itemGSFService.saveItem(new ItemsGSF(2,22,BigDecimal.valueOf(5.00)));
        System.out.println("item creation complete...");
        //cerca oggetto tramite il nome
        return ResponseEntity.status(200).body("Init complete...");
    }
}
