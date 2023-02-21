package com.OrderService.Order_gsf.controller;

import com.OrderService.Order_gsf.model.ItemsGSF;
import com.OrderService.Order_gsf.service.ItemsGSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/order")
public class ControllerItemsGSF {
   @Autowired
   private ItemsGSFService itemGSFService;

    @GetMapping (value = "/item", params = {"id"} )
   public ResponseEntity<?> getItems (@PathVariable("id")Long itemId){
        List<ItemsGSF> item= itemGSFService.getItem(itemId);
        if(!item.isEmpty())
            return new ResponseEntity<List<Object>>(HttpStatus.OK);
        return new ResponseEntity<List<Object>>(HttpStatus.NOT_FOUND);

    }
    @GetMapping("/item")
    public List<ItemsGSF> getAllItems() {
        System.out.println("Get all items...");
        List<ItemsGSF> items = new ArrayList<>();
        items= itemGSFService.getAllItems();
        return items;
    }

    @PostMapping(value = "/item")
    public ResponseEntity<?> addItem(@RequestParam("productId") int productId, @RequestParam("quantity") Integer quantity, @RequestParam("id") Long itemId) {
        List<ItemsGSF> item = itemGSFService.getItem(itemId);
        if(item == null)
            //int productId, int quantity, BigDecimal subTotal);
            itemGSFService.addItem(productId, quantity);
        else{
            if(itemGSFService.checkIfItemIsExist(itemId, productId))
                itemGSFService.changeItemQuantity(productId, quantity, BigDecimal.valueOf(quantity));
            else
                itemGSFService.addItem(productId, quantity);
        }

        return new ResponseEntity<List<Object>>((MultiValueMap<String, String>) item, HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/item")
    public ResponseEntity<?> removeItem(@RequestParam("productId") int productId, @RequestParam("id") Long itemId){
        List<ItemsGSF> item = itemGSFService.getItem(itemId);
        if(item != null) {
            itemGSFService.deleteAllItem(itemId, productId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
    }
}
