package com.example.bookstoreapi.repository;
import com.example.bookstoreapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
