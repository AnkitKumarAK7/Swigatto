package com.example.swigatto.model;

import com.example.swigatto.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
@Table(name = "delivery_partner")

public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true, nullable = false)
    String mobileNo;

    @Enumerated(EnumType.STRING)
    Gender gender;
}
