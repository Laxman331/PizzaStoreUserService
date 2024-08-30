package com.pizzastoreuserservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzastoreuserservice.model.User;
import com.pizzastoreuserservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    UserRepository userRepository;
	
	
	public User registerCustomer(User user) {
		
		return userRepository.save(user);
	}

	
	public Optional<User> findCustomerByUsername(String username) {
		return userRepository.findByUsername(username);
	}


	public Optional<User> findCustomerById(Long userid) {
		return userRepository.findById(userid);
	}

	
	public List<User> getCustomers() {
		return userRepository.findAll();
	}

	
	public void deleteCustomerById(Long userid) {
		//userRepository.deleteById(userid);
		userRepository.deleteById(userid);
		
	}


	public User updateCustomer(User user) {
		return userRepository.save(user);
	}


	
	public void deleteCustomer(User user) {
		
		 userRepository.delete(user);;
	}

}
