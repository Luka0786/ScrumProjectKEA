package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Repository.CourseRepository;
import org.springframework.ui.Model;

public interface CourseService
{
    void create(CourseModel courseModel);
    void delete(long id);
    void read();
    void update();
}
