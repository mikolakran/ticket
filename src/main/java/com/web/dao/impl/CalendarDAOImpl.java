package com.web.dao.impl;

import com.web.dao.CalendarDAO;
import com.web.entity.Calendar;
import com.web.entity.Passport;
import com.web.repository.CalendarJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
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
    public Set<Passport> getListPassport(long idDoctor) {
        return calendarJpaRepository.getListPassportUser(idDoctor).getPassports();
    }

    @Override
    public List<Calendar> findByDoctor_IdDoctor(long idDoctor, Pageable pageable) {
        return calendarJpaRepository.findByDoctor_IdDoctor(idDoctor,pageable);
    }

}
