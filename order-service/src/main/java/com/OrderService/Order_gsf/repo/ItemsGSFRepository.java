package com.OrderService.Order_gsf.repo;

import com.OrderService.Order_gsf.model.ItemsGSF;
import com.OrderService.Order_gsf.model.ProductGSF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ItemsGSFRepository extends CrudRepository<ItemsGSF,Long> {
    //ProductGSF findByIdProduct(Integer idProduct);
}
