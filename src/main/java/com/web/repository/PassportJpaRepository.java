package com.web.repository;

import com.web.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PassportJpaRepository extends JpaRepository<Passport,Long> {
    @Query("SELECT t FROM Passport t LEFT JOIN FETCH t.calendarTicket where t.idPassport = :id")
    Passport getListCalendarUser(@Param("id") long id);
}
