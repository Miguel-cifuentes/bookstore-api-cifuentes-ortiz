package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.request.BookRequest;
import com.example.bookstoreapi.dto.response.BookResponse;
import com.example.bookstoreapi.security.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    public BookResponse create(@RequestBody @Valid BookRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<BookResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/author/{id}")
    public List<BookResponse> findByAuthor(@PathVariable Long id) {
        return service.findByAuthor(id);
    }

    @GetMapping("/category/{id}")
    public List<BookResponse> findByCategory(@PathVariable Long id) {
        return service.findByCategory(id);
    }
}