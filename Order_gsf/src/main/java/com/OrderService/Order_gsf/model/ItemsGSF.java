package com.OrderService.Order_gsf.model;



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

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "product_id")
    private ProductGSF product;

    @ManyToMany (mappedBy = "item")
    private List<OrderGSF> orders;

    public ItemsGSF() {}

    public ItemsGSF(@NotNull int quantity, ProductGSF product, BigDecimal subTotal) {
        this.quantity = quantity;
        this.product = product;
        this.subTotal = subTotal;
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

    public ProductGSF getProduct() {
        return product;
    }

    public void setProduct(ProductGSF product) {
        this.product = product;
    }

    public List<OrderGSF> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderGSF> orders) {
        this.orders = orders;
    }
}
