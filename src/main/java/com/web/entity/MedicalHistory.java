package com.web.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data()
@NoArgsConstructor
@Entity
@Table(name = "medicalHistory")
public class MedicalHistory  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedical")
    private long idMedical;
    @Column
    private LocalDate localDate;
    @Column
    private String underlyingDisease;
    @Column
    private String complications;
    @Column
    private String accompanyingIllnesses;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idPassport")
    private Passport passport;

    @Override
    public String toString() {
        return "MedicalHistory{" +
                "idMedical=" + idMedical +
                ", localDate=" + localDate +
                ", underlyingDisease='" + underlyingDisease + '\'' +
                ", complications='" + complications + '\'' +
                ", accompanyingIllnesses='" + accompanyingIllnesses + '\'' +
                '}';
    }
}
