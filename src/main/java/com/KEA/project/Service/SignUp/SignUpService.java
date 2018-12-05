package com.KEA.project.Service.SignUp;

import com.KEA.project.Model.SignUpModel;

import java.util.Optional;

public interface SignUpService {

    Optional<SignUpModel> getAllSignUpsByIdOrderByTimestamp(long id);

    void CreateSignUp(SignUpModel signUpModel);


}
