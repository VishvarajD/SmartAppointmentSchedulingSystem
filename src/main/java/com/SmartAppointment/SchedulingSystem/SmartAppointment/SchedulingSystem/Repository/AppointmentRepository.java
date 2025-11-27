package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.AppointmentEntity;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.ProviderModel;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
    List<AppointmentEntity> findByPatient(UserEntity patient);

    List<AppointmentEntity> findByProvider(ProviderModel provider);
}
