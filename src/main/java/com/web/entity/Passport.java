package com.web.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data()
@NoArgsConstructor
@Entity
@Table(name = "passport")
public class Passport implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_passport")
        private long idPassport;
    @Column(name = "family", nullable = false)
    private String family;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "patronymic", nullable = false)
    private String patronymic;
    @Column(name = "contactNumber")
    private String contactNumber;
    @Column(name = "dateBirth", nullable = false)
    private LocalDate dateBirth;
    @Column(nullable = false)
    private String gender;
    @Column(name = "address", nullable = false)
    private String address;

    @OneToOne(mappedBy = "passport")
    private User user;

    public Passport(String family, String name, String patronymic, LocalDate dateBirth, String address) {
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
        this.dateBirth = dateBirth;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "idPassport=" + idPassport +
                ", family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", dateBirth=" + dateBirth +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        return idPassport == passport.idPassport;
    }

    @Override
    public int hashCode() {
        return (int) (idPassport ^ (idPassport >>> 32));
    }
}
