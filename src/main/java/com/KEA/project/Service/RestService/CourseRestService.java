package com.KEA.project.Service.RestService;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Service.Course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

@Service
public class CourseRestService {

    @Autowired
    CourseServiceImpl courseServiceImpl;

public LinkedList<CourseModel> fetchAllCourses(ResponseEntity<LinkedList<CourseModel>> courseResponse) {
    LinkedList<CourseModel> courses = courseResponse.getBody();

    int year = Calendar.getInstance().get(Calendar.YEAR);

    for (CourseModel course : courses) {


        course.setClassCode(course.getName() + "_" + course.getId() + "_" + year);

        try {
            if (!courseServiceImpl.findByClassCode(course.getClassCode()).getClassCode().isEmpty()) {


                course.setMinimumOfStudents(courseServiceImpl.findByClassCode(course.getClassCode()).getMinimumOfStudents());
                course.setExpectedOfStudents(courseServiceImpl.findByClassCode(course.getClassCode()).getExpectedOfStudents());
                course.setMaximumOfStudents(courseServiceImpl.findByClassCode(course.getClassCode()).getMaximumOfStudents());
                course.setPrerequisites(courseServiceImpl.findByClassCode(course.getClassCode()).getPrerequisites());
                course.setContent(courseServiceImpl.findByClassCode(course.getClassCode()).getContent());
                course.setLearningActivities(courseServiceImpl.findByClassCode(course.getClassCode()).getLearningActivities());
                course.setExamForm(courseServiceImpl.findByClassCode(course.getClassCode()).getExamForm());
                course.setStudents(courseServiceImpl.findByClassCode(course.getClassCode()).getStudents());

            }


        }catch (NullPointerException NPE){


            course.setMinimumOfStudents(15);
            course.setExpectedOfStudents(35);
            course.setMaximumOfStudents(50);
            course.setPrerequisites("English, must have a computer capable of running Intellij IDEA");
            course.setContent("Java, Intellij IDEA");
            course.setLearningActivities("Live Coding, Group Projects, Individual Projects");
            course.setExamForm("Oral Exam");
            course.setStudents(new ArrayList<>());
        }




    }
    return courses;

}
}