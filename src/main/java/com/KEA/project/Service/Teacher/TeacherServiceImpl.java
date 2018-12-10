package com.KEA.project.Service.Teacher;

import com.KEA.project.Model.TeacherModel;
import com.KEA.project.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;


    @Override
    public List<TeacherModel> createAllTeachers(List<TeacherModel> teachers) {
        return teacherRepository.saveAll(teachers);
    }
}
