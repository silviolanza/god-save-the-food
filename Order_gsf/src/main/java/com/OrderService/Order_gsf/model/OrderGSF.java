package com.OrderService.Order_gsf.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
public class OrderGSF {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @ManyToOne (cascade = CascadeType.ALL, targetEntity=UsersGSF.class)
        @JoinColumn (name = "user_id")
        private UsersGSF user;

        @Column(name = "date")
        private LocalDate date;

        @Column(name="total")
        private BigDecimal total;

        @Column(name="status")
        private String status;
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "cart" , joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn (name = "item_id"))
        private List<ItemsGSF> item;

        public long getId() {
        return id;
    }

        public void setId(long id) {
        this.id = id;
    }

        public void setId(Long id) {
        this.id = id;
    }

        public UsersGSF getUser() {
        return user;
    }

        public void setUser(UsersGSF user) {
        this.user = user;
    }

        public LocalDate getDate() {
        return date;
    }

        public void setDate(LocalDate date) {
        this.date = date;
    }

        public BigDecimal getTotal() {
        return total;
    }

        public void setTotal(BigDecimal total) {
        this.total = total;
    }

        public String getStatus() {
        return status;
    }

        public void setStatus(String status) {
        this.status = status;
    }

        public List<ItemsGSF> getItem() {
            return item;
        }

        public void setItem(List<ItemsGSF> item) {
            this.item = item;
        }

        public OrderGSF(Long id, UsersGSF user, LocalDate date, BigDecimal total, String status, List<ItemsGSF>item) {
            this.id = id;
            this.user = user;
            this.date = date;
            this.total = total;
            this.status = status;
            this.item = item;
        }

        public OrderGSF(){}
}
