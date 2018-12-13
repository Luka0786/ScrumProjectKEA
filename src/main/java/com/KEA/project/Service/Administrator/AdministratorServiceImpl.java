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
public class AdministratorServiceImpl implements AdministratorService
{

    @Autowired
    SignUpServiceImpl signUpServiceImpl;

    @Autowired
    CourseServiceImpl courseServiceImpl;

    public void acceptSignUp (SignUpModel signUpModel)
    {
        SignUpModel CurrentSignUpModel = signUpServiceImpl.findSpecificSignUp(signUpModel.getId());
        StudentModel requestedStudent = CurrentSignUpModel.getStudentModel();

        ArrayList<StudentModel> Students = CurrentSignUpModel.getCourseModel().getStudents();

        Students.add(requestedStudent);

        CourseModel courseModel = CurrentSignUpModel.getCourseModel();

        courseModel.setStudents(Students);

        courseServiceImpl.updateCourse(courseModel);

        signUpServiceImpl.deleteSignUpModel(signUpModel);
    }

    public void declineSignUp(SignUpModel signUpModel)
    {
        signUpServiceImpl.deleteSignUpModel(signUpModel);
    }

    public List<SignUpModel> getAllSignUpsByCourseIdOrderByTimestamp (long id)
    {
        return signUpServiceImpl.getAllSignUpsByCourseIdOrderByTimestamp(id);
    }

    public SignUpModel findSpecificSignUp(long id)
    {
        return signUpServiceImpl.findSpecificSignUp(id);
    }
}
