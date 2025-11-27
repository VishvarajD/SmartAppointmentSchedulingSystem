package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Service;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.ProviderModel;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.Role;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.UserEntity;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository.ProviderRepository;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository.UserRepository;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto.ProviderDto.ProviderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;
    private final UserRepository userRepository;

    public ProviderModel registerProvider(ProviderRequest request) {

        String username = SecurityContextHolder.getContext()
                .getAuthentication().getName();


        System.out.println("Authenticated user: " + username);

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRole() != Role.PROVIDER) {
            user.setRole(Role.PROVIDER);
            userRepository.save(user);
        }

        ProviderModel provider = ProviderModel.builder()
                .user(user)
                .fullName(request.getFullName())
                .specialization(request.getSpecialization())
                .experience(request.getExperience())
                .bio(request.getBio())
                .phone(request.getPhone())
                .location(request.getLocation())
                .build();


        return providerRepository.save(provider);
    }

    public List<ProviderModel> getAllProviders() {
        return providerRepository.findAll();
    }
}