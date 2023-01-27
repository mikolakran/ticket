package com.web.repository;

import com.web.entity.CalendarTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CalendarTicketJpaRepository extends JpaRepository<CalendarTicket,Long> {
    @Query("SELECT t FROM CalendarTicket t LEFT JOIN FETCH t.passports where t.idDate = :id")
    CalendarTicket getListPassportUser(@Param("id") long id);
}
