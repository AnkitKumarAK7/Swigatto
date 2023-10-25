package com.example.swigatto.model;


import com.example.swigatto.Enum.FoodCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
@Table(name = "menu")

public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String dishName;

    double price;

    @Enumerated(EnumType.STRING)
    FoodCategory category;

    boolean veg;

    boolean available;

    @ManyToOne
    @JoinColumn
    Restaurant restaurant;

    @OneToMany(mappedBy = "menuItem" ,cascade = CascadeType.ALL)
    List<FoodItem> foodItems = new ArrayList<>();
}
