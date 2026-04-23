package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.request.OrderRequest;
import com.example.bookstoreapi.dto.response.OrderResponse;
import com.example.bookstoreapi.service.OrderService;
import com.example.bookstoreapi.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@RequestBody OrderRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Pedido creado",
                        orderService.createOrder(request), LocalDateTime.now())
        );
    }

    @GetMapping("/my")
    public ResponseEntity<ApiResponse<List<OrderResponse>>> getMyOrders() {

        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Pedidos del usuario",
                        orderService.getMyOrders(), LocalDateTime.now())
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderResponse>>> getAllOrders() {

        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Todos los pedidos",
                        orderService.getAllOrders(), LocalDateTime.now())
        );
    }
}
