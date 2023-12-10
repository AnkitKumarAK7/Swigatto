package com.example.swigatto.controller;

import com.example.swigatto.dto.request.CustomerRequest;
import com.example.swigatto.dto.response.CustomerResponse;
import com.example.swigatto.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;  //field injection

    /*
    Constructor Injection ---> Always use in enterprise application
     */

//    final CustomerService customerService;
//
//    @Autowired
//    public CustomerController(CustomerService customerService){
//
//        this.customerService = customerService;
//    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
        return new ResponseEntity(customerResponse, HttpStatus.CREATED);
    }

    @GetMapping("/find/mobile/{mobile}")
    public ResponseEntity getCustomerByMobile(@PathVariable("mobile") String mobile){
        try {
            CustomerResponse customerResponse = customerService.findCustomerByMobile(mobile);
            return new ResponseEntity(customerResponse,HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // get the customer with most number of orders



    // get the female customer with the least number of orders
}
