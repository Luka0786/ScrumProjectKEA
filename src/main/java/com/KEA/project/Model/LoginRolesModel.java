package com.KEA.project.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Login_roles")
public class LoginRolesModel implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_username")
    private LoginModel username;

    @Column(name = "login_roles_role")
    private String role;

    public LoginRolesModel(LoginModel username, String role)
    {
        this.username = username;
        this.role = role;
    }

    public LoginRolesModel()
    {
    }

    public LoginModel getUsername()
    {
        return username;
    }

    public void setUsername(LoginModel username)
    {
        this.username = username;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}