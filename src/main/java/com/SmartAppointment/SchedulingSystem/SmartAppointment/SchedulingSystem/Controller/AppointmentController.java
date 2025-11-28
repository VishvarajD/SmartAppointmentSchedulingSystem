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

    @PutMapping("/approve/{id}")
    @PreAuthorize("hasRole('PROVIDER')")
    public AppointmentEntity approve(@PathVariable int id) {
        return appointmentService.approveAppointment(id);
    }

    @PutMapping("/reject/{id}")
    @PreAuthorize("hasRole('PROVIDER')")
    public AppointmentEntity reject(@PathVariable int id) {
        return appointmentService.rejectAppointment(id);
    }

    @PutMapping("/cancel/{id}")
    @PreAuthorize("hasRole('USER')")
    public AppointmentEntity cancel(@PathVariable int id) {
        return appointmentService.cancelAppointment(id);
    }

    @PutMapping("/complete/{id}")
    @PreAuthorize("hasRole('PROVIDER')")
    public AppointmentEntity complete(@PathVariable int id) {
        return appointmentService.completeAppointment(id);
    }


}

