package com.web.facades;

import com.web.dao.PassportDAO;
import com.web.entity.CalendarTicket;
import com.web.entity.Passport;
import com.web.exception.MyException;
import com.web.forms.CalendarTicketForm;
import com.web.forms.PassportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PassportFacade {
    @Autowired
    private PassportDAO passportDAO;

    public Passport save(Passport passport) throws MyException {
        return passportDAO.save(passport);
    }

    public PassportForm get(long idPassport) {
        Passport passport = passportDAO.get(idPassport);
        return new PassportForm(passport);
    }

    public Set<CalendarTicketForm> getListCalendarUser(long idPassport) {
        Set<CalendarTicketForm> calendarTicketForms = new HashSet<>();
        Set<CalendarTicket> calendarTickets = passportDAO.getListCalendar(idPassport);
        calendarTickets.forEach(calendarTicket -> {
            CalendarTicketForm calendarTicketForm = new CalendarTicketForm(calendarTicket);
            calendarTicketForms.add(calendarTicketForm);
        });
        return calendarTicketForms;
    }

}
