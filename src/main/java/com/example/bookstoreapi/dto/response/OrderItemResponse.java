package com.example.bookstoreapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemResponse {

    private Long bookId;
    private String bookTitle;
    private Integer quantity;
    private Double price;
}
