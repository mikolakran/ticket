package com.web.entity;

import com.web.forms.CalendarForm;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "calendar")
public class Calendar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDate;
    @Column(unique = true)
    private LocalDate localDate;

    @ManyToMany
    @JoinTable(name = "calendarDoctor",
            joinColumns = @JoinColumn(name = "idDate"),
            inverseJoinColumns = @JoinColumn(name = "idDoctor"))
    private Set<Doctor> doctors;

    @OneToMany(mappedBy = "calendar")
    private Set<TimerTime> timerTimes;

    public Calendar() {

    }

    public Calendar(CalendarForm calendarForm){
        this.idDate = calendarForm.getIdDate();
        this.localDate = calendarForm.getLocalDate();
    }

    public long getIdDate() {
        return idDate;
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

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<TimerTime> getTimerTimes() {
        return timerTimes;
    }

    public void setTimerTimes(Set<TimerTime> timerTimes) {
        this.timerTimes = timerTimes;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "idDate=" + idDate +
                ", localDate=" + localDate +
                '}';
    }
}
