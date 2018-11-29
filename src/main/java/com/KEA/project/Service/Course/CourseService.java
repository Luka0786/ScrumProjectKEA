package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Repository.CourseRepository;
import org.springframework.ui.Model;

public interface CourseService
{
    void create(Model Model);
    void delete(long id);
    void read();
    void update();
}
