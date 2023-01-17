package com.web.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long id; //
    @Column(name = "name", unique = true, nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "role", nullable = false)
    private String role;
    @Lob
    @Column(name = "image",length = Integer.MAX_VALUE)
    private byte[] image;

    @OneToOne()
    @JoinColumn(name = "idPassport")
    private Passport passport;

    @ManyToMany(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    @JoinTable(name = "position_doctors",
    joinColumns = @JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name = "positionDoctorId"))
    private Set<PositionDoctor> positionDoctors;
    @OneToOne
    @JoinColumn(name = "idDoctor")
    private Doctor doctor;


    public User(String userName, String password, String email, String role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
