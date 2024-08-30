package com.pizzastoreuserservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pizzastoreuserservice.model.Order;
import com.pizzastoreuserservice.model.User;
import com.pizzastoreuserservice.service.OrderServiceImpl;
import com.pizzastoreuserservice.service.UserServiceImpl;


@Controller
@ResponseBody
@RequestMapping("/api/orders")
public class OrderController {
	   @Autowired
	    private OrderServiceImpl orderService;

	    @Autowired
	    private UserServiceImpl userService;

	    @PostMapping("/create/{userid}")
	    public ResponseEntity<Order> createOrder(@PathVariable Long userid, @RequestBody Order order) {
	        Optional<User> user = userService.findCustomerById(userid);
	        if (user.isPresent()) {
	            order.setUser(user.get());
	            Order newOrder = orderService.saveOrder(order);
	            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userid) {
	        Optional<User> user = userService.findCustomerById(userid);
	        if (user.isPresent()) {
	            List<Order> orders = orderService.findOrdersByUser(user.get());
	            return new ResponseEntity<>(orders, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/{orderid}")
	    public ResponseEntity<Order> getOrderById(@PathVariable Long orderid) {
	        Order order = orderService.findOrderById(orderid);
	        if (order != null) {
	            return new ResponseEntity<>(order, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
