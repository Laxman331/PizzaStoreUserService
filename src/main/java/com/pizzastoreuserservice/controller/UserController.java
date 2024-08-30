package com.pizzastoreuserservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzastoreuserservice.model.User;
import com.pizzastoreuserservice.service.UserServiceImpl;

@Controller
@ResponseBody
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;  // Corrected the variable name

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Returns /WEB-INF/views/register.jsp
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerCustomer(@RequestBody User user) {
        User newUser = userService.registerCustomer(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
    @PutMapping("/updateuser")
    public ResponseEntity<User> updateCustomer(@RequestBody User user) {
        User updatedUser = userService.updateCustomer(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Returns /WEB-INF/views/login.jsp
    }
    
    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getCustomers() {
        List<User> customers = userService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);  // Changed status to OK
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<User>> findCustomerByUsername(@PathVariable String username) {
        Optional<User> user = userService.findCustomerByUsername(username);
        return user.isPresent() ? 
            new ResponseEntity<>(user, HttpStatus.OK) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    
    @DeleteMapping("/deleteuser/{userid}")
    public ResponseEntity<User> deleteCustomerById(@PathVariable Long userid) {
        userService.deleteCustomerById(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
