package com.project.foodapp.foodapp.repository;

import com.project.foodapp.foodapp.entity.FoodTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodTrackingRepository extends JpaRepository<FoodTracking, Long> {
    List<FoodTracking> findByOrderNumber(String orderNumber);
}