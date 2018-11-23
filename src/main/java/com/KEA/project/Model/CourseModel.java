package com.KEA.project.Model;


import javax.persistence.*;

@Entity
@Table(name = "Course_table")
public class CourseModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long id;

    @Column(name = "name_danish")
    private String nameDanish;

    @Column(name = "semester")
    private int semester;

    @Column(name = "class_code")
    private String classCode;

    @Column(name = "study_programme")
    private String studyProgramme;

    @Column(name = "type")
    private boolean type;

    @Column(name = "ects")
    private int ects;

    @Column(name = "language")
    private String language;

    @Column(name = "minimum_of_students")
    private int minimumOfStudents;

    @Column(name = "expected_of_students")
    private int expectedOfStudents;

    @Column(name = "maximum_of_students")
    private int maximumOfStudents;

    @Column(name = "prerequisites")
    private String prerequisites;

    @Column(name = "leaning_outcome")
    private String learingOutcome;

    @Column(name = "content")
    private String content;

    @Column(name = "learning_activities")
    private String learningActivities;

    @Column(name = "exam_form")
    private String examForm;

    @Column(name = "teacher_model")
    private TeacherModel[] teachers;
}

