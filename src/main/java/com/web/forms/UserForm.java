package com.web.forms;

import com.web.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import com.web.entity.Passport;
import com.web.entity.User;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm implements Serializable {
    private long id;
    private String userName;
    private String password;
    private String newPassword;
    private String passwordEmail;
    private String confirmPassword;
    private String email;
    private String role;
    private MultipartFile multipartFile;
    private byte[] photo;
    private Passport passport;
    private Doctor doctor;
    private PositionDoctorForm positionDoctor;
    private long idDate;
    private String ticketTime;
    private String error;

    public UserForm(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.photo = user.getImage();
        this.passport = user.getPassport();
        this.doctor = user.getDoctor();
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
