package com.web.forms;

import com.web.entity.MedicalHistory;
import com.web.entity.Passport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
