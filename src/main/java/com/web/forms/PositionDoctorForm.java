package com.web.forms;

import com.web.entity.PositionDoctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDoctorForm implements Serializable {
    private int positionDoctorId;
    private String position;
    private LocalTime beginningWork;
    private LocalTime beginningBreak;
    private LocalTime endBreak;
    private LocalTime endWork;
    private Set<DoctorForm> doctors;



    public PositionDoctorForm(PositionDoctor positionDoctor) {
        this.positionDoctorId = positionDoctor.getPositionDoctorId();
        this.position = positionDoctor.getPosition();
        this.beginningWork = positionDoctor.getBeginningWork();
        this.beginningBreak = positionDoctor.getBeginningBreak();
        this.endBreak = positionDoctor.getEndBreak();
        this.endWork = positionDoctor.getEndWork();
    }

    @Override
    public String toString() {
        return "PositionDoctorForm{" +
                "positionDoctorId=" + positionDoctorId +
                ", position='" + position + '\'' +
                ", beginningWork=" + beginningWork +
                ", beginningBreak=" + beginningBreak +
                ", endBreak=" + endBreak +
                ", endWork=" + endWork +
                '}';
    }
}
