package com.example.bookstoreapi.security;
import com.taller.bookstore.dto.request.AuthorRequest;
import com.example.bookstoreapi.dto.request.AuthorRequest;
import com.example.bookstoreapi.dto.response.AuthorResponse;

import java.util.List;

public class AuthorService {
    AuthorResponse create(AuthorRequest request);

    List<AuthorResponse> findAll();

    void delete(Long id);
}
