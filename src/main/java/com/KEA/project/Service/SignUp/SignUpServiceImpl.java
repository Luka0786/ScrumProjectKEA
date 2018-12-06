package com.KEA.project.Service.SignUp;

import com.KEA.project.Model.SignUpModel;
import com.KEA.project.Repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignUpServiceImpl implements SignUpService
{

    @Autowired
    SignUpRepository signUpRepository;


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

}
