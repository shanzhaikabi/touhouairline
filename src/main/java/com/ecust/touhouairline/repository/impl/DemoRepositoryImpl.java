package com.ecust.touhouairline.repository.impl;

import com.ecust.touhouairline.entity.DemoEntity;
import com.ecust.touhouairline.repository.DemoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DemoRepositoryImpl implements DemoRepository {

    @Autowired
    private SessionFactory sessionFactory;//需要正确配置hibernate

    public Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public void demo(DemoEntity demo) {
        //Do something
    }

    @Override
    public DemoEntity load(Integer id) {
        return getCurrentSession().load(DemoEntity.class,id);
    }

    @Override
    public DemoEntity get(Integer id) {
        return getCurrentSession().get(DemoEntity.class,id);
    }

    @Override
    public List<DemoEntity> getAll() {
        return null;
    }

    @Override
    public void persist(DemoEntity entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Integer save(DemoEntity entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(DemoEntity entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(DemoEntity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }
}
