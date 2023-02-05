package com.web.forms;

import com.web.entity.Doctor;
import com.web.entity.PositionDoctor;
import com.web.entity.TimerTime;
import com.web.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorForm implements Serializable {
    private long idDoctor;
    private int cabinetNumber;
    private String specialityDoctor;
    private Set<PositionDoctorForm> positionDoctors;
    private UserForm user;
    private Set<CalendarForm> calendarTickets;
    private Set<TimerTimeForm> timerTimes;

    public DoctorForm(Doctor doctor) {
        this.idDoctor = doctor.getIdDoctor();
        this.cabinetNumber = doctor.getCabinetNumber();
        this.specialityDoctor = doctor.getSpecialityDoctor();
    }

    public DoctorForm(long idDoctor, int cabinetNumber, String specialityDoctor, User user) {
        this.idDoctor = idDoctor;
        this.cabinetNumber = cabinetNumber;
        this.specialityDoctor = specialityDoctor;
        this.user = new UserForm(user);
    }

    @Override
    public String toString() {
        return "DoctorForm{" +
                "idDoctor=" + idDoctor +
                ", cabinetNumber=" + cabinetNumber +
                ", specialityDoctor='" + specialityDoctor + '\'' +
                '}';
    }
}
