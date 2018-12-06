package com.KEA.project.Controller;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.SignUpModel;
import com.KEA.project.Model.StudentModel;
import com.KEA.project.Service.Administrator.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    SignUpController signUpController;

    @Autowired
    CourseController courseController;

    @Autowired
    AdministratorServiceImpl administratorServiceImpl;

    @GetMapping("/signUpsList")
    public String getAllSignUpsFromSpecificCourse(@RequestParam("id") long id, Model model)
    {
        model.addAttribute("signUpList", signUpController.signUpServiceImpl.getAllSignUpsByCourseIdOrderByTimestamp(id));


        return "SignUpsList";
    }

  /*  @GetMapping("/signUpRequest")
    public String courseDetailsById(@RequestParam("id") long id, Model model)
    {
        model.addAttribute("Course", courseController.courseServiceImpl.findSpecificCourse(id));

        return "CourseDetails";
    }*/


    @GetMapping("/signUpAnswer")
    public String acceptOrDeclineSignUp(@RequestParam("id") long id, Model model)
    {
        model.addAttribute("signUp",signUpController.signUpServiceImpl.findSpecificSignUp(id));

        SignUpModel signUpModel = signUpController.signUpServiceImpl.findSpecificSignUp(id);

        System.out.println(signUpModel.getStudentModel());

        return "SignUpAnswer";
    }

    @PostMapping("/signUpAnswer")
    public String acceptOrDeclineSignUp(@ModelAttribute SignUpModel signUpModel,
                                        @RequestParam(required=false, value="accept") String accept,
                                        @RequestParam(required=false, value="decline") String decline)
    {


        if (accept!=null)
        {
            System.out.println(signUpController.signUpServiceImpl.findSpecificSignUp(signUpModel.getId()).getStudentModel());

            SignUpModel CurrentSignUpModel = signUpController.signUpServiceImpl.findSpecificSignUp(signUpModel.getId());



            StudentModel requestedStudent = CurrentSignUpModel.getStudentModel();

            System.out.println(requestedStudent);


            ArrayList<StudentModel> Students = CurrentSignUpModel.getCourseModel().getStudents();
            System.out.println(Students+ "DRJAKJLSEHJLAKSJEJSKLE");

            Students.add(requestedStudent);


            System.out.println(Students);
            CourseModel courseModel = CurrentSignUpModel.getCourseModel();
            courseModel.setStudents2(Students);

            courseController.updateCourse(courseModel);

            //signUpController.signUpServiceImpl.deleteSignUpModel(signUpModel);
        }
        else if (decline!=null)
        {
            signUpController.signUpServiceImpl.deleteSignUpModel(signUpModel);
        }

        return "redirect:/course";
    }

}
