package com.web.forms;

import com.web.entity.Passport;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

public class PassportForm implements Serializable {

    private long idPassport;
    private String family;
    private String name;
    private String patronymic;
    private String contactNumber;
    private LocalDate dateBirth;
    private String gender;
    private String address;
    private UserForm user;
    private Set<TimerTimeForm> timerTimes;
    private Set<MedicalHistoryForm> medicalHistory;

    public PassportForm(Passport passport){
        this.idPassport = passport.getIdPassport();
        this.family = passport.getFamily();
        this.name = passport.getName();
        this.patronymic = passport.getPatronymic();
        this.contactNumber = passport.getContactNumber();
        this.dateBirth = passport.getDateBirth();
        this.gender = passport.getGender();
        this.address = passport.getAddress();
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

    public UserForm getUser() {
        return user;
    }

    public void setUser(UserForm user) {
        this.user = user;
    }

    public Set<TimerTimeForm> getTimerTimes() {
        return timerTimes;
    }

    public void setTimerTimes(Set<TimerTimeForm> timerTimes) {
        this.timerTimes = timerTimes;
    }

    public Set<MedicalHistoryForm> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(Set<MedicalHistoryForm> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "PassportForm{" +
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
}
