package com.KEA.project.Controller.RestController;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.StudentModel;
import com.KEA.project.Service.Course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class CourseRestController {

    final String courseUrl = "http://18.185.40.91/course";

    @Autowired
    CourseServiceImpl courseServiceImpl;


    public ArrayList<CourseModel> fetchAllCourses() {
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<ArrayList<CourseModel>> courseResponse =
                restTemplate.exchange(courseUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<CourseModel>>() {
                        });

        ArrayList<CourseModel> courses = courseResponse.getBody();

        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (CourseModel course :courses) {
            course.setClassCode(course.getName() + "_" + course.getId() + "_" + year);
            course.setMinimumOfStudents(15);
            course.setExpectedOfStudents(35);
            course.setMaximumOfStudents(50);
            course.setPrerequisites("English, must have a computer capable of running Intellij IDEA");
            course.setContent("Java, Intellij IDEA");
            course.setLearningActivities("Live Coding, Group Projects, Individual Projects");
            course.setExamForm("Oral Exam");

            CourseModel temporaryCourse = courseServiceImpl.findSpecificCourse(course.getId());


                if(temporaryCourse.getStudents().isEmpty()){

                    course.setStudents(new ArrayList<>());
                }else{
                    course.setStudents(temporaryCourse.getStudents());
                }


        }

        return courses;
    }



}
