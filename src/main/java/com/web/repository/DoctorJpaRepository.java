package com.web.repository;

import com.web.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorJpaRepository extends JpaRepository<Doctor,Long> {
}
