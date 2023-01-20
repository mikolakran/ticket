package com.web.controllers;

import com.web.entity.Doctor;
import com.web.facades.PositionDoctorFacade;
import com.web.forms.DoctorForm;
import com.web.forms.PositionDoctorForm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.web.exception.MyException;
import com.web.facades.UserFacade;
import com.web.forms.UserForm;
import com.web.validation.Validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class MayRestController {
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private PositionDoctorFacade positionDoctorFacade;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseEntity<UserForm> addUser(HttpServletRequest request,
                                            @RequestBody() UserForm userForm) throws IOException {
        UserForm user;
        MultipartFile multipartFile = userForm.getMultipartFile();
        if (multipartFile!=null) {
            userForm.setPhoto(multipartFile.getBytes());
        }
        try {
            new Validation.Builder().
                    validationPassSamePass2(userForm.getPassword(), userForm.getConfirmPassword()).build();
            userForm.setPassword(BCrypt.hashpw(userForm.getPassword(), BCrypt.gensalt(12)));
            if (userForm.getEmail().equals("mikolakran@gmail.ru")){
                userForm.setRole("admin");
            }else {
                userForm.setRole("user");
            }
            user = userFacade.save(userForm);
            request.getSession().setAttribute("userSession", user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (MyException e) {
            user = new UserForm();
            user.setError(e.getMessage());
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/addDoctor",method = RequestMethod.POST)
    public ResponseEntity<UserForm> addDoctor(
                                            @RequestBody() UserForm userForm) throws IOException {
        UserForm user;
        MultipartFile multipartFile = userForm.getMultipartFile();
        if (multipartFile!=null) {
            userForm.setPhoto(multipartFile.getBytes());
        }
        try {
            new Validation.Builder().
                    validationPassSamePass2(userForm.getPassword(), userForm.getConfirmPassword()).build();
            userForm.setPassword(BCrypt.hashpw(userForm.getPassword(), BCrypt.gensalt(12)));
            userForm.setRole("doctor");
            user = userFacade.save(userForm);
            Doctor doctor = user.getDoctor();
            DoctorForm doctorForm = new DoctorForm(doctor);
            PositionDoctorForm positionDoctorForm = positionDoctorFacade.findByName(userForm.getPositionDoctor());
            Set<DoctorForm> listDoctor  = positionDoctorFacade.getListDoctor(positionDoctorForm.getPositionDoctorId());
            listDoctor.add(doctorForm);
            positionDoctorForm.setDoctors(listDoctor);
            positionDoctorFacade.update(positionDoctorForm);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (MyException e) {
            user = new UserForm();
            user.setError(e.getMessage());
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/addPositionDoctor",method = RequestMethod.POST)
    public ResponseEntity<PositionDoctorForm> addPositionDoctor(
                                              @RequestBody() PositionDoctorForm positionDoctorForm){
        PositionDoctorForm resultSave = positionDoctorFacade.save(positionDoctorForm);
        return new ResponseEntity<>(resultSave,HttpStatus.OK);
    }


}
