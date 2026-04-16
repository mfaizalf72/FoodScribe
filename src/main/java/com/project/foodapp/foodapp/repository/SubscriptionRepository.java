package com.project.foodapp.foodapp.repository;

import com.project.foodapp.foodapp.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);
    boolean existsByUserIdAndStatus(Long userId, String status);
}