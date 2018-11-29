package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;

import java.util.List;
import java.util.Optional;

public interface CourseService
{
    void create(CourseModel courseModel);
    void deleteCourse(CourseModel courseModel);
    void read();
    void update(CourseModel courseModel);
    Optional<CourseModel> findById(long id);
    List<CourseModel> getAll();
}
