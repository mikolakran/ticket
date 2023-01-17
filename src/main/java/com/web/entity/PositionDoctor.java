package com.web.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
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
    @ManyToMany
    @JoinTable(name = "doctors",
            joinColumns = @JoinColumn(name = "positionDoctorId"),
            inverseJoinColumns = @JoinColumn(name = "id_doctor"))
    private Set<Doctor> doctors;

    @ManyToMany(mappedBy = "positionDoctors")
    private List<User> user;
}
