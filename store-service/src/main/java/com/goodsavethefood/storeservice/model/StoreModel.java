package com.goodsavethefood.storeservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document("Stores")
public class StoreModel {

    @Id
    private String storeId;
    private String storeName;
    private String VATid;
    private String storeAddress;
    private Boolean shippingAvailable;
    private String storeOwnerId;
    private String storeCategory;
    private String storeDescription;
    private String storeLogo;

    public String getId() {
        return storeId;
    }

    public void setId(String id) {
        this.storeId = id;
    }

    public String getName() {
        return storeName;
    }

    public void setName(String name) {
        this.storeName = name;
    }

    public String getVATid() {
        return VATid;
    }

    public void setVATid(String VATid) {
        this.VATid = VATid;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public Boolean getShippingAvailable() {
        return shippingAvailable;
    }

    public void setShippingAvailable(Boolean shippingAvailable){
        this.shippingAvailable = shippingAvailable;
    }

    public String getStoreOwnerId() {
        return storeOwnerId;
    }

    public void setStoreOwnerId(String storeOwnerId) {
        this.storeOwnerId = storeOwnerId;
    }

    public String getStoreCategory() {
        return storeCategory;
    }

    public void setStoreCategory(String storeCategory) {
        this.storeCategory = storeCategory;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }
}