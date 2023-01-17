package com.web.forms;

import com.web.entity.Passport;
import com.web.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassportForm {

    private long idPassport;
    private String family;
    private String name;
    private String patronymic;
    private String contactNumber;
    private LocalDate dateBirth;
    private String gender;
    private String address;
    private User user;

    public PassportForm(Passport passport){
        this.idPassport = passport.getIdPassport();
        this.family = passport.getFamily();
        this. name = passport.getName();
        this.patronymic = passport.getPatronymic();
        this.contactNumber = passport.getContactNumber();
        this.dateBirth = passport.getDateBirth();
        this.gender = passport.getGender();
        this.address = passport.getAddress();
        this.user = passport.getUser();
    }

    @Override
    public String toString() {
        return "PassportForm{" +
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
}
