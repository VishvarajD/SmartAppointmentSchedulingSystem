package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Controller;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.AppointmentEntity;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Service.AppointmentService;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Dto.AppointmentDto.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/book")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<AppointmentEntity> book(@RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(appointmentService.bookAppointment(request));
    }

    @GetMapping("/my")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<AppointmentEntity>> myAppointments() {
        return ResponseEntity.ok(appointmentService.getMyAppointments());
    }

    @GetMapping("/provider/my")
    @PreAuthorize("hasRole('PROVIDER')")
    public ResponseEntity<List<AppointmentEntity>> providerAppointments() {
        return ResponseEntity.ok(appointmentService.getProviderAppointments());
    }

    @GetMapping("all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AppointmentEntity>> allAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

}

