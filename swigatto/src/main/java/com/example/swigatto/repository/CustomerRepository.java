package com.example.swigatto.repository;

import com.example.swigatto.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer findByMobileNo(String mobile);
}
