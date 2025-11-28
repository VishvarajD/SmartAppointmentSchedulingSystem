package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Dto.ProviderDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ProviderAvailabilityRequest {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
