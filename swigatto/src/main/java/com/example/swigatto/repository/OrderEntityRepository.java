package com.example.swigatto.repository;

import com.example.swigatto.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer> {
}
