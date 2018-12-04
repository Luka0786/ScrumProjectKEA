package com.KEA.project.Service.SignUp;

import com.KEA.project.Model.SignUpModel;
import com.KEA.project.Repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    SignUpRepository signUpRepository;

    @Override
    public Optional<SignUpModel> getAllSignUpsByIdOrderByTimestamp(long id) {
        return signUpRepository.findAllByIdOrderByTimestamp(id);
    }

    @Override
    public void CreateSignUp(SignUpModel signUpModel) {
        signUpRepository.save(signUpModel);
    }


}
