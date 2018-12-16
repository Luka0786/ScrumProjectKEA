package com.KEA.project.Service.Teacher;

import com.KEA.project.Model.CourseModel;
import com.KEA.project.Model.TeacherModel;
import com.KEA.project.Repository.TeacherRepository;
import com.KEA.project.Service.Course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService
{

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseServiceImpl courseServiceImpl;

    @Override
    public List<TeacherModel> createAllTeachers(List<TeacherModel> teachers)
    {
        return teacherRepository.saveAll(teachers);
    }


    @Override
    public void teacherConnectToCourse(CourseModel courseModel)
    {
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        TeacherModel currentTeacher = teacherRepository.findByUsername(username);

        courseServiceImpl.findSpecificCourse(courseModel.getId()).getTeachers().add(currentTeacher);

        courseServiceImpl.updateCourse(courseServiceImpl.findSpecificCourse(courseModel.getId()));
    }


    public List<CourseModel> getAllConnectedByCourseId ()
    {
        List<CourseModel> courses = courseServiceImpl.getAllCourses();

        List<CourseModel> connected = new ArrayList<>();

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        for (int i = 0; i < courses.size(); i++) {

            List<TeacherModel> teachers = courses.get(i).getTeacherss();

            try{
                for (int j = 0; j < teachers.size(); j++) {
                    if (teachers.get(j).getUsername().equals(username))
                    {
                        connected.add(courses.get(i));
                    }
                }
            }catch (NullPointerException NPE)
            {

            }


        }

        return connected;

    }
}
