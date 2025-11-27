package com.SmartAppointment.SchedulingSystem.SmartAppointment.SchedulingSystem.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false, unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
