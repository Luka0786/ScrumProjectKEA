package com.KEA.project.Repository;

import com.KEA.project.Model.CourseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

public interface CourseRepository extends JpaRepository<CourseModel, Long>
{


}
