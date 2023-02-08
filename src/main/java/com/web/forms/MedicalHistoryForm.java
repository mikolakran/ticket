package com.web.forms;

import com.web.entity.MedicalHistory;
import com.web.entity.Passport;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalHistoryForm implements Serializable {
    private long idMedical;
    private LocalDate localDate;
    private String underlyingDisease;
    private String complications;
    private String accompanyingIllnesses;
    private PassportForm passportForm;

    public MedicalHistoryForm(MedicalHistory medicalHistory) {
        this.idMedical = medicalHistory.getIdMedical();
        this.localDate = medicalHistory.getLocalDate();
        this.underlyingDisease = medicalHistory.getUnderlyingDisease();
        this.complications = medicalHistory.getComplications();
        this.accompanyingIllnesses = medicalHistory.getAccompanyingIllnesses();
        Passport passport = medicalHistory.getPassport();
        this.passportForm = new PassportForm(passport);
    }

    public long getIdMedical() {
        return idMedical;
    }

    public void setIdMedical(long idMedical) {
        this.idMedical = idMedical;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getUnderlyingDisease() {
        return underlyingDisease;
    }

    public void setUnderlyingDisease(String underlyingDisease) {
        this.underlyingDisease = underlyingDisease;
    }

    public String getComplications() {
        return complications;
    }

    public void setComplications(String complications) {
        this.complications = complications;
    }

    public String getAccompanyingIllnesses() {
        return accompanyingIllnesses;
    }

    public void setAccompanyingIllnesses(String accompanyingIllnesses) {
        this.accompanyingIllnesses = accompanyingIllnesses;
    }

    public PassportForm getPassportForm() {
        return passportForm;
    }

    public void setPassportForm(PassportForm passportForm) {
        this.passportForm = passportForm;
    }

    @Override
    public String toString() {
        return "MedicalHistoryForm{" +
                "idMedical=" + idMedical +
                ", underlyingDisease='" + underlyingDisease + '\'' +
                ", complications='" + complications + '\'' +
                ", accompanyingIllnesses='" + accompanyingIllnesses + '\'' +
                '}';
    }
}
