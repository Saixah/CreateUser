package com.example.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.interfaces.UserRepo;
import com.example.model.User;

@Repository("userDao")
public class UserDao extends HibernateDao implements UserRepo, Serializable{

	@Override
	public void saveUser(User user) {
		persist(user);
	}

	@Override
	public List<User> findAllUser() {
		Criteria criteria = getSession().createCriteria(User.class);
		for(Object user : criteria.list()) {
			System.out.println(user);
		}
		return (List<User>) criteria.list();
	}

//	@Override
//	@Transactional
//	public void deleteById(Class<?> type, Serializable id) {
////		Query query = getSession().createSQLQuery("DELETE User FROM User WHERE id = :id");
////		query.setLong("id", id);
////		query.executeUpdate();
//
//		deleteById(User.class,id);
//		
//	}

	@Override
	public User findById(int id) {
		Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id",id));
        return (User) criteria.uniqueResult();
	}


	
	public boolean exists(Class clazz, String idKey, Object idValue) {
	    return getSession().createCriteria(clazz)
	            .add(Restrictions.eq(idKey, idValue))
	            .setProjection(Projections.property(idKey))
	            .uniqueResult() != null;
	}

	@Override
	public void deleteUser(User user) {
		delete(user);
		
	}

	@Override
	public void updateLogin(User user) {
		// TODO Auto-generated method stub
		
	}


}
