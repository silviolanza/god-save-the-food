package com.OrderService.Order_gsf.service;

import com.OrderService.Order_gsf.model.ItemsGSF;
import com.OrderService.Order_gsf.model.OrderGSF;
import com.OrderService.Order_gsf.repo.OrderGSFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderGSFServiceImpl implements OrderGSFService {
    @Autowired
    private OrderGSFRepository orderGSFRepository;

    @Override
    public OrderGSF saveOrder(OrderGSF order) {
        return orderGSFRepository.save(order);
    }

    public List<OrderGSF> getAllOrder() {
        List<OrderGSF> order= new ArrayList();
        orderGSFRepository.findAll().forEach(order :: add);
        return order;
    }
}
