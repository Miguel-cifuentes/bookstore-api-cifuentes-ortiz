package com.example.bookstoreapi.mapper;

import com.example.bookstoreapi.dto.response.OrderResponse;
import com.example.bookstoreapi.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderItemMapper orderItemMapper;

    public OrderResponse toResponse(Order order) {

        return OrderResponse.builder()
                .id(order.getId())
                .createdAt(order.getCreatedAt())
                .total(order.getTotal())
                .status(order.getStatus())
                .items(order.getItems()
                        .stream()
                        .map(orderItemMapper::toResponse)
                        .toList())
                .build();
    }
}