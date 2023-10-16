package com.example.swigatto.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder


public class RestaurantResponse {

    String name;

    String contactNumber;

    String location;

    boolean opened;

    List<FoodResponse> menu;
}
