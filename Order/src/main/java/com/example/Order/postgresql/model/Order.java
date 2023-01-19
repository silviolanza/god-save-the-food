package com.example.Order.postgresql.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idOrder;
    @Column(name = "userID")
    private String userID;
    @Column(name = "date")
    private Date date;
    @Column(name = "total")
    private double total;
    @Column(name = "state")
    private String state;

    @OneToOne
    @JoinColumn(name = "CartId", nullable = false)
    private Cart cart;


    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date= date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Order() {
    }

    public Order(long idOrder, String userID, Date date, double total, String state, Cart cart) {
        this.idOrder = idOrder;
        this.userID = userID;
        this.date = date;
        this.total = total;
        this.state = state;
        this.cart = cart;
    }
}
