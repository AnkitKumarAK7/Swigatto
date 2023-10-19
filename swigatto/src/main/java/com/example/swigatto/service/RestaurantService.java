package com.example.swigatto.service;

import com.example.swigatto.dto.request.FoodRequest;
import com.example.swigatto.dto.request.RestaurantRequest;
import com.example.swigatto.dto.response.RestaurantResponse;
import com.example.swigatto.exception.RestaurantNotFoundException;
import com.example.swigatto.model.FoodItem;
import com.example.swigatto.model.Restaurant;
import com.example.swigatto.repository.RestaurantRepository;
import com.example.swigatto.transformer.FoodItemTransformer;
import com.example.swigatto.transformer.RestaurantTransformer;
import com.example.swigatto.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {
    final RestaurantRepository restaurantRepository;
    final ValidationUtils validationUtils;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, ValidationUtils validationUtils) {
        this.restaurantRepository = restaurantRepository;
        this.validationUtils = validationUtils;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        // dto -> model
        Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);
        // persist/save the model in db
       Restaurant savedRestaurant = restaurantRepository.save(restaurant);
       // prepare response dto from model
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);
    }

    public String changeOpenedStatus(int id) {

        //check whether id is valid or not
//        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
//        if(restaurantOptional.isEmpty()){
//           throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
//        }

        if(!validationUtils.validateRestaurantId(id)){
            throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
        }

       // Restaurant restaurant = restaurantOptional.get();
        Restaurant restaurant = restaurantRepository.findById(id).get();
        restaurant.setOpened(!restaurant.isOpened());
        restaurantRepository.save(restaurant);

        if(restaurant.isOpened()){
            return "Restaurant is opened now !!!";
        }
        return "Restaurant is closed";
    }

    public RestaurantResponse addFoodItemToRestaurant(FoodRequest foodRequest) {

        //check restaurant is valid or not
//        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(foodRequest.getRestaurantId());
//        if(restaurantOptional.isEmpty()){
//            throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
//        }
//
//        Restaurant restaurant = restaurantOptional.get();

        if(!validationUtils.validateRestaurantId(foodRequest.getRestaurantId())){
            throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
        }

        Restaurant restaurant = restaurantRepository.findById(foodRequest.getRestaurantId()).get();
        // make food entity
        FoodItem foodItem = FoodItemTransformer.FoodRequestToFoodItem(foodRequest);
        foodItem.setRestaurant(restaurant);

        restaurant.getAvailableFoodItems().add(foodItem);

        // save rest and food
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        // prepare response
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);

    }
}
