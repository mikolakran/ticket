package com.web.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "timer_time")
public class TimerTime implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTime;
    @Column
    private String time;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idDoctor")
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPassport")
    private Passport passport;

    public TimerTime() {
    }

    public long getIdTime() {
        return idTime;
    }

    public void setIdTime(long idTime) {
        this.idTime = idTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
