package com.example.bookstoreapi.impl;

import com.example.bookstoreapi.dto.request.BookRequest;
import com.example.bookstoreapi.dto.response.BookResponse;
import com.example.bookstoreapi.entity.Author;
import com.example.bookstoreapi.entity.Book;
import com.example.bookstoreapi.entity.Category;
import com.example.bookstoreapi.mapper.BookMapper;
import com.example.bookstoreapi.repository.AuthorRepository;
import com.example.bookstoreapi.repository.BookRepository;
import com.example.bookstoreapi.repository.CategoryRepository;
import com.example.bookstoreapi.security.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public BookResponse create(BookRequest request) {

        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        List<Category> categories = categoryRepository.findAllById(request.getCategoryIds());

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPrice(request.getPrice());
        book.setStock(request.getStock());
        book.setAuthor(author);
        book.setCategories(categories);

        return BookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public List<BookResponse> findAll() {
        return bookRepository.findAll().stream()
                .map(BookMapper::toResponse)
                .toList();
    }

    @Override
    public List<BookResponse> findByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId).stream()
                .map(BookMapper::toResponse)
                .toList();
    }

    @Override
    public List<BookResponse> findByCategory(Long categoryId) {
        return bookRepository.findByCategoriesId(categoryId).stream()
                .map(BookMapper::toResponse)
                .toList();
    }
}