package com.KEA.project.Controller.RestController;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Service.Course.CourseServiceImpl;
import com.KEA.project.Service.RestService.CourseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class CourseRestController {

    final String courseUrl = "http://18.185.40.91/course";

    @Autowired
    CourseRestService courseRestService;


    public LinkedList<CourseModel> fetchAllCourses() {
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<LinkedList<CourseModel>> courseResponse =
                restTemplate.exchange(courseUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<LinkedList<CourseModel>>() {
                        });



        return courseRestService.fetchAllCourses(courseResponse);
    }



}
