package com.KEA.project.Service.Course;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Repository.CourseRepository;
import com.KEA.project.Repository.CourseRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class CourseServiceImpl implements CourseService
{

    @Autowired
    CourseRepositoryImp courseRepositoryImp;



    @Override
    public void create(Model Model) {
        courseRepositoryImp.saveCourse(Model);
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
