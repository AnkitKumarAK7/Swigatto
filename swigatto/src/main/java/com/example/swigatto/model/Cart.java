package com.example.swigatto.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
@Table(name = "cart")


public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int cartTotal;
}
