package com.OrderService.Order_gsf.model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "orders")
public class OrderGSF {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column (name = "user_id")
        private String userid;

        @Column(name = "date")
        private LocalDate date;

        @Column(name="total")
        private BigDecimal total;

        @Column(name="status")
        private String status;
        @OneToMany
        @Column(name="item_id")
        private List<ItemsGSF> item;

        public Long getId() {
        return id;
    }


        public void setId(Long id) {
        this.id = id;
    }

        public String getUser() {
        return userid;
    }

        public void setUser(String user) {
        this.userid = user;
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

        public OrderGSF(String userid, LocalDate date, BigDecimal total, String status) {
            this.userid = userid;
            this.date = date;
            this.total = total;
            this.status = status;
           // this.item = item;
        }

        public OrderGSF(){}
}
