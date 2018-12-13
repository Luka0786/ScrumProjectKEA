package com.KEA.project.Model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Course_table")
public class CourseModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "name_danish")
    private String namedanish;

    @Column(name = "name_english")
    private String name;

    @Nullable
    @Column(name = "number_of_teachers")
    private int numberOfTeachers;

    @Column(name = "semester")
    private int semester;

    @Column(name = "class_code")
    private String classCode;

    @Column(name = "study_programme")
    private String studyprogramme;

    @Column(name = "type")
    private boolean type;

    @Column(name = "ects")
    private String ects;

    @Column(name = "languange")
    private String languange;

    @Column(name = "minimum_of_students")
    private int minimumOfStudents;

    @Column(name = "expected_of_students")
    private int expectedOfStudents;

    @Column(name = "maximum_of_students")
    private int maximumOfStudents;

    @Column(name = "prerequisites")
    private String prerequisites;

    @Column(name = "learning_outcome")
    private String description;

    @Column(name = "content")
    private String content;

    @Column(name = "learning_activities")
    private String learningActivities;

    @Column(name = "exam_form")
    private String examForm;

    private ArrayList<StudentModel> students;

    @Column(name = "students_map")
    @OneToMany(mappedBy = "student_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public ArrayList<StudentModel> getStudents()
    {
        return students;
    }

    private ArrayList<TeacherModel> teachers;

    @Column(name = "teachers_map")
    @OneToMany(mappedBy = "teacher_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public ArrayList<TeacherModel> getTeachers()
    {
        return teachers;
    }

    public CourseModel()
    {

    }

    public CourseModel(String namedanish, String name, int semester, String classCode, String studyprogramme, boolean type, String ects, String languange, int minimumOfStudents, int expectedOfStudents, int maximumOfStudents, String prerequisites, String description, String content, String learningActivities, String examForm, ArrayList<StudentModel> students, int numberOfTeachers) {
        this.namedanish = namedanish;
        this.name = name;
        this.semester = semester;
        this.classCode = classCode;
        this.studyprogramme = studyprogramme;
        this.type = type;
        this.ects = ects;
        this.languange = languange;
        this.minimumOfStudents = minimumOfStudents;
        this.expectedOfStudents = expectedOfStudents;
        this.maximumOfStudents = maximumOfStudents;
        this.prerequisites = prerequisites;
        this.description = description;
        this.content = content;
        this.learningActivities = learningActivities;
        this.examForm = examForm;
        this.students = students;
        this.numberOfTeachers = numberOfTeachers;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamedanish() {
        return namedanish;
    }

    public void setNamedanish(String namedanish) {
        this.namedanish = namedanish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getStudyprogramme() {
        return studyprogramme;
    }

    public void setStudyprogramme(String studyprogramme) {
        this.studyprogramme = studyprogramme;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getEcts() {
        return ects;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }

    public String getLanguange() {
        return languange;
    }

    public void setLanguange(String languange) {
        this.languange = languange;
    }

    public int getMinimumOfStudents() {
        return minimumOfStudents;
    }

    public void setMinimumOfStudents(int minimumOfStudents) {
        this.minimumOfStudents = minimumOfStudents;
    }

    public int getExpectedOfStudents() {
        return expectedOfStudents;
    }

    public void setExpectedOfStudents(int expectedOfStudents) {
        this.expectedOfStudents = expectedOfStudents;
    }

    public int getMaximumOfStudents() {
        return maximumOfStudents;
    }

    public void setMaximumOfStudents(int maximumOfStudents) {
        this.maximumOfStudents = maximumOfStudents;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLearningActivities() {
        return learningActivities;
    }

    public void setLearningActivities(String learningActivities) {
        this.learningActivities = learningActivities;
    }

    public String getExamForm() {
        return examForm;
    }

    public void setExamForm(String examForm) {
        this.examForm = examForm;
    }

    public ArrayList<StudentModel> getStudentss()
    {
        return students;
    }

    public int getNumberOfTeachers() {
        return numberOfTeachers;
    }

    public void setNumberOfTeachers(int numberOfTeachers) {
        this.numberOfTeachers = numberOfTeachers;
    }
/*
    public void setStudents(HashMap<Long, StudentModel> students) {
        this.students = students;
    }

    public void setTeachers(HashMap<Long, TeacherModel> teachers) {
        this.teachers = teachers;
    }*/



    public void setStudents(ArrayList<StudentModel> students) {
        this.students = students;
    }

   /* @Override
    public String toString() {
        return "Name danish: " + namedanish + " Name english: " + name + "ECTS: " + ects + " Language: " + languange;

    }*/

    public void setTeachers(ArrayList<TeacherModel> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "id=" + id +
                ", namedanish='" + namedanish + '\'' +
                ", name='" + name + '\'' +
                ", numberOfTeachers=" + numberOfTeachers +
                ", semester=" + semester +
                ", classCode='" + classCode + '\'' +
                ", studyprogramme='" + studyprogramme + '\'' +
                ", type=" + type +
                ", ects='" + ects + '\'' +
                ", languange='" + languange + '\'' +
                ", minimumOfStudents=" + minimumOfStudents +
                ", expectedOfStudents=" + expectedOfStudents +
                ", maximumOfStudents=" + maximumOfStudents +
                ", prerequisites='" + prerequisites + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", learningActivities='" + learningActivities + '\'' +
                ", examForm='" + examForm + '\'' +
                ", students=" + students +
                '}';
    }
}

