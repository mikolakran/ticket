package com.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import com.web.entity.Doctor;
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
    private String confirmPassword;
    private String email;
    private String role;
    private MultipartFile multipartFile;
    private byte[] photo;
    private Passport passport;
    private Doctor doctor;
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

    public UserForm(long id, String userName, String password, String email, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
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
