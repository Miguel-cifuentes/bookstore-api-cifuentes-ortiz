package com.example.bookstoreapi.dto.response;

import com.example.bookstoreapi.entity.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderResponse {

    private Long id;
    private LocalDateTime createdAt;
    private Double total;
    private OrderStatus status;

    private List<OrderItemResponse> items;
}
