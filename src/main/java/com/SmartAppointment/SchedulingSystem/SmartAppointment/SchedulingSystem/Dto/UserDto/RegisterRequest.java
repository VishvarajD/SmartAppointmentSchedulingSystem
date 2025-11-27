package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Dto.UserDto;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}
