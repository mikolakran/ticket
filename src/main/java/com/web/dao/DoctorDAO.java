package com.web.dao;

import com.web.entity.Calendar;
import com.web.entity.Doctor;

import java.util.Set;

public interface DoctorDAO extends DAO<Doctor,Long>{
    Set<Calendar> getCalendar(long id);
}
