package com.KEA.project.Repository;

import com.KEA.project.Model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherModel, Long>
{
}
