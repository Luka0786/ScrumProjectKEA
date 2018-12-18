package com.KEA.project.Service.LoginRoles;

import com.KEA.project.Model.LoginRolesModel;
import com.KEA.project.Repository.LoginRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginRolesServiceImpl implements LoginRolesService
{

    @Autowired
    LoginRolesRepository loginRolesRepository;

    @Override
    public void createRoles(LoginRolesModel loginRolesModel)
    {
        loginRolesRepository.save(loginRolesModel);
    }
}
