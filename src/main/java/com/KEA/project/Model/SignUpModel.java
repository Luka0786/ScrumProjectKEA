package com.KEA.project.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Sign_Up_Table")
public class SignUpModel {
    @Id
    @Column(name = "sign_up_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Timestamp", nullable = false, updatable = false)
    @CreationTimestamp
    public Date timestamp;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private CourseModel courseModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",referencedColumnName = "student_id")
    private StudentModel studentModel;




    public SignUpModel(CourseModel courseModel, StudentModel studentModel) {
        this.courseModel = courseModel;
        this.studentModel = studentModel;
    }

    public SignUpModel(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public CourseModel getCourseModel() {
        return courseModel;
    }

    public void setCourseModel(CourseModel courseModel) {
        this.courseModel = courseModel;
    }

    public StudentModel getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }
}
