package com.example.bookstoreapi.mapper;

import com.example.bookstoreapi.dto.response.BookResponse;
import com.example.bookstoreapi.entity.Book;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.stream.Collectors;


public class BookMapper {
    public static BookResponse toResponse(Book book) {

        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setIsbn(book.getIsbn());
        response.setPrice(book.getPrice());
        response.setStock(book.getStock());

        response.setAuthor(AuthorMapper.toResponse(book.getAuthor()));

        response.setCategories(
                book.getCategories().stream()
                        .map(CategoryMapper::toResponse)
                        .collect(Collectors.toList())
        );

        return response;
    }
}
