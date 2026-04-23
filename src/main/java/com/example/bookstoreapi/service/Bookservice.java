package com.example.bookstoreapi.service;
import com.example.bookstoreapi.dto.request.BookRequest;
import com.example.bookstoreapi.dto.response.BookResponse;

import java.util.List;
public class Bookservice {
    // Crear libro
    BookResponse create(BookRequest request);

    //  Listar todos los libros
    List<BookResponse> findAll();

    //  Filtrar por autor
    List<BookResponse> findByAuthor(Long authorId);

    //  Filtrar por categoría
    List<BookResponse> findByCategory(Long categoryId);
}
