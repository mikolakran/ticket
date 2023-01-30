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
        if(timeUser.getTime8_30()!=0){
            modelAndView.addObject("time8_30",passportFacade.get(timeUser.getTime8_30()));
        }
        if (timeUser.getTime9_00()!=0){
            modelAndView.addObject("time9_00",passportFacade.get(timeUser.getTime9_00()));
        }
        if (timeUser.getTime9_30()!=0){
            modelAndView.addObject("time9_30",passportFacade.get(timeUser.getTime9_30()));
        }
        if (timeUser.getTime10_00()!=0){
            modelAndView.addObject("time10_00",passportFacade.get(timeUser.getTime10_00()));
        }
        if (timeUser.getTime10_30()!=0){
            modelAndView.addObject("time10_30",passportFacade.get(timeUser.getTime10_30()));
        }
        if (timeUser.getTime11_00()!=0){
            modelAndView.addObject("time11_00",passportFacade.get(timeUser.getTime11_00()));
        }
        if (timeUser.getTime11_30()!=0){
            modelAndView.addObject("time11_30",passportFacade.get(timeUser.getTime11_30()));
        }
        if (timeUser.getTime13_00()!=0){
            modelAndView.addObject("time13_00",passportFacade.get(timeUser.getTime13_00()));
        }
        if (timeUser.getTime13_30()!=0){
            modelAndView.addObject("time13_30",passportFacade.get(timeUser.getTime13_30()));
        }
        if (timeUser.getTime14_00()!=0){
            modelAndView.addObject("time14_00",passportFacade.get(timeUser.getTime14_00()));
        }
        if (timeUser.getTime14_30()!=0){
            modelAndView.addObject("time14_30",passportFacade.get(timeUser.getTime14_30()));
        }
        if (timeUser.getTime15_00()!=0){
            modelAndView.addObject("time15_00",passportFacade.get(timeUser.getTime15_00()));
        }
        if (timeUser.getTime15_30()!=0){
            modelAndView.addObject("time15_30",passportFacade.get(timeUser.getTime15_30()));
        }
        if (timeUser.getTime16_00()!=0){
            modelAndView.addObject("time16_00",passportFacade.get(timeUser.getTime16_00()));
        }
        if (timeUser.getTime16_30()!=0){
            modelAndView.addObject("time16_30",passportFacade.get(timeUser.getTime16_30()));
        }
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
