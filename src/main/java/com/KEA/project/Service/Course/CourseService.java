package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;

import java.util.List;
import java.util.Optional;

public interface CourseService
{
    void create(CourseModel courseModel);
    void delete(CourseModel courseModel);
    void update(CourseModel courseModel);
    CourseModel findSpecificModel(long id);
    Optional<CourseModel> findById(long id);
    List<CourseModel> getAll();
}
