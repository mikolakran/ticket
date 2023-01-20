package com.web.dao;

import com.web.entity.Doctor;
import com.web.entity.PositionDoctor;
import com.web.entity.User;

import java.util.List;
import java.util.Set;

public interface PositionDoctorDAO extends DAO<PositionDoctor,Long>{
    List<PositionDoctor> findAll();

    PositionDoctor findByPosition(String name);

/*    Set<User> getListUser(long id);*/
    Set<Doctor> getListDoctor(long id);
}
