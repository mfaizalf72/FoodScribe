package com.project.foodapp.foodapp.repository;

import com.project.foodapp.foodapp.entity.SubscriptionAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionAddressRepository extends JpaRepository<SubscriptionAddress, Long> {
}