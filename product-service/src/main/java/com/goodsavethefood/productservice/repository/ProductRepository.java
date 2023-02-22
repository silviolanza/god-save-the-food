package com.goodsavethefood.productservice.repository;

import com.goodsavethefood.productservice.model.ProductModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository  extends MongoRepository<ProductModel, String> {

    @Query("{productName:'?0'}")
    ProductModel findByProductName(String productName);

    @Query("{storeId:'?0'}")
    List<ProductModel> findAllProductByStore(String productCategory);

}