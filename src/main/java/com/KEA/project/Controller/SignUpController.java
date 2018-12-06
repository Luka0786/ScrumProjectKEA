package com.KEA.project.Controller;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.SignUpModel;
import com.KEA.project.Model.StudentModel;
import com.KEA.project.Service.SignUp.SignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/course")
public class SignUpController {

    @Autowired
    SignUpServiceImpl signUpServiceImpl;

    @Autowired
    CourseController courseController;

    @Autowired
    StudentController studentController;

    @GetMapping("/signUp")
    public String signUpToCourse(@RequestParam("id") long id, Model model){

        model.addAttribute("Course",courseController.courseServiceImpl.findCourseById(id) );

        return "SignUp";

    }

    @PostMapping("/signUp")
    public String signUpToCourse(@ModelAttribute CourseModel courseModel){

       signUpServiceImpl.signUpToCourse(courseModel);

        return "redirect:/course";
    }

    @GetMapping("/signedUpCourses")
    public String signedUpCourses(Model model)
    {

        model.addAttribute("SignedUpCourses",signUpServiceImpl.getAllSignUps());
       // model.addAttribute("ApprovedSignUps", signUpServiceImpl.getAllApprovedSignUps());

        return "SignedUpCourses";
    }




}
