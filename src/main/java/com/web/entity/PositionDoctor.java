package com.web.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Data()
@NoArgsConstructor
@Entity
@Table(name = "position")
public class PositionDoctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "positionDoctorId")
    private int positionDoctorId;
    @Column(name = "position",nullable = false)
    private String position;
    @Column(nullable = false)
    private LocalTime beginningWork;
    @Column(nullable = false)
    private LocalTime beginningBreak;
    @Column(nullable = false)
    private LocalTime endBreak;
    @Column(nullable = false)
    private LocalTime endWork;

    @ManyToMany
    @JoinTable(name = "positionDoctor",
            joinColumns = @JoinColumn(name = "positionDoctorId"),
            inverseJoinColumns = @JoinColumn(name = "id_doctor"))
    private Set<Doctor> doctors;

}
