package com.KEA.project.Controller;

import com.KEA.project.Controller.RestController.TeacherRestController;
import com.KEA.project.Service.Course.CourseServiceImpl;
import com.KEA.project.Service.RestService.TeacherRestService;
import com.KEA.project.Service.Teacher.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {



        return "login";
    }

    @GetMapping("/loginError")
    public String loginError()
    {
        return "LoginError";
    }

    

}
