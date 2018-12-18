package com.KEA.project.Service.SignUp;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.SignUpModel;
import com.KEA.project.Model.StudentModel;
import com.KEA.project.Repository.SignUpRepository;
import com.KEA.project.Service.Course.CourseServiceImpl;
import com.KEA.project.Service.Student.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
    public List<SignUpModel> getAllSignUpsByCourseIdOrderByTimestamp(long id)
    {
        return signUpRepository.findAllByCourseModel_IdOrderByTimestamp(id);
    }

    @Override
    public void createSignUp(SignUpModel signUpModel)
    {
        signUpRepository.save(signUpModel);
    }

    @Override
    public SignUpModel findSpecificSignUp(long id)
    {
        return signUpRepository.getOne(id);
    }

    @Override
    public List<SignUpModel> getAllSignUps()
    {
        return signUpRepository.findAll();
    }

    @Override
    public void deleteSignUpModel(SignUpModel signUpModel)
    {
        signUpRepository.delete(signUpModel);
    }

    @Override
    public void signUpToCourse(CourseModel courseModel)
    {
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
        {
            username = ((UserDetails) principal).getUsername();
        } else
        {
            username = principal.toString();
        }

        StudentModel student = studentServiceImpl.findStudentByUsername(username);

        SignUpModel signUp = new SignUpModel(courseModel, student);

        createSignUp(signUp);
    }

    @Override
    @Transactional
    public void deleteAllSignUpModelsByCourseModel(CourseModel courseModel)
    {
        signUpRepository.deleteAllByCourseModel(courseModel);
    }

    public List<CourseModel> getAllApprovedSignUps()
    {

        List<CourseModel> courses = courseServiceImpl.getAllCourses();

        List<CourseModel> approved = new ArrayList<>();

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
        {
            username = ((UserDetails) principal).getUsername();
        } else
        {
            username = principal.toString();
        }
        //Uden try catch vil der forekomme nullpointer crash
        for (int i = 0; i < courses.size(); i++)
        {

            List<StudentModel> students = courses.get(i).getStudentss();
            try
            {
                for (int j = 0; j < students.size(); j++)
                {
                    if (students.get(j).getUsername().equals(username))
                    {
                        approved.add(courses.get(i));
                    }
                }
            } catch (NullPointerException NPE)
            {

            }

        }

        return approved;
    }
}
