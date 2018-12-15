package com.KEA.project.Controller;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Service.Teacher.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class TeacherController
{
    @Autowired
    TeacherServiceImpl teacherServiceImpl;
    @Autowired
    CourseController courseController;

    @GetMapping("/teacherConnectToCourse")
    public String teacherConnectToCourse(@RequestParam("id") long id, Model model){

        model.addAttribute("Course", courseController.courseServiceImpl.findCourseById(id));

        return "TeacherCourses";

    }

    @PostMapping("/teacherConnectToCourse")
    public String teacherConnectToCourse(@ModelAttribute CourseModel courseModel){

        teacherServiceImpl.teacherConnectToCourse(courseModel);

        return "redirect:/course";
    }



    @GetMapping("/myCourses")
    public String getAllConnectedFromSpecificCourse(Model model)
    {
        model.addAttribute("ConnectedCourses", teacherServiceImpl.getAllConnectedByCourseId());

        return "TeachersConnectCourses";
    }

}
