package com.KEA.project.Controller;

import com.KEA.project.Model.SignUpModel;
import com.KEA.project.Service.Administrator.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/course/admin")
public class AdministratorController {


    @Autowired
    AdministratorServiceImpl administratorServiceImpl;



    @GetMapping("/signUpsList")
    public String getAllSignUpsFromSpecificCourse(@RequestParam("id") long id, Model model)
    {
        model.addAttribute("signUpList", administratorServiceImpl.getAllSignUpsByCourseIdOrderByTimestamp(id));


        return "SignUpsList";
    }

    @GetMapping("/signUpAnswer")
    public String acceptOrDeclineSignUp(@RequestParam("id") long id, Model model)
    {
        model.addAttribute("signUp",administratorServiceImpl.findSpecificSignUp(id));

        SignUpModel signUpModel = administratorServiceImpl.findSpecificSignUp(id);

        return "SignUpAnswer";

    }

    @PostMapping("/signUpAnswer")
    public String acceptOrDeclineSignUp(@ModelAttribute SignUpModel signUpModel,
                                        @RequestParam(required=false, value="accept") String accept,
                                        @RequestParam(required=false, value="decline") String decline)
    {
        if (accept!=null)
        {
            administratorServiceImpl.acceptSignUp(signUpModel);
        }
        else if (decline!=null)
        {
            administratorServiceImpl.declineSignUp(signUpModel);
        }

        return "redirect:/lort";
    }



}
