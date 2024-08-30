package com.pizzastoreuserservice.service;

import java.util.List;
import java.util.Optional;

import com.pizzastoreuserservice.model.User;

;

public interface UserService {
	  public User registerCustomer(User user);	  
	  public Optional<User> findCustomerByUsername(String username);
	  public Optional<User> findCustomerById(Long userid);     
	  public List<User> getCustomers();
	  public void deleteCustomerById(Long userid);
	  public User updateCustomer(User user);
	  public void deleteCustomer(User user);	

}	  

