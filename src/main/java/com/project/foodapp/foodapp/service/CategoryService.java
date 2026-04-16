package com.project.foodapp.foodapp.service;

import com.project.foodapp.foodapp.dto.CategoryDTO;
import com.project.foodapp.foodapp.entity.Category;
import com.project.foodapp.foodapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Add new category
    public String addCategory(CategoryDTO dto) {

        if (categoryRepository.existsByCategoryName(dto.getCategoryName())) {
            return "Category already exists!";
        }

        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        category.setCreationDate(LocalDateTime.now());

        categoryRepository.save(category);

        return "Category added successfully!";
    }

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}