package com.example.swigatto.dto.request;

import com.example.swigatto.Enum.RestaurantCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RestaurantRequest {

    String name;

    String location;

    RestaurantCategory restaurantCategory;

    String contactNumber;
}
