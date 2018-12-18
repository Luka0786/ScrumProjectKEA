package com.KEA.project.Service.Administrator;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.SignUpModel;
import com.KEA.project.Model.StudentModel;
import com.KEA.project.Service.Course.CourseServiceImpl;
import com.KEA.project.Service.SignUp.SignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdministratorService
{

    @Autowired
    SignUpServiceImpl signUpServiceImpl;

    @Autowired
    CourseServiceImpl courseServiceImpl;

    public void acceptSignUp(SignUpModel signUpModel)
    {
        SignUpModel currentSignUpModel = signUpServiceImpl.findSpecificSignUp(signUpModel.getId());
        StudentModel requestedStudent = currentSignUpModel.getStudentModel();

        System.out.println(requestedStudent.getUsername() + "KEK");

        ArrayList<StudentModel> students = currentSignUpModel.getCourseModel().getStudents();


        students.add(requestedStudent);

        CourseModel courseModel = currentSignUpModel.getCourseModel();


        courseModel.setStudents(students);

        courseServiceImpl.updateCourse(courseModel);


        signUpServiceImpl.deleteSignUpModel(signUpModel);
    }

    public void declineSignUp(SignUpModel signUpModel)
    {
        signUpServiceImpl.deleteSignUpModel(signUpModel);
    }

    public List<SignUpModel> getAllSignUpsByCourseIdOrderByTimestamp(long id)
    {
        return signUpServiceImpl.getAllSignUpsByCourseIdOrderByTimestamp(id);
    }

    public SignUpModel findSpecificSignUp(long id)
    {
        return signUpServiceImpl.findSpecificSignUp(id);
    }
}
