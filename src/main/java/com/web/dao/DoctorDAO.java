package com.web.dao;

import com.web.entity.CalendarTicket;
import com.web.entity.Doctor;

import java.util.Set;

public interface DoctorDAO extends DAO<Doctor,Long>{
    Set<CalendarTicket> getCalendar(long id);
}
