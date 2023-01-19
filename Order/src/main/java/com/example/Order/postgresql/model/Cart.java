package com.example.Order.postgresql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCart;
    @Column(name = "productID")
    private String productID;
    @Column(name = "quantity")
    private double quantity;

    public Cart() {
    }

    public Cart(long idCart, String productID, double quantity) {
        this.idCart = idCart;
        this.productID = productID;
        this.quantity = quantity;
    }

    public long getIdCart() {
        return idCart;
    }

    public void setIdCart(long idCart) {
        this.idCart = idCart;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

}
