package com.web.dao;

import com.web.entity.TimerTime;

import java.time.LocalDate;
import java.util.List;

public interface TimerTimeDAO extends DAO<TimerTime, Long> {
    TimerTime get(long idTimeTimer);
    List<TimerTime> findTimeByDoctorAndLocalDate(long idDoctor, LocalDate localDate);

}
