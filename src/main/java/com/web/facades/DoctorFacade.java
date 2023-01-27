package com.web.facades;

import com.web.dao.DoctorDAO;
import com.web.entity.CalendarTicket;
import com.web.entity.Doctor;
import com.web.forms.CalendarTicketForm;
import com.web.forms.DoctorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DoctorFacade {

    @Autowired
    private DoctorDAO doctorDAO;

    public DoctorForm save(DoctorForm doctorForm) {
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

    public Set<CalendarTicketForm> getCalendar(long idDoctor){
        Set<CalendarTicketForm> calendarTicketForms = new HashSet<>();
        Set<CalendarTicket> listCalendar = doctorDAO.getCalendar(idDoctor);
        listCalendar.forEach(calendarTicket -> {
            CalendarTicketForm calendarTicketForm = new CalendarTicketForm(calendarTicket);
            calendarTicketForms.add(calendarTicketForm);
        });
        return calendarTicketForms;
    }

    private void buildUser(Doctor doctor, DoctorForm doctorForm) {
        doctor.setIdDoctor(doctorForm.getIdDoctor());
        doctor.setCabinetNumber(doctorForm.getCabinetNumber());
        doctor.setSpecialityDoctor(doctorForm.getSpecialityDoctor());
        doctor.setUser(doctorForm.getUser());
        Set<CalendarTicket> calendars = new HashSet<>();
        Set<CalendarTicketForm> calendarTickets = doctorForm.getCalendarTickets();
        if (calendarTickets!=null){
            calendarTickets.forEach(calendarTicketForm -> {
                CalendarTicket calendarTicket = new CalendarTicket(calendarTicketForm.getIdDate(),calendarTicketForm.getLocalDate()
                        ,calendarTicketForm.getTime8_30(),calendarTicketForm.getTime9_00(),calendarTicketForm.getTime9_30(),
                        calendarTicketForm.getTime10_00(),calendarTicketForm.getTime10_30(),calendarTicketForm.getTime11_00(),
                        calendarTicketForm.getTime11_30(),calendarTicketForm.getTime13_00(),calendarTicketForm.getTime13_30(),
                        calendarTicketForm.getTime14_00(),calendarTicketForm.getTime14_30(),calendarTicketForm.getTime15_00(),
                        calendarTicketForm.getTime15_30(),calendarTicketForm.getTime16_00(),calendarTicketForm.getTime16_30(),
                        calendarTicketForm.getDoctor());
                calendars.add(calendarTicket);
            });
            doctor.setCalendarTickets(calendars);
        }
    }
}
