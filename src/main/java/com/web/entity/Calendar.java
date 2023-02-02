package com.web.entity;

import com.web.forms.DoctorForm;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "calendarTicket")
public class Calendar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDate;
    @Column
    private LocalDate localDate;
    @Column
    private int time8_30;
    @Column
    private int time9_00;
    @Column
    private int time9_30;
    @Column
    private int time10_00;
    @Column
    private int time10_30;
    @Column
    private int time11_00;
    @Column
    private int time11_30;

    @Column
    private int time13_00;
    @Column
    private int time13_30;
    @Column
    private int time14_00;
    @Column
    private int time14_30;
    @Column
    private int time15_00;
    @Column
    private int time15_30;
    @Column
    private int time16_00;
    @Column
    private int time16_30;


    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idDoctor")
    private Doctor doctor;

    @ManyToMany
    @JoinTable(name = "calendarTicketUser",
            joinColumns = @JoinColumn(name = "idDate"),
            inverseJoinColumns = @JoinColumn(name = "id_passport"))
    private Set<Passport> passports;

    public Calendar() {

    }

    public Calendar(int idDate , LocalDate localDate, int time8_30, int time9_00, int time9_30, int time10_00, int time10_30,
                    int time11_00, int time11_30, int time13_00, int time13_30, int time14_00, int time14_30,
                    int time15_00, int time15_30, int time16_00, int time16_30) {
        this.idDate = idDate;
        this.localDate = localDate;
        this.time8_30 = time8_30;
        this.time9_00 = time9_00;
        this.time9_30 = time9_30;
        this.time10_00 = time10_00;
        this.time10_30 = time10_30;
        this.time11_00 = time11_00;
        this.time11_30 = time11_30;
        this.time13_00 = time13_00;
        this.time13_30 = time13_30;
        this.time14_00 = time14_00;
        this.time14_30 = time14_30;
        this.time15_00 = time15_00;
        this.time15_30 = time15_30;
        this.time16_00 = time16_00;
        this.time16_30 = time16_30;
    }

    public Calendar(long idDate, LocalDate localDate, int time8_30,
                    int time9_00, int time9_30, int time10_00,
                    int time10_30, int time11_00, int time11_30,
                    int time13_00, int time13_30, int time14_00,
                    int time14_30, int time15_00, int time15_30,
                    int time16_00, int time16_30, DoctorForm doctor) {
        this.idDate = idDate;
        this.localDate = localDate;
        this.time8_30 = time8_30;
        this.time9_00 = time9_00;
        this.time9_30 = time9_30;
        this.time10_00 = time10_00;
        this.time10_30 = time10_30;
        this.time11_00 = time11_00;
        this.time11_30 = time11_30;
        this.time13_00 = time13_00;
        this.time13_30 = time13_30;
        this.time14_00 = time14_00;
        this.time14_30 = time14_30;
        this.time15_00 = time15_00;
        this.time15_30 = time15_30;
        this.time16_00 = time16_00;
        this.time16_30 = time16_30;
        this.doctor = new Doctor(doctor.getIdDoctor(),doctor.getCabinetNumber(),doctor.getSpecialityDoctor());
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

    public int getTime8_30() {
        return time8_30;
    }

    public void setTime8_30(int time8_30) {
        this.time8_30 = time8_30;
    }

    public int getTime9_00() {
        return time9_00;
    }

    public void setTime9_00(int time9_00) {
        this.time9_00 = time9_00;
    }

    public int getTime9_30() {
        return time9_30;
    }

    public void setTime9_30(int time9_30) {
        this.time9_30 = time9_30;
    }

    public int getTime10_00() {
        return time10_00;
    }

    public void setTime10_00(int time10_00) {
        this.time10_00 = time10_00;
    }

    public int getTime10_30() {
        return time10_30;
    }

    public void setTime10_30(int time10_30) {
        this.time10_30 = time10_30;
    }

    public int getTime11_00() {
        return time11_00;
    }

    public void setTime11_00(int time11_00) {
        this.time11_00 = time11_00;
    }

    public int getTime11_30() {
        return time11_30;
    }

    public void setTime11_30(int time11_30) {
        this.time11_30 = time11_30;
    }

    public int getTime13_00() {
        return time13_00;
    }

    public void setTime13_00(int time13_00) {
        this.time13_00 = time13_00;
    }

    public int getTime13_30() {
        return time13_30;
    }

    public void setTime13_30(int time13_30) {
        this.time13_30 = time13_30;
    }

    public int getTime14_00() {
        return time14_00;
    }

    public void setTime14_00(int time14_00) {
        this.time14_00 = time14_00;
    }

    public int getTime14_30() {
        return time14_30;
    }

    public void setTime14_30(int time14_30) {
        this.time14_30 = time14_30;
    }

    public int getTime15_00() {
        return time15_00;
    }

    public void setTime15_00(int time15_00) {
        this.time15_00 = time15_00;
    }

    public int getTime15_30() {
        return time15_30;
    }

    public void setTime15_30(int time15_30) {
        this.time15_30 = time15_30;
    }

    public int getTime16_00() {
        return time16_00;
    }

    public void setTime16_00(int time16_00) {
        this.time16_00 = time16_00;
    }

    public int getTime16_30() {
        return time16_30;
    }

    public void setTime16_30(int time16_30) {
        this.time16_30 = time16_30;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Set<Passport> getPassports() {
        return passports;
    }

    public void setPassports(Set<Passport> passports) {
        this.passports = passports;
    }
}
