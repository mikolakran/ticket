package com.web.repository;

import com.web.entity.TimerTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface TimerTimeJpaRepository extends JpaRepository<TimerTime,Long> {
    @Query("SELECT t FROM TimerTime t where t.doctor.idDoctor = :idDoctor and t.calendar.localDate = :localDate")
  List<TimerTime> findTimeByDoctorAndLocalDate(@Param("idDoctor") long idDoctor, @Param("localDate")LocalDate localDate);
}
