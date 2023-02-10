package com.web.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

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

    public PositionDoctor() {
    }

    public int getPositionDoctorId() {
        return positionDoctorId;
    }

    public void setPositionDoctorId(int positionDoctorId) {
        this.positionDoctorId = positionDoctorId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalTime getBeginningWork() {
        return beginningWork;
    }

    public void setBeginningWork(LocalTime beginningWork) {
        this.beginningWork = beginningWork;
    }

    public LocalTime getBeginningBreak() {
        return beginningBreak;
    }

    public void setBeginningBreak(LocalTime beginningBreak) {
        this.beginningBreak = beginningBreak;
    }

    public LocalTime getEndBreak() {
        return endBreak;
    }

    public void setEndBreak(LocalTime endBreak) {
        this.endBreak = endBreak;
    }

    public LocalTime getEndWork() {
        return endWork;
    }

    public void setEndWork(LocalTime endWork) {
        this.endWork = endWork;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
