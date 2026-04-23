package com.example.bookstoreapi.security;


public interface BookService {

    BookResponse create(BookRequest request);

    List<BookResponse> findAll();

    List<BookResponse> findByAuthor(Long authorId);

    List<BookResponse> findByCategory(Long categoryId);
}
public class BookService {

}
