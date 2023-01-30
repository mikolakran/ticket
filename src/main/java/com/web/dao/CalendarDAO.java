package com.web.dao;

import com.web.entity.Calendar;
import com.web.entity.Passport;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface CalendarDAO extends DAO<Calendar,Long> {
    Set<Calendar> findAll();
    Set<Passport> getListPassport(long idDoctor);
    List<Calendar> findByDoctor_IdDoctor(long idDoctor, Pageable pageable);
}
