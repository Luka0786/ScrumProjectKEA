package com.KEA.project.Service.Course;


import com.KEA.project.Model.CourseModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CourseService
{
    void deleteCourse(CourseModel courseModel);

    Optional<CourseModel> findById(long id);



}
