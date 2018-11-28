package com.KEA.project.Service.Course;

import com.KEA.project.Repository.CourseRepository;

public interface CourseService extends CourseRepository
{
    void create();
    void delete(long id);
    void read();
    void update();
}
