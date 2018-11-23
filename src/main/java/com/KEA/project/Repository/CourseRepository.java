package com.KEA.project.Repository;

import com.KEA.project.Model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseModel, Long>
{
}
