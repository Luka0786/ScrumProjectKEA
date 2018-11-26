package com.KEA.project.Model;


import javax.persistence.*;
import java.util.HashMap;

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

    private HashMap<Long,StudentModel> students;


    @Column(name = "students_map")
    @OneToMany(mappedBy = "student_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public HashMap<Long,StudentModel> getStudents() {
        return students;
    }

    private HashMap<Long,TeacherModel> teachers;

    @Column(name = "teachers_map")
    @OneToMany(mappedBy = "teacher_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public HashMap<Long, TeacherModel> getTeachers()
    {
        return teachers;
    }

    public CourseModel(String nameDanish, int semester, String classCode, String studyProgramme, boolean type, int ects, String language, int minimumOfStudents, int expectedOfStudents, int maximumOfStudents, String prerequisites, String learingOutcome, String content, String learningActivities, String examForm, HashMap<Long, TeacherModel> teachers) {
        this.nameDanish = nameDanish;
        this.semester = semester;
        this.classCode = classCode;
        this.studyProgramme = studyProgramme;
        this.type = type;
        this.ects = ects;
        this.language = language;
        this.minimumOfStudents = minimumOfStudents;
        this.expectedOfStudents = expectedOfStudents;
        this.maximumOfStudents = maximumOfStudents;
        this.prerequisites = prerequisites;
        this.learingOutcome = learingOutcome;
        this.content = content;
        this.learningActivities = learningActivities;
        this.examForm = examForm;
        this.teachers = teachers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameDanish() {
        return nameDanish;
    }

    public void setNameDanish(String nameDanish) {
        this.nameDanish = nameDanish;
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

    public String getStudyProgramme() {
        return studyProgramme;
    }

    public void setStudyProgramme(String studyProgramme) {
        this.studyProgramme = studyProgramme;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getLearingOutcome() {
        return learingOutcome;
    }

    public void setLearingOutcome(String learingOutcome) {
        this.learingOutcome = learingOutcome;
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



    public void setTeachers(HashMap<Long, TeacherModel> teachers) {
        this.teachers = teachers;
    }
}

