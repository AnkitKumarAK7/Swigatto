package com.example.swigatto.service;

import com.example.swigatto.dto.request.CustomerRequest;
import com.example.swigatto.dto.response.CustomerResponse;
import com.example.swigatto.exception.CustomerNotFoundException;
import com.example.swigatto.model.Cart;
import com.example.swigatto.model.Customer;
import com.example.swigatto.repository.CustomerRepository;
import com.example.swigatto.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        // dto -> customer model
        Customer customer = CustomerTransformer.CustomerRequestToCustomer(customerRequest);

        //allocate a card
        Cart cart = Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();

        customer.setCart(cart);

        //save both customer and cart
        Customer saveCustomer = customerRepository.save(customer);

        // prepare response Dto
        return CustomerTransformer.CustomerToCustomerResponse(saveCustomer);
    }

    public CustomerResponse findCustomerByMobile(String mobile) {

        Customer customer = customerRepository.findByMobileNo(mobile);
        if(customer == null){
            throw new CustomerNotFoundException("Invalid mobile no!!");
        }
        return CustomerTransformer.CustomerToCustomerResponse(customer);
    }
}
