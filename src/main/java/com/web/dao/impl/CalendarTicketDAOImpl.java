package com.web.dao.impl;

import com.web.dao.CalendarTicketDAO;
import com.web.entity.CalendarTicket;
import com.web.entity.Passport;
import com.web.repository.CalendarTicketJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class CalendarTicketDAOImpl implements CalendarTicketDAO {

    @Autowired
    private CalendarTicketJpaRepository calendarTicketJpaRepository;

    @Override
    public CalendarTicket save(CalendarTicket calendarTicket) {
        return calendarTicketJpaRepository.save(calendarTicket);
    }

    @Override
    public CalendarTicket get(Long aLong) {
        return calendarTicketJpaRepository.findById(aLong).orElse(null);
    }

    @Override
    public void update(CalendarTicket calendarTicket) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Set<CalendarTicket> findAll() {
        return new HashSet<>(calendarTicketJpaRepository.findAll());
    }

    @Override
    public Set<Passport> getListPassport(long idDoctor) {
        return calendarTicketJpaRepository.getListPassportUser(idDoctor).getPassports();
    }

}
