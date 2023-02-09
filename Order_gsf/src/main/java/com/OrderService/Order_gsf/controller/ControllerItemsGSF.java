package com.OrderService.Order_gsf.controller;

import com.OrderService.Order_gsf.model.ItemsGSF;
import com.OrderService.Order_gsf.service.ItemsGSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ControllerItemsGSF {
   @Autowired
   private ItemsGSFService itemGSFService;

    @GetMapping (value = "/item", params = {"id"} )
   public ResponseEntity<List<Object>> getItems (@PathVariable("id")Long itemId){
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

    @PostMapping(value = "/item", params = {"productId", "quantity"})
    public ResponseEntity<List<Object>> addItem(@RequestParam("productId") Long productId, @RequestParam("quantity") Integer quantity, @PathVariable("id")long itemId) {
        List<ItemsGSF> item = itemGSFService.getItem(itemId);
        if(item != null) {
            if(item.isEmpty()){
                itemGSFService.addItem(itemId, productId, quantity);
            }else{
                if(itemGSFService.checkIfItemIsExist(itemId, productId)){
                    itemGSFService.changeItemQuantity(itemId, productId, quantity);
                }else {
                    itemGSFService.addItem(itemId, productId, quantity);
                }
            }
            return new ResponseEntity<List<Object>>((MultiValueMap<String, String>) item, HttpStatus.CREATED);
        }
        return new ResponseEntity<List<Object>>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(value = "/item", params = "productId")
    public ResponseEntity<Void> removeItem(@RequestParam("productId") Long productId, @PathVariable("id") long cartId){
        List<ItemsGSF> item = itemGSFService.getItem(cartId);
        if(item != null) {
            itemGSFService.deleteAllItem(cartId, productId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
    }
}
