package com.KEA.project.Controller.RestController;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.TeacherModel;
import com.KEA.project.Service.Course.CourseServiceImpl;
import com.KEA.project.Service.RestService.TeacherRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class TeacherRestController {

    final String courseUrl = "http://18.185.40.91/teacher";

    @Autowired
    TeacherRestService teacherRestService;


    public LinkedList<TeacherModel> fetchAllTeachers() {
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<LinkedList<TeacherModel>> teacherResponse =
                restTemplate.exchange(courseUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<LinkedList<TeacherModel>>() {
                        });



        return teacherRestService.fetchAllTeachers(teacherResponse);
    }



}
