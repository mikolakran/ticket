package com.web.controllers;

import com.web.facades.DoctorFacade;
import com.web.facades.PassportFacade;
import com.web.facades.TimerTimeFacade;
import com.web.forms.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DoctorFacade doctorFacade;

    @Autowired
    private PassportFacade passportFacade;

    @Autowired
    private TimerTimeFacade timerTimeFacade;

    @GetMapping("/doctors")
    public ModelAndView displayDoctorsByPosition(
            @SessionAttribute Set<DoctorForm> doctors,
            @SessionAttribute UserForm userSession) {
        ModelAndView modelAndView = new ModelAndView("user/doctors");
        modelAndView.addObject("userForm", userSession);
        modelAndView.addObject("doctors", doctors);
        if (doctors.size() == 0) {
            modelAndView.addObject("doctorsNull", "Doctors null");
        }
        return modelAndView;
    }

    @GetMapping("/doctors/calendars/{pageNo}")
    public ModelAndView displayCalendar(@PathVariable int pageNo,
                                        @RequestParam long idDoctor,
                                        @SessionAttribute UserForm userSession) {
        int pageSize = 15;
        int pageMinus = 0;
        ModelAndView modelAndView = new ModelAndView("user/calendars");
        modelAndView.addObject("userForm", userSession);
        DoctorForm doctor = doctorFacade.get(idDoctor);
        modelAndView.addObject("doctor", doctor);
        Set<CalendarForm> calendarUser = passportFacade.
                getListCalendarUser(userSession.getPassport().getIdPassport());
        LocalDate currentDate = LocalDate.now();
        if (pageNo == -1) {
            pageNo = 0;
            pageMinus = -1;
        }
        List<CalendarForm> calendarDoctor =
                doctorFacade.getCalendar(idDoctor, pageNo, pageSize);

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

    @GetMapping("/doctors/calendars/time")
    public ModelAndView displayTicketTime(@RequestParam LocalDate localDate,
                                          @RequestParam long idDoctor,
                                          @SessionAttribute UserForm userSession) {
        ModelAndView modelAndView = new ModelAndView("user/time");
        modelAndView.addObject("userForm", userSession);
        List<TimerTimeForm> timeByDoctorAndLocalDate =
                timerTimeFacade.findTimeByDoctorAndLocalDate(idDoctor, localDate);
        List<TimerTimeForm> collect = timeByDoctorAndLocalDate.stream()
                .sorted(Comparator.comparing(TimerTimeForm::getTime)).toList();
        modelAndView.addObject("timeTimers", collect);
        return modelAndView;
    }

    @GetMapping("/doctors/calendars/time/confirmTime")
    public ModelAndView displaySave(@RequestParam long idTime,
                                    @SessionAttribute UserForm userSession) {
        ModelAndView modelAndView = new ModelAndView("user/confirmTime");
        userSession.setIdTimeTimer(idTime);
        modelAndView.addObject("userForm", userSession);
        return modelAndView;
    }

    @GetMapping("/doctors/calendars/time/confirmTime/addTime")
    public ModelAndView saveUserTimeTicket(@SessionAttribute UserForm userSession,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView("welcome");
        PassportForm passportForm = passportFacade.get(userSession.getPassport().getIdPassport());
        TimerTimeForm timerTimeForm = timerTimeFacade.get(userSession.getIdTimeTimer());
        Set<TimerTimeForm> timerTimeForms = new HashSet<>();
        timerTimeForms.add(timerTimeForm);
        passportForm.setTimerTimes(timerTimeForms);
        timerTimeFacade.save(timerTimeForm);
        modelAndView.addObject("userForm", userSession);
        response.sendRedirect(request.getContextPath() + "/welcome/0");
        return modelAndView;
    }
}
