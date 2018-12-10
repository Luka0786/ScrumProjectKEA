package com.KEA.project.Service.RestService;

import com.KEA.project.Model.LoginModel;
import com.KEA.project.Model.TeacherModel;
import com.KEA.project.Service.Login.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class TeacherRestService {

    @Autowired
    LoginServiceImpl loginServiceImpl;

    public LinkedList<TeacherModel> fetchAllTeachers(ResponseEntity<LinkedList<TeacherModel>> teacherResponse) {
        LinkedList<TeacherModel> teachers = teacherResponse.getBody();


        for (TeacherModel teacher : teachers) {
            teacher.setUsername(teacher.getEmail()+teacher.getId());

            String temporaryPassword = teacher.getName() + teacher.getId();


            LoginModel loginModel = new LoginModel(teacher.getUsername()+teacher.getId(),BCrypt.hashpw(temporaryPassword,BCrypt.gensalt()));
            loginServiceImpl.createLogin(loginModel);
        }

        return teachers;

    }


}
