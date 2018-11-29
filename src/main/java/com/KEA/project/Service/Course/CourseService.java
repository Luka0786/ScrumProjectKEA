package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;

import java.util.Optional;

public interface CourseService
{
    void create(CourseModel courseModel);
    void delete(long id);
    void read();
    void update(CourseModel courseModel);
    Optional<CourseModel> findById(long id);
}
