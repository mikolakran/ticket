package com.web.controllers;

import com.web.exception.MyException;
import com.web.facades.CalendarTicketFacade;
import com.web.facades.DoctorFacade;
import com.web.facades.PassportFacade;
import com.web.forms.CalendarTicketForm;
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
public class CalendarUserController {

    @Autowired
    private CalendarTicketFacade calendarTicketFacade;

    @Autowired
    private DoctorFacade doctorFacade;

    @Autowired
    private PassportFacade passportFacade;

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

    @GetMapping("/calendarTicket/{pageNo}")
    public ModelAndView displayCalendar(@PathVariable int pageNo,
                                        @RequestParam Long idDoctor,
                                        @SessionAttribute UserForm userSession) {
        int pageSize = 15;
        int pageMinus = 0;
        ModelAndView modelAndView = new ModelAndView("calendarTicket");
        modelAndView.addObject("userForm", userSession);
        DoctorForm doctor = doctorFacade.get(idDoctor);
        modelAndView.addObject("doctor", doctor);
        Set<CalendarTicketForm> listCalendarUser = passportFacade.
                getListCalendarUser(userSession.getPassport().getIdPassport());
        LocalDate currentDate = LocalDate.now();
        if (pageNo == -1) {
            pageNo = 0;
            pageMinus = - 1;
        }
            List<CalendarTicketForm> byDoctor_idDoctor =
                    calendarTicketFacade.findByDoctor_IdDoctor(idDoctor, pageNo, pageSize);

            listCalendarUser.forEach(calendar -> byDoctor_idDoctor.removeIf(calendar::equals));

            List<CalendarTicketForm> collect = byDoctor_idDoctor.stream().filter(calendar ->
                            currentDate.isBefore(calendar.getLocalDate()) ||
                                    currentDate.isEqual(calendar.getLocalDate()))
                    .sorted(Comparator.comparing(CalendarTicketForm::getLocalDate)).toList();

            modelAndView.addObject("calendarDoctors", collect);
            modelAndView.addObject("idDoctor", idDoctor);
            modelAndView.addObject("pageNo", pageNo);
            modelAndView.addObject("pageMinus", pageMinus);
            return modelAndView;
        }

        @GetMapping("/ticketTimes")
        public ModelAndView displayTicketTime ( @RequestParam long idDate,
        @SessionAttribute UserForm userSession){
            ModelAndView modelAndView = new ModelAndView("ticketTimes");
            modelAndView.addObject("userForm", userSession);
            CalendarTicketForm ticketForm = calendarTicketFacade.findId(idDate);
            modelAndView.addObject("calendarTime", ticketForm);
            return modelAndView;
        }

        @GetMapping("/confirmTimeUser")
        public ModelAndView displaySave ( @RequestParam long idDate,
        @RequestParam String ticketTime,
        @SessionAttribute UserForm userSession){
            ModelAndView modelAndView = new ModelAndView("confirmTimeUser");
            userSession.setIdDate(idDate);
            userSession.setTicketTime(ticketTime);
            modelAndView.addObject("userForm", userSession);
            return modelAndView;
        }

        @GetMapping("/addUserTimeTicket")
        public ModelAndView saveUserTimeTicket ( @RequestParam long idDate,
        @RequestParam String ticketTime,
        @SessionAttribute UserForm userSession,
        HttpServletRequest request,
        HttpServletResponse response) throws IOException {
            ModelAndView modelAndView = new ModelAndView("welcome");
            PassportForm passportForm = passportFacade.get(userSession.getPassport().getIdPassport());
            CalendarTicketForm calendarTicketForm = calendarTicketFacade.findId(idDate);
            Set<PassportForm> listPassport = calendarTicketFacade.getListPassport(idDate);
            listPassport.add(passportForm);
            if (ticketTime.equals("time8_30")) {
                calendarTicketForm.setTime8_30((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time9_00")) {
                calendarTicketForm.setTime9_00((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time9_30")) {
                calendarTicketForm.setTime9_30((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time10_00")) {
                calendarTicketForm.setTime10_00((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time10_30")) {
                calendarTicketForm.setTime10_30((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time11_00")) {
                calendarTicketForm.setTime11_00((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time11_30")) {
                calendarTicketForm.setTime11_30((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time13_00")) {
                calendarTicketForm.setTime13_00((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time13_30")) {
                calendarTicketForm.setTime13_30((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time14_00")) {
                calendarTicketForm.setTime14_00((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time14_30")) {
                calendarTicketForm.setTime14_30((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time15_00")) {
                calendarTicketForm.setTime15_00((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time15_30")) {
                calendarTicketForm.setTime15_30((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time16_00")) {
                calendarTicketForm.setTime16_00((int) passportForm.getIdPassport());
            }
            if (ticketTime.equals("time16_30")) {
                calendarTicketForm.setTime16_30((int) passportForm.getIdPassport());
            }
            calendarTicketForm.setPassports(listPassport);
            try {
                calendarTicketFacade.save(calendarTicketForm);
            } catch (MyException e) {
                throw new RuntimeException(e);
            }
            modelAndView.addObject("userForm", userSession);
            response.sendRedirect(request.getContextPath() + "/welcome/0");
            return modelAndView;
        }
    }
