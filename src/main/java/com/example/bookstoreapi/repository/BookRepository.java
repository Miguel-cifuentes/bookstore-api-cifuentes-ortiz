package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.entity.Author;
import com.example.bookstoreapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // ✅ Para validar si un autor tiene libros
    boolean existsByAuthor(Author author);

    // ✅ Para filtrar por autor
    List<Book> findByAuthorId(Long authorId);

    // ✅ Para filtrar por categoría
    List<Book> findByCategoriesId(Long categoryId);
}