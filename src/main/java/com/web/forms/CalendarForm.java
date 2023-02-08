package com.web.forms;

import com.web.entity.Calendar;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

public class CalendarForm implements Serializable {
    private long idDate;
    private LocalDate localDate;
    private String firstDayOff;
    private String secondDayOff;
    private int timerMinutes;
    private Set<TimerTimeForm> timerTimes;
    private Set<DoctorForm> doctors;

    public CalendarForm() {
    }

    public CalendarForm(Calendar calendar) {
        this.idDate = calendar.getIdDate();
        this.localDate = calendar.getLocalDate();
    }

    public CalendarForm(LocalDate currentDate) {
        this.localDate = currentDate;
    }

    public long getIdDate() {
        return idDate;
    }

    public Set<TimerTimeForm> getTimerTimes() {
        return timerTimes;
    }

    public void setTimerTimes(Set<TimerTimeForm> timerTimes) {
        this.timerTimes = timerTimes;
    }

    public void setIdDate(long idDate) {
        this.idDate = idDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getFirstDayOff() {
        return firstDayOff;
    }

    public void setFirstDayOff(String firstDayOff) {
        this.firstDayOff = firstDayOff;
    }

    public String getSecondDayOff() {
        return secondDayOff;
    }

    public void setSecondDayOff(String secondDayOff) {
        this.secondDayOff = secondDayOff;
    }

    public Set<DoctorForm> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<DoctorForm> doctors) {
        this.doctors = doctors;
    }

    public int getTimerMinutes() {
        return timerMinutes;
    }

    public void setTimerMinutes(int timerMinutes) {
        this.timerMinutes = timerMinutes;
    }
}
