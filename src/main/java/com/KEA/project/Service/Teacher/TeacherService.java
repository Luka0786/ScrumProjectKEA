package com.KEA.project.Service.Teacher;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.TeacherModel;

import java.util.LinkedList;
import java.util.List;

public interface TeacherService
{
    List<TeacherModel> createAllTeachers(List<TeacherModel> teachers);

    void teacherConnectToCourse(CourseModel courseModel);

}
