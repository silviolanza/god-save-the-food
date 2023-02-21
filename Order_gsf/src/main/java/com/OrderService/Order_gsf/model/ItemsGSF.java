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
    private Long id;

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

    public ItemsGSF(@NotNull int quantity, int idProduct, BigDecimal subTotal) {
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.subTotal = subTotal;
    }
    public ItemsGSF(@NotNull int quantity, int idProduct) {
        this.quantity = quantity;
        this.idProduct = idProduct;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public int getProduct() {
        return idProduct;
    }

    public void setProduct(int idProduct) {
        this.idProduct = idProduct;
    }


}
