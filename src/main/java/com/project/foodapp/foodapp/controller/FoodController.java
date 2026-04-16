package com.project.foodapp.foodapp.controller;

import com.project.foodapp.foodapp.dto.FoodDTO;
import com.project.foodapp.foodapp.entity.Food;
import com.project.foodapp.foodapp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins = "*")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/add")
    public ResponseEntity<String> addFood(@RequestBody FoodDTO dto) {
        String result = foodService.addFood(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFood() {
        return ResponseEntity.ok(foodService.getAllFood());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Food>> getFoodByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(foodService.getFoodByCategory(categoryId));
    }
}