package com.example.swigatto.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CartResponse {

    double cartTotal;

    List<MenuResponse> foodItems;

}
