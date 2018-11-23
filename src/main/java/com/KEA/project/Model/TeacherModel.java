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
}
