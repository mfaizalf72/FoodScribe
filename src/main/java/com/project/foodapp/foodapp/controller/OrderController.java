package com.project.foodapp.foodapp.controller;

import com.project.foodapp.foodapp.dto.OrderDTO;
import com.project.foodapp.foodapp.entity.FoodTracking;
import com.project.foodapp.foodapp.entity.Order;
import com.project.foodapp.foodapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDTO dto) {
        String result = orderService.placeOrder(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    @GetMapping("/track/{orderNumber}")
    public ResponseEntity<List<FoodTracking>> trackOrder(@PathVariable String orderNumber) {
        return ResponseEntity.ok(orderService.trackOrder(orderNumber));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PutMapping("/status/{orderNumber}")
    public ResponseEntity<String> updateStatus(
            @PathVariable String orderNumber,
            @RequestParam String status,
            @RequestParam String remark) {
        String result = orderService.updateOrderStatus(orderNumber, status, remark);
        return ResponseEntity.ok(result);
    }
}