package com.example.swigatto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@Entity
@Builder
@Data
@Table(name = "customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Email
    @Column(unique = true)
    String email;

    String address;

    @Column(unique= true, nullable = false)
    String mobileNo;


}
