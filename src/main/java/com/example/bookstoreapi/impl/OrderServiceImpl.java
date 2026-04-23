package com.example.bookstoreapi.impl;

import com.example.bookstoreapi.dto.request.OrderRequest;
import com.example.bookstoreapi.dto.response.OrderResponse;
import com.example.bookstoreapi.entity.*;
import com.example.bookstoreapi.exception.custom.InsufficientStockException;
import com.example.bookstoreapi.exception.custom.ResourceNotFoundException;
import com.example.bookstoreapi.mapper.OrderMapper;
import com.example.bookstoreapi.repository.BookRepository;
import com.example.bookstoreapi.repository.OrderRepository;
import com.example.bookstoreapi.repository.UserRepository;
import com.example.bookstoreapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponse createOrder(OrderRequest request) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        List<OrderItem> items = new ArrayList<>();
        double total = 0;

        for (OrderRequest.OrderItemRequest itemReq : request.getItems()) {

            Book book = bookRepository.findById(itemReq.getBookId())
                    .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado"));

            if (book.getStock() < itemReq.getQuantity()) {
                throw new InsufficientStockException("Stock insuficiente para: " + book.getTitle());
            }

            book.setStock(book.getStock() - itemReq.getQuantity());

            OrderItem item = new OrderItem();
            item.setBook(book);
            item.setQuantity(itemReq.getQuantity());
            item.setPrice(book.getPrice());
            item.setOrder(order);

            items.add(item);
            total += book.getPrice() * itemReq.getQuantity();
        }

        order.setItems(items);
        order.setTotal(total);
        order.setUser(user);

        return orderMapper.toResponse(orderRepository.save(order));
    }

    @Override
    public List<OrderResponse> getMyOrders() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        return orderRepository.findByUser(user)
                .stream()
                .map(orderMapper::toResponse)
                .toList();
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toResponse)
                .toList();
    }
}
