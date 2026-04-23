package com.example.bookstoreapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class AuthorRequest {
    @NotBlank(message = "El nombre del autor es obligatorio")
    private String name;
}
