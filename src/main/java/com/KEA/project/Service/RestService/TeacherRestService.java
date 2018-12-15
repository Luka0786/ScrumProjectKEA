package com.KEA.project.Service.RestService;

import com.KEA.project.Model.LoginModel;
import com.KEA.project.Model.LoginRolesModel;
import com.KEA.project.Model.TeacherModel;
import com.KEA.project.Service.Login.LoginServiceImpl;
import com.KEA.project.Service.LoginRoles.LoginRolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;

@Service
public class TeacherRestService {

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @Autowired
    LoginRolesServiceImpl loginRolesServiceImpl;

    final String courseUrl = "http://18.185.40.91/teacher";

    public LinkedList<TeacherModel> fetchAllTeachers() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<LinkedList<TeacherModel>> teacherResponse =
                restTemplate.exchange(courseUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<LinkedList<TeacherModel>>() {
                        });
        LinkedList<TeacherModel> teachers = teacherResponse.getBody();

        for (TeacherModel teacher : teachers) {
            teacher.setUsername(teacher.getEmail()+teacher.getId());

            String temporaryPassword = teacher.getName() + teacher.getId();

            LoginModel loginModel = new LoginModel(teacher.getUsername(),BCrypt.hashpw(temporaryPassword,BCrypt.gensalt()),1);
            loginServiceImpl.createLogin(loginModel);

            LoginRolesModel loginRolesModel = new LoginRolesModel(loginModel,"ROLE_TEACHER");
            loginRolesServiceImpl.createRoles(loginRolesModel);
        }


        return teachers;
    }
}
