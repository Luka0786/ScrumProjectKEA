package com.KEA.project.Service.Course;

public class CourseServiceImpl implements CourseService
{

    @Override
    public void create() {
        save()
    }

    @Override
    public void delete(long id) {
        deleteById(id);
    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }
}
