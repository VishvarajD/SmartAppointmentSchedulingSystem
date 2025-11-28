package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Service;


import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Dto.ProviderDto.ProviderAvailabilityRequest;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.ProviderModel;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.ProviderAvailability;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository.ProviderAvailabilityRepository;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository.ProviderRepository;
//import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto.ProviderAvailabilityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderAvailibilityService {

    private final ProviderRepository providerRepository;
    private final ProviderAvailabilityRepository availabilityRepository;

    public ProviderAvailability addAvailability(ProviderAvailabilityRequest request) {

        String username = SecurityContextHolder.getContext()
                .getAuthentication().getName();

        ProviderModel provider = providerRepository.findByUser_Username(username)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        ProviderAvailability slot = ProviderAvailability.builder()
                .provider(provider)
                .date(request.getDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .isBooked(false)
                .build();

        return availabilityRepository.save(slot);
    }

    public List<ProviderAvailability> getMySlots() {
        String username = SecurityContextHolder.getContext()
                .getAuthentication().getName();

        ProviderModel provider = providerRepository.findByUser_Username(username)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        return availabilityRepository.findByProvider(provider);
    }

    public List<ProviderAvailability> getAvailableSlotsForProvider(int providerId) {
        ProviderModel provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        return availabilityRepository.findByProvider(provider);
    }
}

