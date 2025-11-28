package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Controller;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Dto.ProviderDto.ProviderAvailabilityRequest;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.ProviderAvailability;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Service.ProviderAvailibilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/availability")
@RequiredArgsConstructor
public class ProviderAvailabilityController {

    private final ProviderAvailibilityService availabilityService;

    @PostMapping("/add")
    public ProviderAvailability addSlot(@RequestBody ProviderAvailabilityRequest request) {
        return availabilityService.addAvailability(request);
    }

    @GetMapping("/my-slots")
    public List<ProviderAvailability> mySlots() {
        return availabilityService.getMySlots();
    }

    @GetMapping("/provider/{providerId}")
    public List<ProviderAvailability> providerSlots(@PathVariable int providerId) {
        return availabilityService.getAvailableSlotsForProvider(providerId);
    }
}