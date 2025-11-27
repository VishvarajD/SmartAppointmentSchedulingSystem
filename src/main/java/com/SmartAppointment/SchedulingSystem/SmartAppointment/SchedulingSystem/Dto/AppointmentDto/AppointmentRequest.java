package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Dto.AppointmentDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private Integer providerId;
    private LocalDateTime appointmentTime;
}
