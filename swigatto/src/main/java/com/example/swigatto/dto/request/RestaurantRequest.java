package com.example.swigatto.dto.request;

import com.example.swigatto.Enum.RestaurantCategory;
import com.example.swigatto.model.Restaurant;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class RestaurantRequest {

    String name;

    String location;

    RestaurantCategory restaurantCategory;

    String contactNo;
}
