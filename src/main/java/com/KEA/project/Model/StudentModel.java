package com.KEA.project.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "Student_Table")
public class StudentModel
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

    /*
    @Column(name = "student_password")
    private String password;*/

    @Column(name = "student_enabled")
    private int enabled;

/*
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "administrator_id",nullable = true,insertable = false,updatable = false)
    private CounselorModel administrator;*/

/*
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "counselor_id",nullable = false)
    private CounselorModel counselor;*/

    public StudentModel(String name, @Email String email, String username, int enabled)
    {
        this.name = name;
        this.email = email;
        this.username = username;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    /*public CounselorModel getCounselor() {
        return counselor;
    }

    public void setCounselor(CounselorModel counselor) {
        this.counselor = counselor;
    }*/
}
