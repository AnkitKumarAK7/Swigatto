package com.example.swigatto.dto.response;

import com.example.swigatto.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class MenuResponse {

    String dishName;

    double price;

    FoodCategory category;

    boolean veg;

}
