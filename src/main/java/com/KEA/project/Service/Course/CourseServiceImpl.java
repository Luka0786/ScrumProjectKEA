package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService
{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void deleteCourse(CourseModel courseModel)
    {
        courseRepository.delete(courseModel);
    }

    @Override
    public Optional<CourseModel> findById(long id)
    {
        return courseRepository.findById(id);
    }
}
