package com.example.swigatto.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class OrderResponse {
    String orderId;  //UUID

    double orderTotal;

    Date orderTime;

    String customerName;

    String customerMobile;

    String deliveryPartnerName;

    String deliveryPartnerMobile;

    String restaurantName;

    List<FoodResponse> foodResponse;
}
