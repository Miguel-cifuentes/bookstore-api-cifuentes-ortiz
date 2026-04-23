package com.example.bookstoreapi.impl;

import com.example.bookstoreapi.dto.request.AuthorRequest;
import com.example.bookstoreapi.dto.response.AuthorResponse;
import com.example.bookstoreapi.entity.Author;
import com.example.bookstoreapi.exception.custom.AuthorHasBooksException;
import com.example.bookstoreapi.exception.custom.ResourceNotFoundException;
import com.example.bookstoreapi.mapper.AuthorMapper;
import com.example.bookstoreapi.repository.AuthorRepository;
import com.example.bookstoreapi.repository.BookRepository;
import com.example.bookstoreapi.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public AuthorResponse create(AuthorRequest request) {
        Author author = new Author();
        author.setName(request.getName());
        return AuthorMapper.toResponse(authorRepository.save(author));
    }

    @Override
    public AuthorResponse update(Long id, AuthorRequest request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));

        author.setName(request.getName());
        return AuthorMapper.toResponse(authorRepository.save(author));
    }

    @Override
    public AuthorResponse getById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));
        return AuthorMapper.toResponse(author);
    }

    @Override
    public List<AuthorResponse> getAll() {
        return authorRepository.findAll()
                .stream()
                .map(AuthorMapper::toResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));

        boolean hasBooks = bookRepository.existsByAuthor(author);

        if (hasBooks) {
            throw new AuthorHasBooksException("No se puede eliminar el autor porque tiene libros");
        }

        authorRepository.delete(author);
    }
}