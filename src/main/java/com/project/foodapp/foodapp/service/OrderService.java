package com.project.foodapp.foodapp.service;

import com.project.foodapp.foodapp.dto.OrderDTO;
import com.project.foodapp.foodapp.entity.FoodTracking;
import com.project.foodapp.foodapp.entity.Order;
import com.project.foodapp.foodapp.entity.OrderAddress;
import com.project.foodapp.foodapp.repository.FoodTrackingRepository;
import com.project.foodapp.foodapp.repository.OrderAddressRepository;
import com.project.foodapp.foodapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderAddressRepository orderAddressRepository;

    @Autowired
    private FoodTrackingRepository foodTrackingRepository;

    // Place a new order
    public String placeOrder(OrderDTO dto) {

        // Generate a random order number
        String orderNumber = String.valueOf(100000000 + new Random().nextInt(900000000));

        // Save order
        Order order = new Order();
        order.setUserId(dto.getUserId());
        order.setFoodId(dto.getFoodId());
        order.setOrderNumber(orderNumber);
        order.setIsOrderPlaced(true);
        order.setOrderTime(LocalDateTime.now());
        orderRepository.save(order);

        // Save delivery address
        OrderAddress address = new OrderAddress();
        address.setUserId(dto.getUserId());
        address.setOrderNumber(orderNumber);
        address.setFlatBuildingNo(dto.getFlatBuildingNo());
        address.setStreetName(dto.getStreetName());
        address.setArea(dto.getArea());
        address.setLandmark(dto.getLandmark());
        address.setCity(dto.getCity());
        address.setOrderFinalStatus("Order Placed");
        address.setOrderTime(LocalDateTime.now());
        orderAddressRepository.save(address);

        // Create initial tracking entry
        FoodTracking tracking = new FoodTracking();
        tracking.setOrderNumber(orderNumber);
        tracking.setStatus("Order Placed");
        tracking.setRemark("Your order has been placed successfully");
        tracking.setStatusDate(LocalDateTime.now());
        foodTrackingRepository.save(tracking);

        return "Order placed successfully! Your order number is: " + orderNumber;
    }

    // Get orders by user
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // Track order by order number
    public List<FoodTracking> trackOrder(String orderNumber) {
        return foodTrackingRepository.findByOrderNumber(orderNumber);
    }

    // Get all orders (admin)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Update order status (admin)
    public String updateOrderStatus(String orderNumber, String status, String remark) {

        // Add new tracking entry
        FoodTracking tracking = new FoodTracking();
        tracking.setOrderNumber(orderNumber);
        tracking.setStatus(status);
        tracking.setRemark(remark);
        tracking.setStatusDate(LocalDateTime.now());
        foodTrackingRepository.save(tracking);

        // Update final status in address table
        OrderAddress address = orderAddressRepository
                .findByOrderNumber(orderNumber)
                .orElse(null);

        if (address != null) {
            address.setOrderFinalStatus(status);
            orderAddressRepository.save(address);
        }

        return "Order status updated to: " + status;
    }
}