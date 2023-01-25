package com.goodsavethefood.storeservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.goodsavethefood.storeservice.model.StoreModel;

public interface StoreRepository extends MongoRepository<StoreModel, String> {

    @Query("{storeName:'?0'}")
    StoreModel findByStoreName(String storeName);

    @Query("{storeCategory:'?0'}")
    List<StoreModel> findAllStoreByCategory(String storeCategory);

}
