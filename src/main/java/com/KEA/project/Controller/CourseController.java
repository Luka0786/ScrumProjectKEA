package com.KEA.project.Controller;


import com.KEA.project.Model.CourseModel;
import com.KEA.project.Service.Course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/course")
public class CourseController
{

    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @GetMapping("/{id}")
    public String SpecificCourseById(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("Course", courseServiceImpl.findById(id));
        return "Course";
    }

    @GetMapping("/delete")
    public String deleteCourseById(@RequestParam("id") long id, Model model)
    {

        model.addAttribute("Course", courseServiceImpl.findById(id));
        return "CourseDelete";

    }

    @PostMapping("/delete")
    public String deleteCourse(@ModelAttribute CourseModel courseModel)
    {
        courseServiceImpl.deleteCourse(courseModel);
        return "redirect:/course";
    }
}