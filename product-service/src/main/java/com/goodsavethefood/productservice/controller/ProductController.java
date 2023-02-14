package com.goodsavethefood.productservice.controller;

import com.goodsavethefood.productservice.model.ProductModel;
import com.goodsavethefood.productservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/products/")

public class ProductController {
    @Autowired
    ProductRepository productRepo;
    @GetMapping("name/{productName}")
    public ResponseEntity<?> findStore(@PathVariable String productName){
        //creazione di un prodotto
        System.out.println("Store creation started...");
        productRepo.save(new ProductModel( "1", "1234", "Gianduiotti", 1.0f, 0.1f, 100, "Dal morbido incontro di cioccolato finissimo e nocciole Piemonte, un piacere vellutato, coinvolgente e assolutamente inimitabile." , "images/gianduiotti.jpeg"));
        System.out.println("Store creation complete...");
        //cerca prodotto tramite il nome
        ProductModel product = productRepo.findByProductName(productName);
        //stampa oggetto store
        return ResponseEntity.status(201).body(product);
    }

}
