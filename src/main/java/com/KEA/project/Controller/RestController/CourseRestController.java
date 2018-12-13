package com.KEA.project.Controller.RestController;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Service.Course.CourseServiceImpl;
import com.KEA.project.Service.RestService.CourseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/course")
public class CourseRestController {

    final String courseUrl = "http://18.185.40.91/course";

    @Autowired
    CourseRestService courseRestService;

    @Autowired
    CourseServiceImpl courseServiceImpl;

    @GetMapping("/admin/fetchCourses")
    public void fetchAllCourses(HttpServletResponse response)
    {
        courseServiceImpl.createAllCourses(courseRestService.fetchAllCourses());

        try {
            response.sendRedirect("/course");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
