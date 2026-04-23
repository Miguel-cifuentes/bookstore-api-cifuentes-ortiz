package com.example.bookstoreapi.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private List<OrderItemRequest> items;

    @Data
    public static class OrderItemRequest {
        private Long bookId;
        private Integer quantity;
    }
}
