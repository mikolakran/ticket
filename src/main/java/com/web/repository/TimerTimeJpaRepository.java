package com.web.repository;

import com.web.entity.TimerTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimerTimeJpaRepository extends JpaRepository<TimerTime,Long> {
}
