package com.KEA.project.Service.Student;

import com.KEA.project.Model.StudentModel;
import com.KEA.project.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService
{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentModel findStudentByUsername(String username)
    {
        return studentRepository.findByUsername(username);
    }

}
