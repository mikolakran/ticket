package com.web.controllers;

import com.web.facades.PassportFacade;
import com.web.facades.TimerTimeFacade;
import com.web.forms.MedicalHistoryForm;
import com.web.forms.TimerTimeForm;
import com.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private TimerTimeFacade timerTimeFacade;

    @Autowired
    private PassportFacade passportFacade;

    @GetMapping("/users")
    public ModelAndView displayCalendarForDoctor(@RequestParam LocalDate localDate,
                                                 @SessionAttribute UserForm userSession){
        ModelAndView modelAndView = new ModelAndView("doctor/users");
        List<TimerTimeForm> timeByDoctorAndLocalDate =
                timerTimeFacade.findTimeByDoctorAndLocalDate(userSession.getDoctor().getIdDoctor(), localDate);
        modelAndView.addObject("currentDate",timeByDoctorAndLocalDate);
        modelAndView.addObject("localDate",localDate);
        modelAndView.addObject("userForm",userSession);
        return modelAndView;
    }

    @GetMapping("/users/medicalHistory")
    public ModelAndView displayHistory(@RequestParam long idPassport,
                                       @SessionAttribute UserForm userSession){
        ModelAndView modelAndView = new ModelAndView("doctor/medicalHistory");
        Set<MedicalHistoryForm> listHistory = passportFacade.getListHistory(idPassport);
        modelAndView.addObject("idPassport",idPassport);
        modelAndView.addObject("medicalHistory",listHistory);
        modelAndView.addObject("userForm",userSession);
        return modelAndView;
    }

    @GetMapping("/users/medicalHistory/addMedicalHistory")
     public ModelAndView addMedicalHistory(@RequestParam long idPassport,
                                           @SessionAttribute UserForm userSession){
        ModelAndView modelAndView = new ModelAndView("doctor/addMedicalHistory");
        modelAndView.addObject("idPassport",idPassport);
        modelAndView.addObject("userForm",userSession);
        return modelAndView;
    }

}
