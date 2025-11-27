package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Controller;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.ProviderModel;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Service.ProviderService;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto.ProviderDto.ProviderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER')")
    public ProviderModel createProvider(@RequestBody ProviderRequest request){
        return providerService.registerProvider(request);
    }

    @GetMapping("/get")
    public List<ProviderModel> getProviders(){
        return providerService.getAllProviders();
    }
}

