package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CourseService
{
    void createCourse(CourseModel courseModel);
    void deleteCourse(CourseModel courseModel);
    void updateCourse(CourseModel courseModel);
    CourseModel findSpecificCourse(long id);
    Optional<CourseModel> findCourseById(long id);
    List<CourseModel> getAllCourses();
    List<CourseModel> createAllCourses(ArrayList<CourseModel> courseModels);
}
