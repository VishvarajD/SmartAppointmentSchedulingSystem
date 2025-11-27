package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Dto.AdminDto;


import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.Role;
import lombok.Data;

@Data
public class AdminRequestDto {
    private int id;
    private Role role;
}
