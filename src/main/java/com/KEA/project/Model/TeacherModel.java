package com.KEA.project.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "Teacher_Table")
public class TeacherModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private long id;

    @Column(name = "teacher_name")
    private String name;

    @Email
    @Column(name = "teacher_email")
    private String email;

    @Column(name = "teacher_username", unique = true)
    private String username;

    public TeacherModel(String name, @Email String email) {
        this.name = name;
        this.email = email;
        this.username = email;
    }
}
