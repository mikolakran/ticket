package com.web.dao;

import com.web.entity.Calendar;
import com.web.entity.Doctor;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface CalendarDAO extends DAO<Calendar,Long> {
    Set<Calendar> findAll();
    Set<Doctor> findListDoctor(LocalDate localDate);
    List<Calendar> findByDoctor_IdDoctor(long idDoctor, Pageable pageable);

    Calendar findLocalDate(LocalDate localDate);
    Calendar findByMaxLocalDate();
}
