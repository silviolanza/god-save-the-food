package com.OrderService.Order_gsf.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table (name = "items")
public class ItemsGSF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "quantity")
    @NotNull
    private Integer quantity;

    @Column (name = "subtotal")
    @NotNull
    private BigDecimal subTotal;

    @Column (name = "idProduct")
    @JsonIgnore
    private Integer idProduct;


    public ItemsGSF() {}

    public ItemsGSF( int quantity, int idProduct, BigDecimal subTotal) {
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.subTotal = subTotal;
    }
    public ItemsGSF( int quantity, int idProduct) {
        this.quantity = quantity;
        this.idProduct = idProduct;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getProduct() {
        return idProduct;
    }

    public void setProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }


}
