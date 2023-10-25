package com.example.swigatto.service;

import com.example.swigatto.dto.response.OrderResponse;
import com.example.swigatto.exception.CustomerNotFoundException;
import com.example.swigatto.exception.EmptyCartException;
import com.example.swigatto.model.*;
import com.example.swigatto.repository.CustomerRepository;
import com.example.swigatto.repository.DeliveryPartnerRepository;
import com.example.swigatto.repository.OrderEntityRepository;
import com.example.swigatto.repository.RestaurantRepository;
import com.example.swigatto.transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

     final CustomerRepository customerRepository;
     final DeliveryPartnerRepository deliveryPartnerRepository;

     final OrderEntityRepository orderEntityRepository;

     final RestaurantRepository restaurantRepository;

     @Autowired
     public OrderService(CustomerRepository customerRepository,
                         DeliveryPartnerRepository deliveryPartnerRepository, OrderEntityRepository orderEntityRepository, RestaurantRepository restaurantRepository){
         this.customerRepository = customerRepository;
         this.deliveryPartnerRepository = deliveryPartnerRepository;
         this.orderEntityRepository = orderEntityRepository;
         this.restaurantRepository = restaurantRepository;
     }

    public OrderResponse placeOrder(String customerMobile) {

         // verify the customer
        Customer customer = customerRepository.findByMobileNo(customerMobile);
        if(customer == null){
            throw new CustomerNotFoundException("Invalid mobile number!!!");
        }

        // verify the cart is empty or not
        Cart cart = customer.getCart();
        if(cart.getFoodItems().size() == 0){
             throw new EmptyCartException("Sorry! Your cart is empty!!!");
        }

        // find a delivery partner to deliver Randomly
        DeliveryPartner partner = deliveryPartnerRepository.findRandomDeliveryPartner();
        Restaurant restaurant = cart.getFoodItems().get(0).getMenuItem().getRestaurant();


        //prepare the order entity
        OrderEntity order = OrderTransformer.prepareOrderEntity(cart);

        OrderEntity savedOrder = orderEntityRepository.save(order);

        order.setCustomer(customer);
        order.setDeliveryPartner(partner);
        order.setRestaurant(restaurant);
        order.setFoodItems(cart.getFoodItems());

        customer.getOrders().add(savedOrder);
        partner.getOrders().add(savedOrder);
        restaurant.getOrders().add(savedOrder);

        for(FoodItem foodItem: cart.getFoodItems()){
            foodItem.setCart(null);
            foodItem.setOrder(savedOrder);
        }

        clearCart(cart);

        customerRepository.save(customer);
        deliveryPartnerRepository.save(partner);
        restaurantRepository.save(restaurant);

        //prepare orderresponse
        return OrderTransformer.OrderToOrderResponse(savedOrder);

    }

    private void clearCart(Cart cart){

         cart.setCartTotal(0);
         cart.setFoodItems(new ArrayList<>());
    }
}
