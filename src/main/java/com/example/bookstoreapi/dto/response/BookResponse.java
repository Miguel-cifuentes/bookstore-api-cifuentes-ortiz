package com.example.bookstoreapi.dto.response;

import lombok.Data;

import java.util.List;

@Data

public class BookResponse {
    private Long id;
    private String title;
    private String isbn;
    private Double price;
    private Integer stock;

    private AuthorResponse author;

    private List<CategoryResponse> categories;
}
