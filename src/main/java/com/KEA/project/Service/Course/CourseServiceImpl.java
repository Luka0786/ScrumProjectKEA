package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    CourseRepository courseRepository;

    @Override
    public void create(CourseModel courseModel)
    {
        courseRepository.save(courseModel);
    }

    @Override
    public void deleteCourse(CourseModel courseModel)
    {
        courseRepository.delete(courseModel);
    }

    @Override
    public void read()
    {

    }

    @Override
    public void update(CourseModel courseModel)
    {
        courseRepository.save(courseModel);
    }

    @Override
    public Optional<CourseModel> findById(long id)
    {
        return courseRepository.findById(id);
    }

    @Override
    public List<CourseModel> getAll() {
        return courseRepository.findAll();
    }
}

