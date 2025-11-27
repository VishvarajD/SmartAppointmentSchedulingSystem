package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Service;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.UserEntity;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository.UserRepository;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.dto.AdminRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    UserRepository userRepository;

    public String setRole(AdminRequestDto adminDto) {
        Optional<UserEntity> userObj = userRepository.findById(adminDto.getId());
        userObj.get().setRole(adminDto.getRole());
        userRepository.save(userObj.get());
        return "Role changed";

    }
}
