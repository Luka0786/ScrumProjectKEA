package com.KEA.project.Repository;

import com.KEA.project.Model.StudentModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentModel, Long>
{

    StudentModel findByUsername(String username);

}
