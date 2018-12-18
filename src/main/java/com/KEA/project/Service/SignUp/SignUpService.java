package com.KEA.project.Service.SignUp;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.SignUpModel;

import java.util.List;

public interface SignUpService
{

    List<SignUpModel> getAllSignUpsByCourseIdOrderByTimestamp(long id);

    void createSignUp(SignUpModel signUpModel);

    SignUpModel findSpecificSignUp(long id);

    List<SignUpModel> getAllSignUps();

    void deleteSignUpModel(SignUpModel signUpModel);

    void signUpToCourse(CourseModel courseModel);

    void deleteAllSignUpModelsByCourseModel(CourseModel courseModel);

}
