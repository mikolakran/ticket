package com.web.forms;

import com.web.entity.Doctor;
import com.web.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class DoctorForm implements Serializable {
    private long idDoctor;
    private int cabinetNumber;
    private String specialityDoctor;
    private Set<PositionDoctorForm> positionDoctors;
    private UserForm user;
    private List<CalendarForm> calendars;
    private Set<TimerTimeForm> timerTimes;


    public DoctorForm(Doctor doctor) {
        this.idDoctor = doctor.getIdDoctor();
        this.cabinetNumber = doctor.getCabinetNumber();
        this.specialityDoctor = doctor.getSpecialityDoctor();
        this.user = new UserForm(doctor.getUser());
    }

    public DoctorForm(long idDoctor, int cabinetNumber, String specialityDoctor, User user) {
        this.idDoctor = idDoctor;
        this.cabinetNumber = cabinetNumber;
        this.specialityDoctor = specialityDoctor;
        this.user = new UserForm(user);
    }

    public DoctorForm() {

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

    public Set<PositionDoctorForm> getPositionDoctors() {
        return positionDoctors;
    }

    public void setPositionDoctors(Set<PositionDoctorForm> positionDoctors) {
        this.positionDoctors = positionDoctors;
    }

    public UserForm getUser() {
        return user;
    }

    public void setUser(UserForm user) {
        this.user = user;
    }

    public List<CalendarForm> getCalendars() {
        return calendars;
    }

    public void setCalendars(List<CalendarForm> calendars) {
        this.calendars = calendars;
    }

    public Set<TimerTimeForm> getTimerTimes() {
        return timerTimes;
    }

    public void setTimerTimes(Set<TimerTimeForm> timerTimes) {
        this.timerTimes = timerTimes;
    }

    @Override
    public String toString() {
        return "DoctorForm{" +
                "idDoctor=" + idDoctor +
                ", cabinetNumber=" + cabinetNumber +
                ", specialityDoctor='" + specialityDoctor + '\'' +
                '}';
    }
}
