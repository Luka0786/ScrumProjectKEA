package com.KEA.project.Model;

import javax.persistence.*;

@Entity
@Table(name = "Login_table")
public class LoginModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private long id;

    @Column(name = "login_username")
    private String username;


    @Column(name = "login_password")
    private String password;

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
