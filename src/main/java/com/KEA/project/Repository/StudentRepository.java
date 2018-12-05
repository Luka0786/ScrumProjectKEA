package com.KEA.project.Repository;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentModel, Long>
{

}
