package com.web.forms;

import java.time.LocalTime;

public class TimerTimeForm {
    private long idTime;
    private LocalTime time;
    private CalendarForm calendar;
    private DoctorForm doctor;
    private PassportForm passport;

    public TimerTimeForm() {
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
