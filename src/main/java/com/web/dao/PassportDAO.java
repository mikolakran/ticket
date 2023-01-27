package com.web.dao;

import com.web.entity.CalendarTicket;
import com.web.entity.Passport;

import java.util.Set;

public interface PassportDAO extends DAO<Passport,Long>{
    Set<CalendarTicket> getListCalendar(long idDoctor);
}
