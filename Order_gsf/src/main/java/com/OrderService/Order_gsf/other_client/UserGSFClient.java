package com.OrderService.Order_gsf.other_client;

import com.OrderService.Order_gsf.model.ProductGSF;
import com.OrderService.Order_gsf.model.UsersGSF;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserGSFClient {
    @GetMapping(value = "/user/{id}")
    public UsersGSF getUserById(@PathVariable(value = "id") Long productId);
}
