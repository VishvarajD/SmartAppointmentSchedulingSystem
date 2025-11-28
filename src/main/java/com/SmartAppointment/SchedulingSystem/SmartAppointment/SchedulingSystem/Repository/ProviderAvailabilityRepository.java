package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.ProviderAvailability;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.ProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProviderAvailabilityRepository extends JpaRepository<ProviderAvailability, Integer> {

    List<ProviderAvailability> findByProvider(ProviderModel provider);

    List<ProviderAvailability> findByProviderAndDate(ProviderModel provider, LocalDate date);

    List<ProviderAvailability> findByDate(LocalDate date);
}
