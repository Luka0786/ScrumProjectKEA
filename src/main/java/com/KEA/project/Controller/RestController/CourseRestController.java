package com.KEA.project.Controller.RestController;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Service.RestService.CourseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class CourseRestController {

    final String courseUrl = "http://18.185.40.91/course";

    @Autowired
    CourseRestService courseRestService;


    public LinkedList<CourseModel> fetchAllCourses()
    {
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<LinkedList<CourseModel>> courseResponse =
                restTemplate.exchange(courseUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<LinkedList<CourseModel>>()
                        {
                        });
        return courseRestService.fetchAllCourses(courseResponse);
    }

    public ResponseEntity<CourseModel> reflectCourse (@RequestBody CourseModel courseModel)
    {

        /*HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        */

        HttpEntity<CourseModel> entity = new HttpEntity<>(courseModel);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CourseModel> response = restTemplate.postForEntity(courseUrl, courseModel, CourseModel.class, entity);

        return courseRestService.reflectCreatedCourse(response);
    }
}
