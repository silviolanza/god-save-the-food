package com.OrderService.Order_gsf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")

public class ProductGSF  {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

    @Column(name="idProduct")
    private int idProduct;
    @Column(name="price")
    private BigDecimal price;

    @Column(name="product_name")
    private String productName;
    @Column(name="description")
    private String description;

    @Column(name="quantity_available")
    private int quantity_available;
    /*@OneToMany
    @JsonIgnore
    @Column(name="item_id")
    private List<ItemsGSF> items;

*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /*public List<ItemsGSF> getItems() {
        return items;
    }

    public void setItems(List<ItemsGSF> items) {
        this.items = items;
    }*/

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }


    public ProductGSF() {}
}
