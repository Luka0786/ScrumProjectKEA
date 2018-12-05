package com.KEA.project.Service.Student;

import com.KEA.project.Model.SignUpModel;
import com.KEA.project.Model.StudentModel;

import java.util.List;
import java.util.Optional;

public interface StudentService
{
    StudentModel findStudentByUsername(String username);

}
