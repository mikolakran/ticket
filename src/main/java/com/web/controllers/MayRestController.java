package com.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.web.exception.MyException;
import com.web.facades.UserFacade;
import com.web.forms.UserForm;
import com.web.validation.Validation;

import java.io.IOException;

@RestController
public class MayRestController {
    @Autowired
    private UserFacade userFacade;

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
//            userFacade.getRole(userForm);
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
    public ResponseEntity<UserForm> addDoctor(HttpServletRequest request,
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
//            userFacade.getRole(userForm);
            user = userFacade.save(userForm);
            request.getSession().setAttribute("userSession", user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (MyException e) {
            user = new UserForm();
            user.setError(e.getMessage());
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }
}
