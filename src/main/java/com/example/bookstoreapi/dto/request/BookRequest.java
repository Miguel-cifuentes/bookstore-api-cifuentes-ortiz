package com.example.bookstoreapi.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data

public class BookRequest {
    @NotBlank(message = "El título es obligatorio")
    private String title;

    @NotBlank(message = "El ISBN es obligatorio")
    private String isbn;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double price;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull(message = "El authorId es obligatorio")
    private Long authorId;

    @NotEmpty(message = "Debe tener al menos una categoría")
    private List<Long> categoryIds;
}
