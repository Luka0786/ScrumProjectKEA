package com.KEA.project.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table (name = "Administrator_Table")
public class AdministratorModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "administrator_id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;
}
