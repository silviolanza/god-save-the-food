package com.goodsavethefood.storeservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("stores")
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

    public StoreModel(String storeId, String storeName, String VATid, String storeAddress, Boolean shippingAvailable, String storeOwnerId, String storeCategory, String storeDescription, String storeLogo) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.VATid = VATid;
        this.storeAddress = storeAddress;
        this.shippingAvailable = shippingAvailable;
        this.storeOwnerId = storeOwnerId;
        this.storeCategory = storeCategory;
        this.storeDescription = storeDescription;
        this.storeLogo = storeLogo;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public void setShippingAvailable(Boolean shippingAvailable) {
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