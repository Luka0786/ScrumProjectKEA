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

    @Column(name = "student_password")
    private String password;

    @Column(name = "student_enabled")
    private int enabled;

}
