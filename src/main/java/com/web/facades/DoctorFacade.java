package com.web.facades;

import com.web.dao.DoctorDAO;
import com.web.entity.Calendar;
import com.web.entity.Doctor;
import com.web.exception.MyException;
import com.web.forms.CalendarForm;
import com.web.forms.DoctorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DoctorFacade {

    @Autowired
    private DoctorDAO doctorDAO;

    public DoctorForm save(DoctorForm doctorForm) throws MyException {
        Doctor doctor = new Doctor();
        buildUser(doctor,doctorForm);
        Doctor resultSave = doctorDAO.save(doctor);
        return new DoctorForm(resultSave);
    }
    public DoctorForm get(Long idDoctor) {
        Doctor doctor = new Doctor();
        DoctorForm doctorForm = new DoctorForm();
        doctorForm.setIdDoctor(idDoctor);
        buildUser(doctor,doctorForm);
        Doctor resultDoctor = doctorDAO.get(doctor.getIdDoctor());
        return new DoctorForm(resultDoctor);
    }

    public Set<CalendarForm> getCalendar(long idDoctor){
        Set<CalendarForm> calendarForms = new HashSet<>();
        Set<Calendar> listCalendar = doctorDAO.getCalendar(idDoctor);
        listCalendar.forEach(calendarTicket -> {
            CalendarForm calendarForm = new CalendarForm(calendarTicket);
            calendarForms.add(calendarForm);
        });
        return calendarForms;
    }

    private void buildUser(Doctor doctor, DoctorForm doctorForm) {
        doctor.setIdDoctor(doctorForm.getIdDoctor());
        doctor.setCabinetNumber(doctorForm.getCabinetNumber());
        doctor.setSpecialityDoctor(doctorForm.getSpecialityDoctor());
    }
}
