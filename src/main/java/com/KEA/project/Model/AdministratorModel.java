package com.KEA.project.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashMap;

@Entity
@Table(name = "Administrator_Table")
public class AdministratorModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "administrator_id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "students_map")
    private HashMap<Long,StudentModel> studentsMap;

    public AdministratorModel(String firstName, String lastName, String name, @Email String email,HashMap<Long,StudentModel> studentsMap) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = firstName + " " + lastName;
        this.email = email;
        this.studentsMap = studentsMap;
    }
}
