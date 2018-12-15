package com.KEA.project.Repository;

import com.KEA.project.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Long>
{

    StudentModel findByUsername(String username);

}
