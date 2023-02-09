package com.OrderService.Order_gsf.other_client;

import com.OrderService.Order_gsf.model.ProductGSF;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductGSFClient {
    @GetMapping(value = "/products/{id}")
    public ProductGSF getProductById(@PathVariable(value = "id") Long productId);
}
