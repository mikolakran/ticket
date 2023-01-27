package com.web.dao;

import com.web.entity.CalendarTicket;
import com.web.entity.Passport;

import java.util.Set;

public interface CalendarTicketDAO extends DAO<CalendarTicket,Long> {
    Set<CalendarTicket> findAll();
    Set<Passport> getListPassport(long idDoctor);
}
