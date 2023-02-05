package com.web.controllers;

import com.web.facades.CalendarFacade;
import com.web.facades.DoctorFacade;
import com.web.facades.PositionDoctorFacade;
import com.web.facades.UserFacade;
import com.web.forms.CalendarForm;
import com.web.forms.DoctorForm;
import com.web.forms.PositionDoctorForm;
import com.web.forms.UserForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private PositionDoctorFacade positionDoctorFacade;

    @Autowired
    private CalendarFacade calendarFacade;

    @Autowired
    private DoctorFacade doctorFacade;

    @GetMapping("/users")
    public ModelAndView displayUsers() {
        ModelAndView modelAndView = new ModelAndView("admin/usersOrDoctors");
        List<UserForm> users = userFacade.getListUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/doctors")
    public ModelAndView displayDoctors() {
        ModelAndView modelAndView = new ModelAndView("admin/usersOrDoctors");
        List<UserForm> doctors = userFacade.getListDoctors();
        modelAndView.addObject("doctors", doctors);
        return modelAndView;
    }

    @GetMapping("/positions")
    public ModelAndView displayPosition() {
        ModelAndView modelAndView = new ModelAndView("admin/usersOrDoctors");
        List<PositionDoctorForm> all = positionDoctorFacade.findAll();
        modelAndView.addObject("positions", all);
        return modelAndView;
    }

    @GetMapping("/createPositionDoctor")
    public ModelAndView displayAddTopic(@SessionAttribute UserForm userSession) {
        ModelAndView modelAndView = new ModelAndView("admin/createPositionDoctor");
        if (userSession.getRole().equals("admin")) {
            modelAndView.addObject("userForm", userSession);
        }
        return modelAndView;
    }

    @GetMapping("/createDoctor")
    public ModelAndView getAllPosition(@SessionAttribute UserForm userSession) {
        ModelAndView modelAndView = new ModelAndView("admin/createDoctor");
        modelAndView.addObject("positions", positionDoctorFacade.findAll());
        modelAndView.addObject("userForm", userSession);
        return modelAndView;
    }

    @GetMapping("/createCalendar")
    public String addCalendar(HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {
        CalendarForm byMaxLocalDate = calendarFacade.findByMaxLocalDate();
        if (byMaxLocalDate!=null){
            LocalDate maxLocalDateLocalDate = byMaxLocalDate.getLocalDate();
            createYear(maxLocalDateLocalDate);
        }else {
            LocalDate currentDate = LocalDate.now();
            createYear(currentDate);
        }
        response.sendRedirect(request.getContextPath() + "/welcome/0");
        return "welcome";
    }

    @GetMapping("/findDoctor")
    public ModelAndView findDoctor(@SessionAttribute UserForm userSession) {
        ModelAndView modelAndView = new ModelAndView("admin/findDoctor");
        modelAndView.addObject("userForm", userSession);
        return modelAndView;
    }

    @GetMapping("/doctor")
    public ModelAndView getDoctor(@SessionAttribute("doctor") DoctorForm doctorForm,
                                  @SessionAttribute UserForm userSession) {
        ModelAndView modelAndView = new ModelAndView("admin/usersOrDoctors");
        modelAndView.addObject("doctor", doctorForm);
        modelAndView.addObject("userForm", userSession);
        return modelAndView;
    }

    @GetMapping("/doctor/addCalendar")
    public ModelAndView addMonth(@SessionAttribute("doctor") DoctorForm doctorForm,
                                 @SessionAttribute UserForm userSession) {
        ModelAndView modelAndView = new ModelAndView("admin/addCalendar");
        Set<CalendarForm> calendars = doctorFacade.getCalendar(doctorForm.getIdDoctor());
        if (calendars.size()!=0) {
            CalendarForm calendarForm = calendars.stream().max(Comparator.comparing(CalendarForm::getLocalDate)).
                    orElseThrow(NoSuchElementException::new);
            modelAndView.addObject("calendarForm",calendarForm);
        }else {
            modelAndView.addObject("noCalendar","the doctor has no calendar");
        }

        modelAndView.addObject("userForm", userSession);
        return modelAndView;
    }

    private void createYear(LocalDate currentLocalDate) {
        int i = 0;
        while (i<365){
            currentLocalDate = currentLocalDate.plusDays(1);
            CalendarForm calendar = new CalendarForm(currentLocalDate);
            calendarFacade.save(calendar);
            i++;
        }
    }
}
