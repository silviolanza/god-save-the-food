package com.goodsavethefood.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class ProductModel {
    @Id
    private String  productId;
    private String  storeId;
    private String  productName;
    private Float   productPrice;
    private Float   productSale;
    private Integer productAvailableQty;
    private String  productDescription;
    private String  productImage;

    public ProductModel(String productId, String storeId, String productName, Float productPrice, Float productSale, Integer productAvailableQty, String productDescription, String productImage) {
        this.productId = productId;
        this.storeId = storeId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSale = productSale;
        this.productAvailableQty = productAvailableQty;
        this.productDescription = productDescription;
        this.productImage = productImage;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Float getProductSale() {
        return productSale;
    }

    public void setProductSale(Float productSale) {
        this.productSale = productSale;
    }

    public Integer getProductAvailableQty() {
        return productAvailableQty;
    }

    public void setProductAvailableQty(Integer productAvailableQty) {
        this.productAvailableQty = productAvailableQty;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
