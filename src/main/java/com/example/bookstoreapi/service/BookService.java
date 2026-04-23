package com.example.bookstoreapi.service;

import com.example.bookstoreapi.dto.request.BookRequest;
import com.example.bookstoreapi.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse create(BookRequest request);

    List<BookResponse> findAll();

    List<BookResponse> findByAuthor(Long authorId);

    List<BookResponse> findByCategory(Long categoryId);
}

