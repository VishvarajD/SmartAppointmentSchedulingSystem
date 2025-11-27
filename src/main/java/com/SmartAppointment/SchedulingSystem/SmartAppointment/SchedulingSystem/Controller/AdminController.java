package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Controller;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Service.AdminService;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto.AdminRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/setRole")
    public String setRole(@RequestBody AdminRequestDto adminDto) {
        adminService.setRole(adminDto);
        return "Role Setting Up in Progress";

    }
}
