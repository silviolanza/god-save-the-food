package com.goodsavethefood.productservice.controller;

import com.goodsavethefood.productservice.model.ProductModel;
import com.goodsavethefood.productservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/products/")

public class ProductController {
    @Autowired
    ProductRepository productRepo;
    @GetMapping("name/{productName}")
    public ResponseEntity<?> findByProductName(@PathVariable String productName){
        //cerca prodotto tramite il nome
        ProductModel product = productRepo.findByProductName(productName);
        return ResponseEntity.status(200).body(product);
    }

    @GetMapping("store/{storeId}")
    public ResponseEntity<?> findAllProductByStore(@PathVariable String storeId){
        //cerca prodotti tramite categoria
        List<ProductModel> store = productRepo.findAllProductByStore(storeId);
        return ResponseEntity.status(200).body(store);
    }

    @GetMapping("init")
    public ResponseEntity<?> init(){
        //creazione dei prodotti
        System.out.println("Products creation started...");
        productRepo.save(new ProductModel( "1234", "1234", "Gianduiotti", 2.0f, 0.1f, 100, "Dal morbido incontro di cioccolato finissimo e nocciole Piemonte, un piacere vellutato, coinvolgente e assolutamente inimitabile." , "images/gianduiotti.jpeg"));
        productRepo.save(new ProductModel( "5678", "1234", "Baci di dama", 1.0f, 0.2f, 150, "I baci di dama  chiamati così perché composti da due calotte di pasta unite dal cioccolato che richiamano due labbra intente a baciare." , "images/baci_di_dama.jpeg"));
        System.out.println("Products creation complete...");
        return ResponseEntity.status(200).body("Init complete...");
    }

}
