package com.example.swigatto.controller;

import com.example.swigatto.dto.request.RestaurantRequest;
import com.example.swigatto.dto.response.RestaurantResponse;
import com.example.swigatto.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class  RestaurantController {

    final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/add")
    public ResponseEntity addRestaurant(@RequestBody RestaurantRequest restaurantRequest){
       RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
       return new ResponseEntity(restaurantResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/status")
    public ResponseEntity changeOpenedStatus(@RequestParam int id){
        String message = restaurantService.changeOpenedStatus(id);

        }
    }
}
