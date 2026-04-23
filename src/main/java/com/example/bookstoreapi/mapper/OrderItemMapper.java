package com.example.bookstoreapi.mapper;

import com.example.bookstoreapi.dto.response.OrderItemResponse;
import com.example.bookstoreapi.entity.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemResponse toResponse(OrderItem item) {

        return OrderItemResponse.builder()
                .bookId(item.getBook().getId())
                .bookTitle(item.getBook().getTitle())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();
    }
}