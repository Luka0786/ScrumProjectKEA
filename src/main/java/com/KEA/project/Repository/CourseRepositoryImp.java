package com.KEA.project.Repository;

import com.KEA.project.Model.CourseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class CourseRepositoryImp implements CourseRepository {


    @Autowired
    private SessionFactory sessionFactory;

    public void saveOrUpdateCourse(Model Model)
    {
        Session currentSessions = sessionFactory.getCurrentSession();

        currentSessions.saveOrUpdate(Model);
    }

    @Override
    public List<CourseModel> findAll() {
        return null;
    }

    @Override
    public List<CourseModel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CourseModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CourseModel> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CourseModel courseModel) {

    }

    @Override
    public void deleteAll(Iterable<? extends CourseModel> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends CourseModel> S save(S s) {
        return null;
    }

    @Override
    public <S extends CourseModel> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<CourseModel> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends CourseModel> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<CourseModel> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CourseModel getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends CourseModel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CourseModel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CourseModel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CourseModel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CourseModel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CourseModel> boolean exists(Example<S> example) {
        return false;
    }
}
