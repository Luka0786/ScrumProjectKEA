package com.KEA.project.Repository;

import com.KEA.project.Model.SignUpModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignUpRepository extends JpaRepository<SignUpModel,Long> {

    Optional<SignUpModel> findAllByIdOrderByTimestamp(Long aLong);

}
