package com.web.controllers;

import com.web.exception.MyException;
import com.web.facades.MedicalHistoryFacade;
import com.web.facades.PassportFacade;
import com.web.facades.UserFacade;
import com.web.forms.MedicalHistoryForm;
import com.web.forms.PassportForm;
import com.web.forms.UserForm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
public class UserRestController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private MedicalHistoryFacade medicalHistoryFacade;

    @Autowired
    private PassportFacade passportFacade;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<UserForm> addUser(HttpServletRequest request,
                                            @RequestBody() UserForm userForm) throws IOException {
        UserForm user;
        MultipartFile multipartFile = userForm.getMultipartFile();
        if (multipartFile != null) {
            userForm.setPhoto(multipartFile.getBytes());
        }
        try {
            userForm.setPassword(BCrypt.hashpw(userForm.getPassword(), BCrypt.gensalt(12)));
            if (userForm.getEmail().equals("mikolakran@gmail.ru")) {
                userForm.setRole("admin");
            } else {
                userForm.setRole("user");
            }
            user = userFacade.save(userForm);
            request.getSession().setAttribute("userSession", user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (MyException e) {
            user = new UserForm();
            user.setError(e.getMessage());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/addMedicalHistory", method = RequestMethod.POST)
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
