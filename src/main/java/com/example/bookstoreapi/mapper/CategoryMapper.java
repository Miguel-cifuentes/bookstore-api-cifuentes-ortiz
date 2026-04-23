package com.example.bookstoreapi.mapper;

import com.example.bookstoreapi.dto.response.CategoryResponse;
import com.example.bookstoreapi.entity.Category;


public class CategoryMapper {
    public static CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }
}
