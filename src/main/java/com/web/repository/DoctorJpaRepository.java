package com.web.repository;

import com.web.entity.Calendar;
import com.web.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorJpaRepository extends JpaRepository<Doctor,Long> {
    @Query("SELECT t FROM Doctor t LEFT JOIN FETCH t.calendars where t.idDoctor = :id")
    Doctor getCalendar(@Param("id") long id);
}
