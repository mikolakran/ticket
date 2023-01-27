package com.web.controllers;

import com.web.facades.UserFacade;
import com.web.forms.CalendarTicketForm;
import com.web.forms.PositionDoctorForm;
import com.web.forms.UserForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class AuthController {
    @Autowired
    private UserFacade userFacade;

    @GetMapping("/")
    public String test() {
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
                                       @SessionAttribute(value = "positions", required = false)
                                       List<PositionDoctorForm> positions,
                                       @SessionAttribute(value = "calendarDoctor", required = false)
                                       List<CalendarTicketForm> calendarDoctor) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("userForm", userSession);
        if (positions != null) {
            modelAndView.addObject(positions);
        } else {
            modelAndView.addObject("positionNull", "Position Doctor null");
            if (calendarDoctor != null) {
                modelAndView.addObject(calendarDoctor);
            } else {
                modelAndView.addObject("calendarDoctorNull", "Your Calendar null");
            }
        }
        return modelAndView;
    }

    @GetMapping("/addUser")
    public String registration(){
        return "addUser";
    }
}
