package com.example.bookstoreapi.repository;
import com.example.bookstoreapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class BookRepository {
    List<Book> findByAuthorId(Long authorId);

    List<Book> findByCategoriesId(Long categoryId);
}
