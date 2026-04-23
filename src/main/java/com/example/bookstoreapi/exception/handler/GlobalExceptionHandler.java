package com.example.bookstoreapi.exception.handler;

import com.example.bookstoreapi.dto.ApiErrorResponse;
import com.example.bookstoreapi.exception.custom.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 🔴 Recurso no encontrado
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ApiErrorResponse(
                        "error",
                        404,
                        ex.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    // 🔴 Duplicados (ej: email)
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiErrorResponse> handleDuplicate(DuplicateResourceException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ApiErrorResponse(
                        "error",
                        409,
                        ex.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    // 🔴 No autorizado
    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<ApiErrorResponse> handleUnauthorized(UnauthorizedAccessException ex) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new ApiErrorResponse(
                        "error",
                        401,
                        ex.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    // 🔴 Stock insuficiente
    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ApiErrorResponse> handleStock(InsufficientStockException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ApiErrorResponse(
                        "error",
                        400,
                        ex.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    // 🔴 Estado inválido de pedido
    @ExceptionHandler(InvalidOrderStateException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidState(InvalidOrderStateException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ApiErrorResponse(
                        "error",
                        400,
                        ex.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    // 🔴 Error general (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneral(Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ApiErrorResponse(
                        "error",
                        500,
                        "Error interno del servidor",
                        LocalDateTime.now()
                )
        );
    }
}
