package com.KEA.project.Repository;

import com.KEA.project.Model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginModel, Long>
{

}
