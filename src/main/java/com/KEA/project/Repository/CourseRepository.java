package com.KEA.project.Repository;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.StudentModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseModel, Long>
{
   List<CourseModel> findAllByNameDanishContainsOrderByEctsDesc(String nameDanish);
}
