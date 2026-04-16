package com.project.foodapp.foodapp.service;

import com.project.foodapp.foodapp.dto.SubscriptionDTO;
import com.project.foodapp.foodapp.entity.Subscription;
import com.project.foodapp.foodapp.entity.SubscriptionAddress;
import com.project.foodapp.foodapp.repository.SubscriptionAddressRepository;
import com.project.foodapp.foodapp.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionAddressRepository subscriptionAddressRepository;

    public String subscribe(SubscriptionDTO dto) {

        // Check if user already has an active subscription
        if (subscriptionRepository.existsByUserIdAndStatus(dto.getUserId(), "Active")) {
            return "You already have an active subscription!";
        }

        // Generate subscription number
        String orderNumber = String.valueOf(100000000 + new Random().nextInt(900000000));

        // Calculate end date based on period
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate;

        switch (dto.getSubscriptionPeriod().toLowerCase()) {
            case "weekly":
                endDate = startDate.plusWeeks(1);
                break;
            case "monthly":
                endDate = startDate.plusMonths(1);
                break;
            case "yearly":
                endDate = startDate.plusYears(1);
                break;
            default:
                return "Invalid subscription period! Choose weekly, monthly or yearly.";
        }

        // Save subscription
        Subscription subscription = new Subscription();
        subscription.setUserId(dto.getUserId());
        subscription.setFoodId(dto.getFoodId());
        subscription.setOrderNumber(orderNumber);
        subscription.setSubscriptionPeriod(dto.getSubscriptionPeriod());
        subscription.setStartDate(startDate);
        subscription.setEndDate(endDate);
        subscription.setStatus("Active");
        subscriptionRepository.save(subscription);

        // Save subscription address
        SubscriptionAddress address = new SubscriptionAddress();
        address.setUserId(dto.getUserId());
        address.setOrderNumber(orderNumber);
        address.setFlatBuildingNo(dto.getFlatBuildingNo());
        address.setStreetName(dto.getStreetName());
        address.setArea(dto.getArea());
        address.setLandmark(dto.getLandmark());
        address.setCity(dto.getCity());
        address.setOrderTime(LocalDateTime.now());
        subscriptionAddressRepository.save(address);

        return "Subscription activated successfully! " +
                "Your subscription number is: " + orderNumber +
                ". Valid till: " + endDate.toLocalDate();
    }

    // Get subscriptions by user
    public List<Subscription> getSubscriptionsByUser(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    // Get all subscriptions (admin)
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    // Cancel subscription
    public String cancelSubscription(Long subscriptionId) {
        Subscription subscription = subscriptionRepository
                .findById(subscriptionId)
                .orElse(null);

        if (subscription == null) {
            return "Subscription not found!";
        }

        subscription.setStatus("Cancelled");
        subscriptionRepository.save(subscription);

        return "Subscription cancelled successfully!";
    }
}