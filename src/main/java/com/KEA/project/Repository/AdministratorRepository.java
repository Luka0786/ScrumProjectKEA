package com.KEA.project.Repository;

import com.KEA.project.Model.AdministratorModel;
import com.KEA.project.Model.SignUpModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<AdministratorModel, Long>
{


}
