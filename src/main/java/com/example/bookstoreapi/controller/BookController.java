package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.request.BookRequest;
import com.example.bookstoreapi.dto.response.BookResponse;
import com.example.bookstoreapi.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    // ✅ Crear libro
    @PostMapping
    public BookResponse create(@RequestBody @Valid BookRequest request) {
        return service.create(request);
    }

    // ✅ Listar todos los libros
    @GetMapping
    public List<BookResponse> findAll() {
        return service.findAll();
    }

    // ✅ Filtrar por autor
    @GetMapping("/author/{authorId}")
    public List<BookResponse> findByAuthor(@PathVariable Long authorId) {
        return service.findByAuthor(authorId);
    }

    // ✅ Filtrar por categoría
    @GetMapping("/category/{categoryId}")
    public List<BookResponse> findByCategory(@PathVariable Long categoryId) {
        return service.findByCategory(categoryId);
    }
}
