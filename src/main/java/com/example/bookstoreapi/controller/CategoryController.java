package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.request.CategoryRequest;
import com.example.bookstoreapi.dto.response.CategoryResponse;
import com.example.bookstoreapi.dto.ApiResponse;
import com.example.bookstoreapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> create(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Categoría creada",
                        categoryService.create(request), LocalDateTime.now())
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getAll() {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Lista de categorías",
                        categoryService.getAll(), LocalDateTime.now())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Categoría encontrada",
                        categoryService.getById(id), LocalDateTime.now())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> update(@PathVariable Long id,
                                                                @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Categoría actualizada",
                        categoryService.update(id, request), LocalDateTime.now())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Categoría eliminada",
                        null, LocalDateTime.now())
        );
    }
}
