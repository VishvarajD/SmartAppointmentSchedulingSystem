package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "provider_availability")
public class ProviderAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private ProviderModel provider;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private boolean isBooked = false;  // When a patient books this slot
}

