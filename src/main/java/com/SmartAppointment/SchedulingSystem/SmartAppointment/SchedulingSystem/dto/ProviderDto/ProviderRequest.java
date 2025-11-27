package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto.ProviderDto;

import lombok.Data;

@Data
public class ProviderRequest {
    private String fullName;
    private String specialization;
    private String experience;
    private String bio;
    private String phone;
    private String location;
}