package com.web.forms;

import com.web.entity.PositionDoctor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

public class PositionDoctorForm implements Serializable {
    private int positionDoctorId;
    private String position;
    private LocalTime beginningWork;
    private LocalTime beginningBreak;
    private LocalTime endBreak;
    private LocalTime endWork;
    private Set<DoctorForm> doctors;

    public PositionDoctorForm() {
    }

    public PositionDoctorForm(PositionDoctor positionDoctor) {
        this.positionDoctorId = positionDoctor.getPositionDoctorId();
        this.position = positionDoctor.getPosition();
        this.beginningWork = positionDoctor.getBeginningWork();
        this.beginningBreak = positionDoctor.getBeginningBreak();
        this.endBreak = positionDoctor.getEndBreak();
        this.endWork = positionDoctor.getEndWork();
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

    public Set<DoctorForm> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<DoctorForm> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "PositionDoctorForm{" +
                "positionDoctorId=" + positionDoctorId +
                ", position='" + position + '\'' +
                ", beginningWork=" + beginningWork +
                ", beginningBreak=" + beginningBreak +
                ", endBreak=" + endBreak +
                ", endWork=" + endWork +
                '}';
    }
}
