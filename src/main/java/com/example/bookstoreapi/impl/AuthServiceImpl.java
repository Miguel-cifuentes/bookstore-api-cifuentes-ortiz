package com.example.bookstoreapi.impl;

import com.example.bookstoreapi.dto.request.LoginRequest;
import com.example.bookstoreapi.dto.request.RegisterRequest;
import com.example.bookstoreapi.dto.response.AuthResponse;
import com.example.bookstoreapi.entity.Role;
import com.example.bookstoreapi.entity.User;
import com.example.bookstoreapi.exception.custom.DuplicateResourceException;
import com.example.bookstoreapi.exception.custom.UnauthorizedAccessException;
import com.example.bookstoreapi.repository.UserRepository;
import com.example.bookstoreapi.security.JwtService;
import com.example.bookstoreapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email ya registrado");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);

        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthResponse(token, 86400000L, user.getRole().name());
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UnauthorizedAccessException("Credenciales inválidas"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UnauthorizedAccessException("Credenciales inválidas");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(token, 86400000L, user.getRole().name());
    }
}