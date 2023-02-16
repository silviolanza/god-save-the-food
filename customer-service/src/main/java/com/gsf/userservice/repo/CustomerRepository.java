package com.gsf.userservice.repo;

import com.gsf.userservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findById(long id);
    List<Customer> findByCf(String cf);
    Customer findByEmail(String email);
    Customer findByEmailAndPassword(String email, String password);


}
