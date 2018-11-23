package com.KEA.project.Model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Course_table")
public class CourseModel
{
    private long id;
    private String name;
    private String studyProgramme;
    private String nameDanish;
    private String description;
    private String language;
    private String nameEnglish;
    private String classCode;
    private int semester;
    private int ECTS;
    private int numberOfTeachers;
    private boolean mandatory;

}

