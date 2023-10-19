package com.example.swigatto.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CustomerResponse {

    String name;

    String mobileNo;

    String address;

    CartResponse cart;
}
