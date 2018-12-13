package com.KEA.project.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
@Table(name = "Teacher_Table")
public class TeacherModel implements Serializable
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

    private ArrayList<CourseModel> courses;

    @Column(name = "course_map")
    @OneToMany(mappedBy = "course_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public ArrayList<CourseModel> getCourses()
    {
        return courses;
    }

    public TeacherModel(String name, @Email String email) {
        this.name = name;
        this.email = email;
        this.username = email;
    }

    public TeacherModel(){

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

    @Override
    public String toString() {
        return "TeacherModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
