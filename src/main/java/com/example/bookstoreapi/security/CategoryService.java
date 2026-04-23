package com.example.bookstoreapi.security;

AuthorResponse create(AuthorRequest request);

List<AuthorResponse> findAll();

void delete(Long id);

public class CategoryService {
    CategoryResponse create(CategoryRequest request);

    List<CategoryResponse> findAll();
}
