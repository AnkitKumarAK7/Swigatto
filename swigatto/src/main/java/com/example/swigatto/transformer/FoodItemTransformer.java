package com.example.swigatto.transformer;

import com.example.swigatto.dto.request.FoodRequest;
import com.example.swigatto.dto.response.FoodResponse;
import com.example.swigatto.model.FoodItem;

public class FoodItemTransformer {

    public static FoodItem FoodRequestToFoodItem(FoodRequest foodRequest){
        return FoodItem.builder()
                .dishName(foodRequest.getDishName())
                .price(foodRequest.getPrice())
                .category(foodRequest.getCategory())
                .veg(foodRequest.isVeg())
                .available(foodRequest.isAvailable())
                .build();
    }

    public static FoodResponse FoodItemToFoodResponse(FoodItem foodItem){

        return FoodResponse.builder()
                .dishName(foodItem.getDishName())
                .price(foodItem.getPrice())
                .veg(foodItem.isVeg())
                .category(foodItem.getCategory())
                .build();
    }
}
