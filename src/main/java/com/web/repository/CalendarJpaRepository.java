package com.web.repository;

import com.web.entity.Calendar;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarJpaRepository extends JpaRepository<Calendar,Long> {
    @Query("SELECT t FROM Calendar t LEFT JOIN FETCH t.passports where t.idDate = :id")
    Calendar getListPassportUser(@Param("id") long id);
    List<Calendar> findByDoctor_IdDoctor(long id, Pageable pageable);
}
