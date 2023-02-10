package com.web.dao.impl;

import com.web.dao.CalendarDAO;
import com.web.entity.Calendar;
import com.web.entity.Doctor;
import com.web.repository.CalendarJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Repository
public class CalendarDAOImpl implements CalendarDAO {

    @Autowired
    private CalendarJpaRepository calendarJpaRepository;

    @Override
    public Calendar save(Calendar calendar) {
        return calendarJpaRepository.save(calendar);
    }

    @Override
    public Calendar get(Long aLong) {
        return calendarJpaRepository.findById(aLong).orElse(null);
    }

    @Override
    public void update(Calendar calendar) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Set<Calendar> findAll() {
        return new HashSet<>(calendarJpaRepository.findAll());
    }

    @Override
    public Set<Doctor> findListDoctor(LocalDate localDate) {
        return calendarJpaRepository.findListDoctor(localDate).getDoctors();
    }

    @Override
    public Calendar findLocalDate(LocalDate localDate) {
        return calendarJpaRepository.findCalendarByLocalDate(localDate);
    }

    @Override
    public Calendar findByMaxLocalDate() {
        LocalDate byMaxLocalDate = calendarJpaRepository.findByMaxLocalDate();
        return calendarJpaRepository.findCalendarByLocalDate(byMaxLocalDate);
    }

}
