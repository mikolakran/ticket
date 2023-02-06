package com.web.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "timer_time")
public class TimerTime implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTime;
    @Column
    private LocalTime time;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "idDoctor")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idLocalDate")
    private Calendar calendar;

    @OneToOne(cascade = CascadeType.REFRESH)
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
