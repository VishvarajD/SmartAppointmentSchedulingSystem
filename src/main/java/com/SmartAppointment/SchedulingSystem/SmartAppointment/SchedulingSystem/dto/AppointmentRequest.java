package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private Integer providerId;
    private LocalDateTime appointmentTime;
}
