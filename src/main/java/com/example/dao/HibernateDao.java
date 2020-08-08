package com.example.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HibernateDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public void persist(Object entity) {
        getSession().save(entity);
    }
 
    public void delete(Object entity) {
        getSession().delete(entity);
    }
    
//    public void deleteById(Class<?> type, Serializable id) {
//    	getSession().delete(getSession().load(type, id));
//    }
    
}