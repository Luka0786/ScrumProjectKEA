package com.KEA.project.Service.SignUp;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.SignUpModel;
import com.KEA.project.Model.StudentModel;
import com.KEA.project.Repository.CourseRepository;
import com.KEA.project.Repository.SignUpRepository;
import com.KEA.project.Service.Course.CourseServiceImpl;
import com.KEA.project.Service.Student.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SignUpServiceImpl implements SignUpService
{

    @Autowired
    SignUpRepository signUpRepository;

    @Autowired
    CourseServiceImpl courseServiceImpl;

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @Override
    public List<SignUpModel> getAllSignUpsByCourseIdOrderByTimestamp(long id) {
        return signUpRepository.findAllByCourseModel_IdOrderByTimestamp(id);
    }

    @Override
    public void CreateSignUp(SignUpModel signUpModel) {
        signUpRepository.save(signUpModel);
    }



    @Override
    public SignUpModel findSpecificSignUp(long id) {
        return signUpRepository.getOne(id);
    }

    @Override
    public List<SignUpModel> getAllSignUps() {
        return signUpRepository.findAll();
    }

    @Override
    public void deleteSignUpModel(SignUpModel signUpModel)
    {
        signUpRepository.delete(signUpModel);
    }

    @Override
    public void signUpToCourse(CourseModel courseModel) {
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        StudentModel student = studentServiceImpl.findStudentByUsername(username);

        SignUpModel signUp = new SignUpModel(courseModel,student);

        CreateSignUp(signUp);
    }

   /* public List<CourseModel> getAllApprovedSignUps() {
        List<CourseModel> courses = courseServiceImpl.getAllCourses();
        List<CourseModel> approved = new ArrayList<>();

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        for (int i = 1; i < courses.size(); i++) {
            List<StudentModel> students = courseServiceImpl.findSpecificCourse(i).getStudents2();
            for (int j = 1; j < students.size(); j++) {
                if (students.get(j).getUsername().equals(username))   {
                    System.out.println("Inde i j fori loop");
                    approved.add(courses.get(j));
                }
            }
        }
        System.out.println(approved.toString());
        return approved;
    }*/
}
