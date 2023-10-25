package com.example.swigatto.repository;

import com.example.swigatto.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<FoodItem, Integer> {
}
