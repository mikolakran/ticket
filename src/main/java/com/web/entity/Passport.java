package com.web.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "passport")
public class Passport implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_passport")
        private long idPassport;
    @Column(name = "family", nullable = false)
    private String family;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "patronymic", nullable = false)
    private String patronymic;
    @Column(name = "contactNumber")
    private String contactNumber;
    @Column(name = "dateBirth", nullable = false)
    private LocalDate dateBirth;
    @Column(nullable = false)
    private String gender;
    @Column(name = "address", nullable = false)
    private String address;

    @OneToOne(mappedBy = "passport")
    private User user;

    @OneToOne(mappedBy = "passport")
    private TimerTime timerTime;

    @OneToMany(mappedBy = "passport")
    private Set<MedicalHistory> medicalHistory;


    public Passport(String family, String name, String patronymic, LocalDate dateBirth, String address) {
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
        this.dateBirth = dateBirth;
        this.address = address;
    }

    public Passport(long idPassport, String family, String name, String patronymic,
                    String contactNumber, LocalDate dateBirth, String gender, String address) {
        this.idPassport = idPassport;
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.address = address;
    }

    public Passport() {

    }

    public long getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(long idPassport) {
        this.idPassport = idPassport;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<MedicalHistory> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(Set<MedicalHistory> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public TimerTime getTimerTime() {
        return timerTime;
    }

    public void setTimerTime(TimerTime timerTime) {
        this.timerTime = timerTime;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "idPassport=" + idPassport +
                ", family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", dateBirth=" + dateBirth +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        return idPassport == passport.idPassport;
    }

    @Override
    public int hashCode() {
        return (int) (idPassport ^ (idPassport >>> 32));
    }
}
