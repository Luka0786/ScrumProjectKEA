package com.KEA.project.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name = "Student_Table")
public class StudentModel implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;

    @Column(name = "student_name")
    private String name;

    @Email
    @Column(name = "student_email")
    private String email;

    @Column(name = "student_username")
    private String username;

    @Column(name = "student_enabled")
    private int enabled;



    public StudentModel(String name, @Email String email, String username, int enabled)
    {
        this.name = name;
        this.email = email;
        this.username = username;
        this.enabled = enabled;
    }

    public StudentModel()
    {

    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getEnabled()
    {
        return enabled;
    }

    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
    }

}
