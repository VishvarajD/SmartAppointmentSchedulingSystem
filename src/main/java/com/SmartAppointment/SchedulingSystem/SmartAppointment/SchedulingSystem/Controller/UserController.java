package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Controller;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.UserEntity;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }
}
