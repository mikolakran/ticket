package com.web.repository;

import com.web.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface CalendarJpaRepository extends JpaRepository<Calendar,Long> {
    @Query("SELECT t FROM Calendar t LEFT JOIN FETCH t.doctors where t.localDate = :id")
    Calendar findListDoctor(@Param("id") LocalDate id);
    Calendar findCalendarByLocalDate(LocalDate date);
    @Query(value = "SELECT max(c.localDate) from Calendar c")
    LocalDate findByMaxLocalDate();
}
