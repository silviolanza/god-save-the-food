package com.gsf.userservice.controller;

import com.gsf.userservice.model.Customer;
import com.gsf.userservice.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    CustomerRepository repository;

    @GetMapping(value = "/customers/profile/email/{email}")
    public Customer findByEmail(@PathVariable String email) {return repository.findByEmail(email);}

    @GetMapping(value = "/customers/profile/cf/{cf}")
    public List<Customer> findByCf(@PathVariable String cf) {
        return repository.findByCf(cf);
    }

    @GetMapping(value = "/customers/test")
    public String test(){return "hello world";}
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        System.out.println("Get all Customers...");

        List<Customer> customers = new ArrayList<>();
        repository.findAll().forEach(customers::add);

        return customers;
    }
    @PostMapping(value = "/customers/create")
    public Customer postCustomer(@RequestBody Customer customer) {
        return repository.save(new Customer(customer.getName(), customer.getFirstName(),customer.getEmail(), customer.getCf(), customer.getAddress(), customer.getAge(), customer.getPassword()));
    }
    @PostMapping(value = "/customers/create1")
    public Customer postCustomer1() {
        return repository.save(new Customer("luc","luc@luc","oddone","via Luc","cas24sf4",78, "psw"));
    }
    @PostMapping (value = "/login/{mail}")
    public ResponseEntity<?> login(@PathVariable String mail, @RequestBody String password) {

        Customer user1 = repository.findByEmailAndPassword(mail, password);
        if(user1 != null) {
            return new ResponseEntity<>(user1, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new ResponseModel("not found"), HttpStatus.NOT_FOUND);
        }
    }
}
