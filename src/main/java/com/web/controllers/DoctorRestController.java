package com.web.controllers;

import com.web.exception.MyException;
import com.web.facades.MedicalHistoryFacade;
import com.web.facades.PassportFacade;
import com.web.forms.MedicalHistoryForm;
import com.web.forms.PassportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class DoctorRestController {
    @Autowired
    private MedicalHistoryFacade medicalHistoryFacade;

    @Autowired
    private PassportFacade passportFacade;

    @RequestMapping(value = "/doctor/users/medicalHistory/addMedicalHistory", method = RequestMethod.POST)
    public ResponseEntity<MedicalHistoryForm> addMedicalHistory(
            @RequestBody() MedicalHistoryForm medicalHistoryForm,
            @RequestParam long idPassport) {
        MedicalHistoryForm history;
        LocalDate currentDate = LocalDate.now();
        medicalHistoryForm.setLocalDate(currentDate);
        PassportForm passportForm = passportFacade.get(idPassport);
        medicalHistoryForm.setPassportForm(passportForm);
        try {
            history = medicalHistoryFacade.save(medicalHistoryForm);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(history, HttpStatus.OK);
    }
}
