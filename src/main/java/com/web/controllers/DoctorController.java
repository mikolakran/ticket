package com.web.controllers;

import com.web.facades.CalendarFacade;
import com.web.facades.PassportFacade;
import com.web.forms.CalendarForm;
import com.web.forms.MedicalHistoryForm;
import com.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;


@Controller
public class DoctorController {

    @Autowired
    private CalendarFacade calendarFacade;

    @Autowired
    private PassportFacade passportFacade;

    @GetMapping("/allUsers")
    public ModelAndView displayCalendarForDoctor(@RequestParam long idDate,
                                                 @SessionAttribute UserForm userSession){
        ModelAndView modelAndView = new ModelAndView("allUsers");
        CalendarForm timeUser = calendarFacade.findId(idDate);
        modelAndView.addObject("currentDate",timeUser.getLocalDate());

        modelAndView.addObject("userForm",userSession);
        return modelAndView;
    }

    @GetMapping("/medicalHistory")
    public ModelAndView displayHistory(@RequestParam long idPassport,
                                       @SessionAttribute UserForm userSession){
        ModelAndView modelAndView = new ModelAndView("medicalHistory");
        Set<MedicalHistoryForm> listHistory = passportFacade.getListHistory(idPassport);
        modelAndView.addObject("idPassport",idPassport);
        modelAndView.addObject("medicalHistory",listHistory);
        modelAndView.addObject("userForm",userSession);
        return modelAndView;
    }

    @GetMapping("/addMedicalHistory")
     public ModelAndView addMedicalHistory(@RequestParam long idPassport,
                                           @SessionAttribute UserForm userSession){
        ModelAndView modelAndView = new ModelAndView("addMedicalHistory");
        modelAndView.addObject("idPassport",idPassport);
        modelAndView.addObject("userForm",userSession);
        return modelAndView;
    }

}
