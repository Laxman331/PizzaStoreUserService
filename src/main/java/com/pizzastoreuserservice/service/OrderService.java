package com.pizzastoreuserservice.service;

import java.util.List;


import com.pizzastoreuserservice.model.Order;
import com.pizzastoreuserservice.model.User;

public interface OrderService {
	public Order saveOrder(Order order);
	//public Optional<Order>findOrderById(Long id);
	public List<Order> findOrdersByUser(User user);
    public Order findOrderById(Long orderid);
}
