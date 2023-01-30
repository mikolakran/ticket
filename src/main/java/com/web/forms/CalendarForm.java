package com.web.forms;

import com.web.entity.Calendar;
import com.web.entity.Doctor;
import com.web.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarForm implements Serializable {
    private long idDate;
    private LocalDate localDate;
    private int time8_30;
    private int time9_00;
    private int time9_30;
    private int time10_00;
    private int time10_30;
    private int time11_00;
    private int time11_30;
    private int time13_00;
    private int time13_30;
    private int time14_00;
    private int time14_30;
    private int time15_00;
    private int time15_30;
    private int time16_00;
    private int time16_30;

    private String nameTime;
    private DoctorForm doctor;
    private Set<PassportForm> passports;
    public CalendarForm(Calendar calendar) {
        this.idDate = calendar.getIdDate();
        this.localDate = calendar.getLocalDate();
        this.time8_30 = calendar.getTime8_30();
        this.time9_00 = calendar.getTime9_00();
        this.time9_30 = calendar.getTime9_30();
        this.time10_00 = calendar.getTime10_00();
        this.time10_30 = calendar.getTime10_30();
        this.time11_00 = calendar.getTime11_00();
        this.time11_30 = calendar.getTime11_30();
        this.time13_00 = calendar.getTime13_00();
        this.time13_30 = calendar.getTime13_30();
        this.time14_00 = calendar.getTime14_00();
        this.time14_30 = calendar.getTime14_30();
        this.time15_00 = calendar.getTime15_00();
        this.time15_30 = calendar.getTime15_30();
        this.time16_00 = calendar.getTime16_00();
        this.time16_30 = calendar.getTime16_30();
        Doctor doctor = calendar.getDoctor();
        User user = doctor.getUser();
        this.doctor = new DoctorForm(doctor.getIdDoctor(),doctor.getCabinetNumber(),
                doctor.getSpecialityDoctor(),user);
    }

    @Override
    public String toString() {
        return "CalendarTicketForm{" +
                "idDate=" + idDate +
                ", localDate=" + localDate +
                ", time8_30=" + time8_30 +
                ", time9_00=" + time9_00 +
                ", time9_30=" + time9_30 +
                ", time10_00=" + time10_00 +
                ", time10_30=" + time10_30 +
                ", time11_00=" + time11_00 +
                ", time11_30=" + time11_30 +
                ", time13_00=" + time13_00 +
                ", time13_30=" + time13_30 +
                ", time14_00=" + time14_00 +
                ", time14_30=" + time14_30 +
                ", time15_00=" + time15_00 +
                ", time15_30=" + time15_30 +
                ", time16_00=" + time16_00 +
                ", time16_30=" + time16_30 +
                ", nameTime='" + nameTime + '\'' +
                '}';
    }
}
