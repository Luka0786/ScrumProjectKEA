package com.KEA.project.Service.Login;

import com.KEA.project.Model.LoginModel;
import com.KEA.project.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginRepository loginRepository;

    @Override
    public void createLogin(LoginModel loginModel) {
        loginRepository.save(loginModel);
    }
}
