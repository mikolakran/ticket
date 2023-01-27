package com.web.repository;

import com.web.entity.CalendarTicket;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarTicketJpaRepository extends JpaRepository<CalendarTicket,Long> {
    @Query("SELECT t FROM CalendarTicket t LEFT JOIN FETCH t.passports where t.idDate = :id")
    CalendarTicket getListPassportUser(@Param("id") long id);
    List<CalendarTicket> findByDoctor_IdDoctor(long id, Pageable pageable);
}
