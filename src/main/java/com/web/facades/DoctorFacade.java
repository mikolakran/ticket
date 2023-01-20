package com.web.facades;

import com.web.dao.DoctorDAO;
import com.web.entity.Doctor;
import com.web.forms.DoctorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DoctorFacade {

    @Autowired
    private DoctorDAO doctorDAO;

    public Set<DoctorForm> getListByIdUserDoctors(long idPosition, long idUser) {
        return null;
    }


    private void buildUser(Doctor doctor, DoctorForm doctorForm) {
        doctor.setIdDoctor(doctorForm.getIdDoctor());
        doctor.setCabinetNumber(doctorForm.getCabinetNumber());
        doctor.setSpecialityDoctor(doctorForm.getSpecialityDoctor());
        doctor.setUser(doctorForm.getUser());
    }
}
