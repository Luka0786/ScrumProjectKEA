package com.KEA.project.Controller;

import com.KEA.project.Service.Student.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController
{

    @Autowired
    StudentServiceImpl studentServiceImpl;

}