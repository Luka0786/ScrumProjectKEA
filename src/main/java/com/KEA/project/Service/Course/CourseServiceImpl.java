package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    CourseRepository courseRepository;

    @Override
    public void create(CourseModel courseModel) {
        courseRepository.save(courseModel);

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

}
