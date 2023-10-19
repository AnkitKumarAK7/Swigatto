package com.example.swigatto.transformer;

import com.example.swigatto.dto.response.FoodResponse;
import com.example.swigatto.model.FoodItem;

public class FoodItemTransformer {

    public static FoodResponse FoodItemToFoodResponse(FoodItem foodItem){

        return FoodResponse.builder()
                .dishName(foodItem.getDishName())
                .price(foodItem.getPrice())
                .veg(foodItem.isVeg())
                .category(foodItem.getCategory())
                .build();
    }
}
