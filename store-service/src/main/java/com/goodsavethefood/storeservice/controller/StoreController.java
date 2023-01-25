package com.goodsavethefood.storeservice.controller;

import com.goodsavethefood.storeservice.model.StoreModel;
import com.goodsavethefood.storeservice.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/stores")

public class StoreController {
    @Autowired
    StoreRepository storeRepo;
    @GetMapping("/name/{storeName}")
    public ResponseEntity<?> findStore(@PathVariable String storeName){
        //creazione di un negozio
        System.out.println("Store creation started...");
        storeRepo.save(new StoreModel("1234", "Stratta", "00471870014", "Piazza S. Carlo, 191", true, "1234", "pasticceria", "Siamo una delle pasticcerie più antiche della città di Torino. Stratta nasce nel 1836 come confetteria e fornitore ufficiale della Real Casa e di Camillo Benso Conte di Cavour. Oggi è uno dei locali storici più rinomati di Torino, alla cui base del nostro successo c’è un valore imprescindibile: La famiglia.", "images/stratta.jpeg"));
        System.out.println("Store creation complete...");
        //cerca oggetto tramite il nome
        StoreModel store = storeRepo.findByStoreName(storeName);
        //stampa oggetto store
        return ResponseEntity.status(201).body(store);
    }

}
