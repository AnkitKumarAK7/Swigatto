package com.example.swigatto.dto.request;

import com.example.swigatto.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CustomerRequest {

    String name;

    String email;

    String address;

    String mobileNo;

    Gender gender;
}
