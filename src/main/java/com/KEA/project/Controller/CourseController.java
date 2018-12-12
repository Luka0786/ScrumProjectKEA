package com.KEA.project.Controller;

import com.KEA.project.Controller.RestController.CourseRestController;
import com.KEA.project.Controller.RestController.TeacherRestController;
import com.KEA.project.Model.CourseModel;
import com.KEA.project.Service.Course.CourseServiceImpl;
import com.KEA.project.Service.Teacher.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
@RequestMapping("/course")
public class CourseController
{

    @Autowired
    CourseServiceImpl courseServiceImpl;

    @Autowired
    CourseRestController courseRestController;

    @Autowired
    TeacherRestController teacherRestController;

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @GetMapping()
    public String getAllCourses(Model model)
    {
        teacherServiceImpl.createAllTeachers(teacherRestController.fetchAllTeachers());

        courseServiceImpl.createAllCourses(courseRestController.fetchAllCourses());

        model.addAttribute("Courses", courseServiceImpl.getAllCourses());

        return "Course";
    }

    @GetMapping("/create")
    public String createCourse(Model model)
    {
        model.addAttribute("Course", new CourseModel());

        return "CourseCreate";
    }

    @PostMapping("/create")
    public String createCourse(@ModelAttribute CourseModel courseModel)
    {
        courseModel.setStudents(new ArrayList<>());
        courseServiceImpl.createCourse(courseModel);
        courseRestController.reflectCourse(courseModel);

        return "redirect:/course";
    }

    @GetMapping("/update")
    public String updateCourse(@RequestParam("id") long id, Model model)
    {
        model.addAttribute("Course", courseServiceImpl.findCourseById(id));

        return "CourseUpdate";
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute CourseModel courseModel)
    {
        courseServiceImpl.updateCourse(courseModel);
        courseRestController.reflectCourse(courseModel);

        return "redirect:/course";
    }


    @GetMapping("/details")
    public String courseDetailsById(@RequestParam("id") long id, Model model)
    {
        model.addAttribute("Course", courseServiceImpl.findSpecificCourse(id));

        return "CourseDetails";
    }


    @GetMapping("/delete")
    public String deleteCourseById(@RequestParam("id") long id, Model model)
    {

        model.addAttribute("Course", courseServiceImpl.findCourseById(id));
        return "CourseDelete";

    }

    @PostMapping("/delete")
    public String deleteCourseById(@ModelAttribute CourseModel courseModel)
    {
        courseServiceImpl.deleteCourse(courseModel);
        return "redirect:/course";
    }
}