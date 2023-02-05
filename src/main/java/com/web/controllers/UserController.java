package com.web.controllers;

import com.web.exception.MyException;
import com.web.facades.CalendarFacade;
import com.web.facades.DoctorFacade;
import com.web.facades.PassportFacade;
import com.web.forms.CalendarForm;
import com.web.forms.DoctorForm;
import com.web.forms.PassportForm;
import com.web.forms.UserForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private CalendarFacade calendarFacade;

    @Autowired
    private DoctorFacade doctorFacade;

    @Autowired
    private PassportFacade passportFacade;

    @GetMapping("/addUser")
    public String registration() {
        return "addUser";
    }

    @GetMapping("/doctorByPosition")
    public ModelAndView displayDoctorsByPosition(
            @SessionAttribute Set<DoctorForm> doctors,
            @SessionAttribute UserForm userSession) {
        ModelAndView modelAndView = new ModelAndView("doctorByPosition");
        modelAndView.addObject("userForm", userSession);
        modelAndView.addObject("doctors", doctors);
        if (doctors.size() == 0) {
            modelAndView.addObject("doctorsNull", "Doctors null");
        }
        return modelAndView;
    }

    @GetMapping("/calendarForUser/{pageNo}")
    public ModelAndView displayCalendar(@PathVariable int pageNo,
                                        @RequestParam Long idDoctor,
                                        @SessionAttribute UserForm userSession) {
        int pageSize = 15;
        int pageMinus = 0;
        ModelAndView modelAndView = new ModelAndView("calendarForUser");
        modelAndView.addObject("userForm", userSession);
        DoctorForm doctor = doctorFacade.get(idDoctor);
        modelAndView.addObject("doctor", doctor);
        Set<CalendarForm> calendarUser = passportFacade.
                getListCalendarUser(userSession.getPassport().getIdPassport());
        LocalDate currentDate = LocalDate.now();
        if (pageNo == -1) {
            pageNo = 0;
            pageMinus = - 1;
        }
            List<CalendarForm> calendarDoctor =
                    calendarFacade.findByDoctor_IdDoctor(idDoctor, pageNo, pageSize);

            calendarUser.forEach(calendar -> calendarDoctor.removeIf(calendar::equals));

            List<CalendarForm> collect = calendarDoctor.stream().filter(calendar ->
                            currentDate.isBefore(calendar.getLocalDate()) ||
                                    currentDate.isEqual(calendar.getLocalDate()))
                    .sorted(Comparator.comparing(CalendarForm::getLocalDate)).toList();

            modelAndView.addObject("calendarDoctors", collect);
            modelAndView.addObject("idDoctor", idDoctor);
            modelAndView.addObject("pageNo", pageNo);
            modelAndView.addObject("pageMinus", pageMinus);
            return modelAndView;
        }

        @GetMapping("/time")
        public ModelAndView displayTicketTime ( @RequestParam long idDate,
        @SessionAttribute UserForm userSession){
            ModelAndView modelAndView = new ModelAndView("time");
            modelAndView.addObject("userForm", userSession);
            CalendarForm calendarTime = calendarFacade.findId(idDate);
            modelAndView.addObject("calendarTime", calendarTime);
            return modelAndView;
        }

        @GetMapping("/confirmTime")
        public ModelAndView displaySave ( @RequestParam long idDate,
        @RequestParam String time,
        @SessionAttribute UserForm userSession){
            ModelAndView modelAndView = new ModelAndView("confirmTime");
            userSession.setIdDate(idDate);
            userSession.setTicketTime(time);
            modelAndView.addObject("userForm", userSession);
            return modelAndView;
        }

       /* @GetMapping("/addUserTimeTicket")
        public ModelAndView saveUserTimeTicket ( @RequestParam long idDate,
        @RequestParam String ticketTime,
        @SessionAttribute UserForm userSession,
        HttpServletRequest request,
        HttpServletResponse response) throws IOException {
            ModelAndView modelAndView = new ModelAndView("welcome");
            PassportForm passportForm = passportFacade.get(userSession.getPassport().getIdPassport());
            CalendarForm calendarForm = calendarFacade.findId(idDate);
            Set<PassportForm> listPassport = calendarFacade.getListPassport(idDate);
            listPassport.add(passportForm);
                calendarFacade.save(calendarForm);
            modelAndView.addObject("userForm", userSession);
            response.sendRedirect(request.getContextPath() + "/welcome/0");
            return modelAndView;
        }*/
    }
