package com.OrderService.Order_gsf.repo;

import com.OrderService.Order_gsf.model.ItemsGSF;
import com.OrderService.Order_gsf.model.OrderGSF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrderGSFRepository extends CrudRepository<OrderGSF,Long> {
    //ArrayList<ItemsGSF> findAllById(Long orderId);
}
