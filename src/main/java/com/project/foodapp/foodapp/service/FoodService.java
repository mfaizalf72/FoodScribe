package com.project.foodapp.foodapp.service;

import com.project.foodapp.foodapp.dto.FoodDTO;
import com.project.foodapp.foodapp.entity.Food;
import com.project.foodapp.foodapp.repository.CategoryRepository;
import com.project.foodapp.foodapp.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Add new food item
    public String addFood(FoodDTO dto) {

        // Check if category exists
        if (!categoryRepository.existsById(dto.getCategoryId())) {
            return "Category not found!";
        }

        Food food = new Food();
        food.setItemName(dto.getItemName());
        food.setItemPrice(dto.getItemPrice());
        food.setItemDescription(dto.getItemDescription());
        food.setCategoryId(dto.getCategoryId());

        food.setImageUrl(dto.getImageUrl());

        foodRepository.save(food);

        return "Food item added successfully!";
    }

    // Get all food items
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    // Get food by category
    public List<Food> getFoodByCategory(Long categoryId) {
        return foodRepository.findByCategoryId(categoryId);
    }
}