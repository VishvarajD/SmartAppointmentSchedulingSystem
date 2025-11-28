package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Service;

import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.AppointmentEntity;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.AppointmentStatus;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.ProviderModel;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model.UserEntity;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository.AppointmentRepository;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository.ProviderRepository;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Repository.UserRepository;
import com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Dto.AppointmentDto.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ProviderRepository providerRepository;
    private final UserRepository userRepository;

    public AppointmentEntity bookAppointment(AppointmentRequest request) {

        String username = SecurityContextHolder.getContext()
                .getAuthentication().getName();

        UserEntity patient = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ProviderModel provider = providerRepository.findById(request.getProviderId())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        AppointmentEntity appointment = AppointmentEntity.builder()
                .patient(patient)
                .provider(provider)
                .appointmentTime(request.getAppointmentTime())

                .status(AppointmentStatus.PENDING)
                .build();

        return appointmentRepository.save(appointment);
    }

    public List<AppointmentEntity> getMyAppointments() {
        String username = SecurityContextHolder.getContext()
                .getAuthentication().getName();

        UserEntity patient = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return appointmentRepository.findByPatient(patient);
    }

    public List<AppointmentEntity> getProviderAppointments() {

        String username = SecurityContextHolder.getContext()
                .getAuthentication().getName();

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch provider linked to this user
        ProviderModel provider = providerRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        return appointmentRepository.findByProvider(provider);
    }

    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public AppointmentEntity approveAppointment(int id) {
        AppointmentEntity appt = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appt.setStatus(AppointmentStatus.APPROVED);
        return appointmentRepository.save(appt);
    }

    public AppointmentEntity rejectAppointment(int id) {
        AppointmentEntity appt = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appt.setStatus(AppointmentStatus.REJECTED);
        return appointmentRepository.save(appt);
    }

    public AppointmentEntity cancelAppointment(int id) {
        AppointmentEntity appt = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appt.setStatus(AppointmentStatus.CANCELLED);
        return appointmentRepository.save(appt);
    }

    public AppointmentEntity completeAppointment(int id) {
        AppointmentEntity appt = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appt.setStatus(AppointmentStatus.COMPLETED);
        return appointmentRepository.save(appt);
    }

}
