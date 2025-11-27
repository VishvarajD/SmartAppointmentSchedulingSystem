package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "providers")
@Builder
public class ProviderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int provider_id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private UserEntity user;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String specialization;  // e.g. Dentist, Cardiologist, Lawyer

    private String experience;      // "5 years"

    private String bio;

    private String phone;

    private String location;
}
