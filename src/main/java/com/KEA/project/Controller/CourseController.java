package com.KEA.project.Controller;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Repository.CourseRepositoryImp;
import com.KEA.project.Service.Course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController
{

    @Autowired
    CourseServiceImpl courseServiceImpl;

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


        return "redirect:/create";
    }




}
