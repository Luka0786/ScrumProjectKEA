package com.KEA.project.Controller;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.StudentModel;
import com.KEA.project.Service.Course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Controller
@RequestMapping("/course")
public class CourseController
{

    @Autowired
    CourseServiceImpl courseServiceImpl;

    @GetMapping()
    public String getAllCourses(Model model)
    {
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
        courseModel.setStudents2(new ArrayList<>());
        courseServiceImpl.createCourse(courseModel);



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

        return "redirect:/course";
    }


    @GetMapping("/details")
    public String courseDetailsById(@RequestParam("id") long id, Model model)
    {
        model.addAttribute("Course", courseServiceImpl.findSpecificCourse(id));

        System.out.println(courseServiceImpl.findSpecificCourse(id).getStudents2().get(0).getName());

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

    @GetMapping("/search")
    public String searchCourses(@RequestParam(defaultValue = "") String searchForCourse, Model model){

        model.addAttribute("courses", courseServiceImpl.getAllCourses());   //"venues" er nøglen i HTML!!
        model.addAttribute("searchCourse",courseServiceImpl.searchCourses(searchForCourse));   //"svenues" er nøglen i HTML!!

        return "Course";
    }
}