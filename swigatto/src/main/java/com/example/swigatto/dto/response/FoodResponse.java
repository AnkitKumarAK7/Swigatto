package com.example.swigatto.dto.response;

import com.example.swigatto.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class FoodResponse {

    String dishName;

    double price;

    FoodCategory foodCategory;

    boolean veg;

}
