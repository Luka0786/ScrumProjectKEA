package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Repository.CourseRepository;
import com.KEA.project.Service.SignUp.SignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SignUpServiceImpl signUpServiceImpl;

    @Override
    public void createCourse(CourseModel courseModel)
    {
        courseRepository.save(courseModel);
    }

    @Override
    public void deleteCourse(CourseModel courseModel)
    {

        signUpServiceImpl.deleteAllSignUpModelsByCourseModel(courseModel);
        courseRepository.delete(courseModel);
    }


    @Override
    public void updateCourse(CourseModel courseModel)
    {
        courseRepository.save(courseModel);
    }

    @Override
    public Optional<CourseModel> findCourseById(long id)
    {
        return courseRepository.findById(id);
    }

    @Override
    public CourseModel findByClassCode(String classCode) {
        return courseRepository.findByClassCode(classCode);
    }

    @Override
    public CourseModel findSpecificCourse(long id)
    {
        return courseRepository.getOne(id);
    }

    @Override
    public List<CourseModel> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<CourseModel> createAllCourses(LinkedList<CourseModel> courseModels) {
        return courseRepository.saveAll(courseModels);
    }


}

