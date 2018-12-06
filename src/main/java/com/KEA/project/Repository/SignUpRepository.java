package com.KEA.project.Repository;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.SignUpModel;
import com.KEA.project.Model.StudentModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SignUpRepository extends JpaRepository<SignUpModel,Long> {

     List<SignUpModel> findAllByCourseModel_IdOrderByTimestamp(Long id);


    @Override
    SignUpModel getOne(Long aLong);


}
