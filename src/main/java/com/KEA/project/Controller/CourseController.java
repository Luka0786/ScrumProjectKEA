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
    CourseServiceImpl courseServiceImpl;

    @GetMapping()
    public String courses(Model model)
    {
        model.addAttribute("Courses", courseServiceImpl.getAll());

        return "Course";
    }

    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("Course", new CourseModel());

        return "CourseCreate";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute CourseModel courseModel)
    {
        courseServiceImpl.create(courseModel);

        return "redirect:/course";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") long id, Model model)
    {
        model.addAttribute("Course", courseServiceImpl.findById(id));

        return "CourseUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute CourseModel courseModel)
    {
        courseServiceImpl.update(courseModel);

        return "redirect:/course";
    }

    @GetMapping("/details")
    public String detailsById(@RequestParam("id") long id, Model model)
    {
        model.addAttribute("Course", courseServiceImpl.findSpecificModel(id));

        return "CourseDetails";
    }


    @GetMapping("/delete")
    public String deleteCourseById(@RequestParam("id") long id, Model model)
    {

        model.addAttribute("Course", courseServiceImpl.findById(id));
        return "CourseDelete";

    }

    @PostMapping("/delete")
    public String deleteCourseById(@ModelAttribute CourseModel courseModel)
    {
        courseServiceImpl.delete(courseModel);
        return "redirect:/course";
    }

}