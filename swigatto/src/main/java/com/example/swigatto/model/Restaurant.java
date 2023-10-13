package com.example.swigatto.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
@Table(name = "restaurant")

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
}
