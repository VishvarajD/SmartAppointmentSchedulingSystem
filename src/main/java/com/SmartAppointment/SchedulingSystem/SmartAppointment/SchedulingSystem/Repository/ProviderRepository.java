package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.ProviderModel;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProviderRepository extends JpaRepository<ProviderModel, Integer> {
    Optional<ProviderModel> findByUserId(Integer userId);


    Optional<ProviderModel> findByUser(UserEntity user);

}
