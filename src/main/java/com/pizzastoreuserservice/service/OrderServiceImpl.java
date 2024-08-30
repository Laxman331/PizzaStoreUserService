package com.pizzastoreuserservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzastoreuserservice.model.Order;
import com.pizzastoreuserservice.model.User;
import com.pizzastoreuserservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
  
	@Autowired
	OrderRepository orderRepository;
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
    public Order findOrderById(Long orderid) {
        return orderRepository.findById(orderid).orElse(null);
    }

	@Override
	public List<Order> findOrdersByUser(User user) {
		// TODO Auto-generated method stub
		return orderRepository.findByUser(user);
	}

}
