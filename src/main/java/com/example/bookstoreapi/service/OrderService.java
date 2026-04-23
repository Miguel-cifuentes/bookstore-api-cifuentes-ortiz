package com.example.bookstoreapi.service;

import com.example.bookstoreapi.dto.request.OrderRequest;
import com.example.bookstoreapi.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

    List<OrderResponse> getMyOrders();

    List<OrderResponse> getAllOrders();
}
