package com.example.Order.postgresql.repo;

import com.example.Order.postgresql.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
