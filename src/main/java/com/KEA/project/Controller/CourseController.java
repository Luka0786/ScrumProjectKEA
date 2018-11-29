package com.KEA.project.Controller;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Repository.CourseRepositoryImp;
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
}
