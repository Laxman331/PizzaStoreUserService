package com.pizzastoreuserservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzastoreuserservice.model.Order;
import com.pizzastoreuserservice.model.User;




@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByUser(User user);
}

