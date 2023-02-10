package com.web.entity;

import com.web.forms.DoctorForm;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDoctor;
    @Column(name = "cabinetNumber",nullable = false)
    private int cabinetNumber;
    @Column(name = "specialityDoctor",nullable = false)
    private String specialityDoctor;
    @ManyToMany(mappedBy = "doctors")
    private Set<PositionDoctor> positionDoctors;

    @OneToOne(mappedBy = "doctor")
    private User user;

    @ManyToMany(mappedBy = "doctors")
    private List<Calendar> calendars;

    @OneToMany(mappedBy = "doctor")
    private Set<TimerTime> timerTimes;

    public Doctor(long idDoctor, int cabinetNumber, String specialityDoctor) {
        this.idDoctor = idDoctor;
        this.cabinetNumber = cabinetNumber;
        this.specialityDoctor = specialityDoctor;
    }

    public Doctor() {

    }

    public Doctor(DoctorForm doctorForm) {
        this.idDoctor = doctorForm.getIdDoctor();
        this.cabinetNumber = doctorForm.getCabinetNumber();
        this.specialityDoctor = doctorForm.getSpecialityDoctor();
    }

    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(int cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public String getSpecialityDoctor() {
        return specialityDoctor;
    }

    public void setSpecialityDoctor(String specialityDoctor) {
        this.specialityDoctor = specialityDoctor;
    }

    public Set<PositionDoctor> getPositionDoctors() {
        return positionDoctors;
    }

    public void setPositionDoctors(Set<PositionDoctor> positionDoctors) {
        this.positionDoctors = positionDoctors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Calendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(List<Calendar> calendars) {
        this.calendars = calendars;
    }

    public Set<TimerTime> getTimerTimes() {
        return timerTimes;
    }

    public void setTimerTimes(Set<TimerTime> timerTimes) {
        this.timerTimes = timerTimes;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", cabinetNumber=" + cabinetNumber +
                ", specialityDoctor='" + specialityDoctor + '\'' +
                ", positionDoctors=" + positionDoctors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        return idDoctor == doctor.idDoctor;
    }

    @Override
    public int hashCode() {
        return (int) (idDoctor ^ (idDoctor >>> 32));
    }
}
