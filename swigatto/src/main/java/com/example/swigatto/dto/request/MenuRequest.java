package com.example.swigatto.dto.request;

import com.example.swigatto.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class MenuRequest {

    int restaurantId;

    String dishName;

    double price;

    FoodCategory category;

    boolean veg;

    boolean available;
}
