package com.web.dao.impl;

import com.web.dao.DoctorDAO;
import com.web.entity.Doctor;
import com.web.repository.DoctorJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class DoctorDAOImpl implements DoctorDAO {

    @Autowired
    private DoctorJpaRepository doctorJpaRepository;
    @Override
    public Doctor save(Doctor doctor) {
        return doctorJpaRepository.save(doctor);
    }

    @Override
    public Doctor get(Long aLong) {
        return null;
    }

    @Override
    public void update(Doctor doctor) {

    }

    @Override
    public void delete(Long aLong) {

    }
}
