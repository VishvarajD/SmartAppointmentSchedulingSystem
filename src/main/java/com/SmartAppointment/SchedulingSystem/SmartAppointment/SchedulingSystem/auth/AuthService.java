package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.auth;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.Role;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.UserEntity;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository.UserRepository;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto.AuthResponse;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto.LoginRequest;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto.RegisterRequest;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.security.JwtService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return new AuthResponse(jwtService.generateToken(user.getUsername()));
    }

    public AuthResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new AuthResponse(jwtService.generateToken(user.getUsername()));
    }
}