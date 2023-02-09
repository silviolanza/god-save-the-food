package com.OrderService.Order_gsf.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UsersGSF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @OneToMany (mappedBy = "user", targetEntity=OrderGSF.class)
    @JsonIgnore
    private List<OrderGSF> orders;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<OrderGSF> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderGSF> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersGSF(Long id, String userName, List<OrderGSF> orders) {
        this.id = id;
        this.userName = userName;
        this.orders = orders;
    }

    public UsersGSF() {
    }
}