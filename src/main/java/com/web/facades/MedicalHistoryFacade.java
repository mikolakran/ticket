package com.web.facades;

import com.web.dao.MedicalHistoryDAO;
import com.web.entity.MedicalHistory;
import com.web.entity.Passport;
import com.web.exception.MyException;
import com.web.forms.MedicalHistoryForm;
import com.web.forms.PassportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicalHistoryFacade {
    @Autowired
    private MedicalHistoryDAO medicalHistoryDAO;

    public MedicalHistoryForm save(MedicalHistoryForm medicalHistoryForm) throws MyException {
        MedicalHistory medicalHistory = new MedicalHistory();
        build(medicalHistory,medicalHistoryForm);
        MedicalHistory resultSave = medicalHistoryDAO.save(medicalHistory);
        return new MedicalHistoryForm(resultSave);
    }

    private void build(MedicalHistory medicalHistory, MedicalHistoryForm medicalHistoryForm) {
        medicalHistory.setIdMedical(medicalHistoryForm.getIdMedical());
        medicalHistory.setLocalDate(medicalHistoryForm.getLocalDate());
        medicalHistory.setUnderlyingDisease(medicalHistoryForm.getUnderlyingDisease());
        medicalHistory.setComplications(medicalHistoryForm.getComplications());
        medicalHistory.setAccompanyingIllnesses(medicalHistoryForm.getAccompanyingIllnesses());
        PassportForm passportForm = medicalHistoryForm.getPassportForm();
        medicalHistory.setPassport(new Passport(passportForm.getIdPassport(),passportForm.getFamily(),
                passportForm.getName(),passportForm.getPatronymic(),passportForm.getContactNumber(),
                passportForm.getDateBirth(), passportForm.getGender(), passportForm.getAddress()));
    }
}
