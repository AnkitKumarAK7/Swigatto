package com.example.swigatto.service;

import com.example.swigatto.dto.request.RestaurantRequest;
import com.example.swigatto.dto.response.RestaurantResponse;
import com.example.swigatto.model.Restaurant;
import com.example.swigatto.repository.RestaurantRepository;
import com.example.swigatto.transformer.RestaurantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        // dto -> model
        Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);

        //persist/save the model in db
        Restaurant saveRestaurant = restaurantRepository.save(restaurant);

        //prepare response dto from model
        return RestaurantTransformer.RestaurantToRestaurantResponse(saveRestaurant);
    }
}

