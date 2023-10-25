package com.example.swigatto.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CartStatusResponse {

    String customerName;

    String customerAddress;

    String customerMobile;

    double cartTotal;

    List<FoodResponse> foodList;

    String restaurantName;
}
