package com.OrderService.Order_gsf.service;

import com.OrderService.Order_gsf.model.OrderGSF;
import java.util.List;

public interface OrderGSFService {
 public OrderGSF saveOrder(OrderGSF order);
 public List<OrderGSF> getAllOrder();
}
