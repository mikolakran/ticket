package com.web.controllers;

import com.web.facades.PositionDoctorFacade;
import com.web.facades.UserFacade;
import com.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private PositionDoctorFacade positionDoctorFacade;

    @GetMapping("/users")
    public ModelAndView displayUsers(){
        ModelAndView modelAndView = new ModelAndView("usersOrDoctors");
        List<UserForm> users = userFacade.getListUsers();
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @GetMapping("/doctors")
    public ModelAndView displayDoctors(){
        ModelAndView modelAndView = new ModelAndView("usersOrDoctors");
        List<UserForm> doctors = userFacade.getListDoctors();
        modelAndView.addObject("doctors",doctors);
        return modelAndView;
    }

    @GetMapping("/addPositionDoctor")
    public ModelAndView displayAddTopic(@SessionAttribute UserForm userSession) {
        ModelAndView modelAndView = new ModelAndView("addPositionDoctor");
        if (userSession.getRole().equals("admin")) {
            modelAndView.addObject("userForm", userSession);
        }
        return modelAndView;
    }

    @GetMapping("/addDoctor")
    public ModelAndView getAllPosition() {
        ModelAndView modelAndView = new ModelAndView("addDoctor");
        modelAndView.addObject("positions", positionDoctorFacade.findAll());
        return modelAndView;
    }
}
