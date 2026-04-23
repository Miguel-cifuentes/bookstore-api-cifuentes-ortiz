package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.entity.Order;
import com.example.bookstoreapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // 🔍 Obtener pedidos de un usuario
    List<Order> findByUser(User user);
}