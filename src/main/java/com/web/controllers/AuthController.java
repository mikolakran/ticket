package com.web.controllers;

import com.web.facades.CalendarTicketFacade;
import com.web.facades.PositionDoctorFacade;
import com.web.facades.UserFacade;
import com.web.forms.CalendarTicketForm;
import com.web.forms.PositionDoctorForm;
import com.web.forms.UserForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AuthController {
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private CalendarTicketFacade calendarTicketFacade;

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
        response.sendRedirect(request.getContextPath() + "/welcome/0");
    }

    @GetMapping("/welcome/{pageNo}")
    public ModelAndView displayWelcome(@PathVariable int pageNo,
                                       @SessionAttribute UserForm userSession,
                                       @SessionAttribute(value = "positions", required = false)
                                       List<PositionDoctorForm> positions) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("userForm", userSession);
        if (positions != null) {
            modelAndView.addObject(positions);
        } else {
            modelAndView.addObject("positionNull", "Position Doctor null");
            int pageSize = 15;
            int pageMinus = 0;
            if (pageNo == -1) {
                pageNo = 0;
                pageMinus = - 1;
            }
            if (userSession.getDoctor()!=null) {
                List<CalendarTicketForm> byDoctor_idDoctor =
                        calendarTicketFacade.findByDoctor_IdDoctor(userSession.getDoctor().getIdDoctor(), pageNo, pageSize);
                if (byDoctor_idDoctor.size() != 0) {
                    LocalDate currentDate = LocalDate.now();
                    List<CalendarTicketForm> collect = byDoctor_idDoctor.
                            stream().filter(calendar -> currentDate.isBefore(calendar.getLocalDate()) ||
                                    currentDate.isEqual(calendar.getLocalDate()))
                            .sorted(Comparator.comparing(CalendarTicketForm::getLocalDate)).collect(Collectors.toList());
                    modelAndView.addObject("calendarDoctors", collect);
                    modelAndView.addObject("idDoctor", userSession.getDoctor().getIdDoctor());
                    modelAndView.addObject("pageNo", pageNo);
                    modelAndView.addObject("pageMinus", pageMinus);
                }
            }
        }
        return modelAndView;
    }

    @GetMapping("/addUser")
    public String registration() {
        return "addUser";
    }
}
