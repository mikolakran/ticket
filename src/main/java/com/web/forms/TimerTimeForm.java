package com.web.forms;

import com.web.entity.TimerTime;

import java.io.Serializable;
import java.time.LocalTime;

public class TimerTimeForm implements Serializable {
    private long idTime;
    private LocalTime time;
    private CalendarForm calendar;
    private DoctorForm doctor;
    private PassportForm passport;

    public TimerTimeForm() {
    }

    public TimerTimeForm(TimerTime timerTime) {
        this.idTime = timerTime.getIdTime();
        this.time = timerTime.getTime();
        this.calendar = new CalendarForm(timerTime.getCalendar());
        this.doctor = new DoctorForm(timerTime.getDoctor());
        if (timerTime.getPassport()!=null){
            this.passport = new PassportForm(timerTime.getPassport());
        }
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

    public CalendarForm getCalendar() {
        return calendar;
    }

    public void setCalendar(CalendarForm calendar) {
        this.calendar = calendar;
    }

    public DoctorForm getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorForm doctor) {
        this.doctor = doctor;
    }

    public PassportForm getPassport() {
        return passport;
    }

    public void setPassport(PassportForm passport) {
        this.passport = passport;
    }
}
