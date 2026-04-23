package com.example.bookstoreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private String status;
    private int code;
    private String message;
    private T data;
    private LocalDateTime timestamp;
}