package com.web.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data()
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private long idDoctor;
    @Column(name = "cabinetNumber",nullable = false)
    private int cabinetNumber;
    @Column(name = "specialityDoctor",nullable = false)
    private String specialityDoctor;
    @ManyToMany(mappedBy = "doctors")
    private Set<PositionDoctor> positionDoctors;
    private String workTime;
    @OneToOne(mappedBy = "doctor",cascade = CascadeType.PERSIST)
    private User user;

}
