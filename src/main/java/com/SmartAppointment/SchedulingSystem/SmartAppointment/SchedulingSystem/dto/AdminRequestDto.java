package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto;


import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.Role;
import lombok.Data;

@Data
public class AdminRequestDto {
    private int id;
    private Role role;
}
