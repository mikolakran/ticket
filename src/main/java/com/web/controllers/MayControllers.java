package com.web.controllers;

import com.web.facades.PositionDoctorFacade;
import com.web.facades.UserFacade;
import com.web.forms.DoctorForm;
import com.web.forms.PositionDoctorForm;
import com.web.forms.UserForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
public class MayControllers {

    @Autowired
    private PositionDoctorFacade positionDoctorFacade;

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/")
    public String test(){
        return "home";
    }


    @PostMapping("/loginS")
    public void getLogin(@ModelAttribute("userForm") UserForm userForm,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        UserForm resultSQLUserForm = userFacade.getByName(userForm.getUserName());
        if (resultSQLUserForm.getPhoto() == null) {
            resultSQLUserForm.setPhoto(null);
        }
        request.getSession().setAttribute("userSession", resultSQLUserForm);
        response.sendRedirect(request.getContextPath() + "/welcome");
    }

    @GetMapping("/welcome")
    public ModelAndView displayWelcome(@SessionAttribute UserForm userSession,
                                       @SessionAttribute(value = "positions",required = false)
                                       List<PositionDoctorForm> positions) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("userForm", userSession);
        if (positions!=null){
            modelAndView.addObject(positions);
        }else {
            modelAndView.addObject("positionNull","Position Doctor null");
        }
        return modelAndView;
    }

    @GetMapping("/doctors")
    public ModelAndView displayDoctors(
            @SessionAttribute Set<DoctorForm> doctors,
            @SessionAttribute UserForm userSession,
                                       @RequestParam Long idPosition){
        ModelAndView modelAndView = new ModelAndView("doctors");
        modelAndView.addObject("userForm", userSession);
        modelAndView.addObject("doctors",doctors);
        if (doctors.size() == 0) {
            modelAndView.addObject("doctorsNull", "Doctors null");
        }
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
    public ModelAndView getAllPosition(){
        ModelAndView modelAndView = new ModelAndView("addDoctor");
        modelAndView.addObject("positions",positionDoctorFacade.findAll());
        return modelAndView;
    }

}
