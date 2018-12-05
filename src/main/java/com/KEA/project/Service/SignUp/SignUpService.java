package com.KEA.project.Service.SignUp;

import com.KEA.project.Model.SignUpModel;

import java.util.List;
import java.util.Optional;

public interface SignUpService {

    List<SignUpModel> getAllSignUpsByCourseIdOrderByTimestamp(long id);

    void CreateSignUp(SignUpModel signUpModel);

    SignUpModel findSpecificSignUp(long id);

    Optional<SignUpModel> findSignUpById(long id);

}
