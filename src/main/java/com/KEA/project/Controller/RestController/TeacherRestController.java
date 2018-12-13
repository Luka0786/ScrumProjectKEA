package com.KEA.project.Controller.RestController;


import com.KEA.project.Service.RestService.TeacherRestService;
import com.KEA.project.Service.Teacher.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("/course")
public class TeacherRestController {



    @Autowired
    TeacherRestService teacherRestService;

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @GetMapping("/admin/fetchTeachers")
    public void fetchAllTeachers(HttpServletResponse response) {

        teacherServiceImpl.createAllTeachers(teacherRestService.fetchAllTeachers());

        try {
            response.sendRedirect("/course/admin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
