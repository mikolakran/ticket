package com.web.forms;

import com.web.entity.Doctor;
import com.web.entity.PositionDoctor;
import com.web.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorForm implements Serializable {
    private long idDoctor;
    private int cabinetNumber;
    private String specialityDoctor;
    private Set<PositionDoctor> positionDoctors;
    private User user;

    public DoctorForm(long idDoctor, int cabinetNumber, String specialityDoctor, User user) {
        this.idDoctor = idDoctor;
        this.cabinetNumber = cabinetNumber;
        this.specialityDoctor = specialityDoctor;
        this.user = user;
    }

    public DoctorForm(Doctor doctor) {
        this.idDoctor = doctor.getIdDoctor();
        this.cabinetNumber = doctor.getCabinetNumber();
        this.specialityDoctor = doctor.getSpecialityDoctor();
        this.user = doctor.getUser();
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
