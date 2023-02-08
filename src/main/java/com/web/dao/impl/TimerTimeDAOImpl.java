package com.web.dao.impl;

import com.web.dao.TimerTimeDAO;
import com.web.entity.TimerTime;
import com.web.repository.TimerTimeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TimerTimeDAOImpl implements TimerTimeDAO {

    @Autowired
    private TimerTimeJpaRepository timerTimeJpaRepository;

    @Override
    public TimerTime save(TimerTime timerTime) {
        return timerTimeJpaRepository.save(timerTime);
    }

    @Override
    public TimerTime get(Long aLong) {
        return null;
    }

    @Override
    public void update(TimerTime timerTime) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public TimerTime get(long idTimeTimer) {
        return timerTimeJpaRepository.findById(idTimeTimer).orElse(null);
    }

    @Override
    public List<TimerTime> findTimeByDoctorAndLocalDate(long idDoctor, LocalDate localDate) {
        return timerTimeJpaRepository.findTimeByDoctorAndLocalDate(idDoctor, localDate);
    }
}
