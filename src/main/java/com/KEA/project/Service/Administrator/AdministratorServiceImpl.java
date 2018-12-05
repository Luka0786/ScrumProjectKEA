package com.KEA.project.Service.Administrator;

import com.KEA.project.Repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl {


    @Autowired
    AdministratorRepository administratorRepository;


    public void findAll(){
        administratorRepository.findAll();

    }
}
