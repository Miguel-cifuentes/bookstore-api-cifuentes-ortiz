package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.request.AuthorRequest;
import com.example.bookstoreapi.dto.response.AuthorResponse;
import com.example.bookstoreapi.dto.ApiResponse;
import com.example.bookstoreapi.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<ApiResponse<AuthorResponse>> create(@RequestBody AuthorRequest request) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Autor creado",
                        authorService.create(request), LocalDateTime.now())
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AuthorResponse>>> getAll() {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Lista de autores",
                        authorService.getAll(), LocalDateTime.now())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AuthorResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Autor encontrado",
                        authorService.getById(id), LocalDateTime.now())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AuthorResponse>> update(@PathVariable Long id,
                                                              @RequestBody AuthorRequest request) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Autor actualizado",
                        authorService.update(id, request), LocalDateTime.now())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Autor eliminado",
                        null, LocalDateTime.now())
        );
    }
}
