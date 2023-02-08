package com.web.dao;

import com.web.entity.Calendar;
import com.web.entity.Doctor;
import com.web.entity.PositionDoctor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface DoctorDAO extends DAO<Doctor,Long>{
    List<Calendar> getCalendar(long id);
    List<Calendar> getCalendar(long id, Pageable pageable);
    Set<PositionDoctor> getPosition(long idDoctor);
}
