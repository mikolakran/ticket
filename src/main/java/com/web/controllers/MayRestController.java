package com.web.controllers;

import com.web.entity.Doctor;
import com.web.exception.MyException;
import com.web.facades.*;
import com.web.forms.*;
import com.web.validation.Validation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

@RestController
public class MayRestController {
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private PositionDoctorFacade positionDoctorFacade;

    @Autowired
    private CalendarFacade calendarFacade;

    @Autowired
    public JavaMailSender emailSender;

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
            new Validation.Builder().
                    validationPassSamePass2(userForm.getPassword(), userForm.getConfirmPassword())
                    .validationPassword(userForm.getPassword()).build();
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

    @RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
    public ResponseEntity<UserForm> addDoctor(
            @RequestBody() UserForm userForm) throws IOException {
        UserForm user;
        MultipartFile multipartFile = userForm.getMultipartFile();
        if (multipartFile != null) {
            userForm.setPhoto(multipartFile.getBytes());
        }
        try {
            //save user
            new Validation.Builder().
                    validationPassSamePass2(userForm.getPassword(), userForm.getConfirmPassword())
                    .validationPassword(userForm.getPassword()).build();
            userForm.setPasswordEmail(userForm.getPassword());
            userForm.setPassword(BCrypt.hashpw(userForm.getPassword(), BCrypt.gensalt(12)));
            userForm.setRole("doctor");
            user = userFacade.save(userForm);
            //save doctor
            Doctor doctor = user.getDoctor();
            DoctorForm doctorForm = new DoctorForm(doctor);
            PositionDoctorForm positionDoctorForm = positionDoctorFacade.findByName(userForm.getPositionDoctor());
            Set<DoctorForm> listDoctor = positionDoctorFacade.getListDoctor(positionDoctorForm.getPositionDoctorId());
            listDoctor.add(doctorForm);
            positionDoctorForm.setDoctors(listDoctor);
            positionDoctorFacade.update(positionDoctorForm);
            //send email
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(user.getEmail());
            message.setSubject("Registration user");
            message.setText("Hello, your login - "+user.getUserName()+" password - "+userForm.getPasswordEmail()+
                    "  position - "+
                    positionDoctorForm.getPosition()+" beginning work - " +positionDoctorForm.getBeginningWork()+
                    " end work - "+positionDoctorForm.getEndWork()+" beginning break - "
                    +positionDoctorForm.getBeginningBreak()+" end break - "+positionDoctorForm.getEndBreak());
            this.emailSender.send(message);
            //create calendar
            LocalDate currentDate = LocalDate.now();
            for (int i = 0; i < 60; i++) {
                CalendarForm calendarForm = new CalendarForm();
                LocalDate date = currentDate.plusDays(i);
                DayOfWeek dayOfWeek = date.getDayOfWeek();
                if (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) {
                    continue;
                }
                LocalDate localDate = currentDate.plusDays(i);
                calendarForm.setLocalDate(localDate);
                calendarForm.setDoctor(doctorForm);
                calendarFacade.save(calendarForm);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (MyException e) {
            user = new UserForm();
            user.setError(e.getMessage());
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/addPositionDoctor", method = RequestMethod.POST)
    public ResponseEntity<PositionDoctorForm> addPositionDoctor(
            @RequestBody() PositionDoctorForm positionDoctorForm) {
        PositionDoctorForm resultSave = null;
        try {
            resultSave = positionDoctorFacade.save(positionDoctorForm);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(resultSave, HttpStatus.OK);
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
