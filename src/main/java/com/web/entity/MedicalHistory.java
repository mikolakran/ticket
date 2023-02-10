package com.web.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "medicalHistory")
public class MedicalHistory  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedical")
    private long idMedical;
    @Column
    private LocalDate localDate;
    @Column
    private String underlyingDisease;
    @Column
    private String complications;
    @Column
    private String accompanyingIllnesses;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idPassport")
    private Passport passport;

    public MedicalHistory() {
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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "MedicalHistory{" +
                "idMedical=" + idMedical +
                ", localDate=" + localDate +
                ", underlyingDisease='" + underlyingDisease + '\'' +
                ", complications='" + complications + '\'' +
                ", accompanyingIllnesses='" + accompanyingIllnesses + '\'' +
                '}';
    }
}
