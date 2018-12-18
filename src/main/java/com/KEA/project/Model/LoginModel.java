package com.KEA.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Login_table")
public class LoginModel implements Serializable
{

    @Id
    @Column(name = "login_username")
    private String username;

    @Column(name = "login_password")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    public LoginModel(String username, String password, int enabled)
    {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public LoginModel()
    {

    }
}
