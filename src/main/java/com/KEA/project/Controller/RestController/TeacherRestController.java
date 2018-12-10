package com.KEA.project.Controller.RestController;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.TeacherModel;
import com.KEA.project.Service.Course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class TeacherRestController {

    /*final String courseUrl = "http://18.185.40.91/teacher";

    @Autowired
    CourseServiceImpl courseServiceImpl;


    public ArrayList<TeacherModel> fetchAllTeachers() {
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<ArrayList<TeacherModel>> courseResponse =
                restTemplate.exchange(courseUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<TeacherModel>>() {
                        });

        ArrayList<TeacherModel> teachers = courseResponse.getBody();

        int year = Calendar.getInstance().get(Calendar.YEAR);

         for (TeacherModel teacher :teachers) {

            TeacherModel temporaryCourse = courseServiceImpl.findSpecificCourse(course.getId());


            if(temporaryCourse.getStudents().isEmpty()){

                course.setStudents(new ArrayList<>());
            }else{
                course.setStudents(temporaryCourse.getStudents());
            }


        }

        return courses;
    }*/



}
