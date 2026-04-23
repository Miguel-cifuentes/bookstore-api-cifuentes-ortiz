package com.example.bookstoreapi.mapper;

import com.example.bookstoreapi.dto.response.AuthorResponse;
import com.example.bookstoreapi.entity.Author;

public class AuthorMapper {
    public static AuthorResponse toResponse(Author author) {
        AuthorResponse response = new AuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        return response;
    }
}
