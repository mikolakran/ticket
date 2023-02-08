package com.web.repository;

import com.web.entity.Calendar;
import com.web.entity.Doctor;
import com.web.entity.PositionDoctor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorJpaRepository extends JpaRepository<Doctor,Long> {
    @Query("SELECT t FROM Doctor t LEFT JOIN FETCH t.calendars where t.idDoctor = :id")
    Doctor getCalendar(@Param("id") long id);
    @Query("select c.calendars from Doctor c join c.calendars b where c.idDoctor = :id ORDER BY b.idDate")
    List<Calendar> findCalendarByDoctor(@Param("id") long id, Pageable pageable);
    @Query("SELECT t FROM Doctor t LEFT JOIN FETCH t.positionDoctors where t.idDoctor = :id")
     Doctor getPosition(@Param("id") long id);
}
