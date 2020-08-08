package com.example.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.UserDao;
import com.example.interfaces.UserRepo;
import com.example.model.User;


@Service("userService")
@Transactional
public class UserService  implements UserRepo{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public void updateLogin(User user) {
		userDao.updateLogin(user);
		
	}

//	@Override
//	public void deleteById(Class<?> type, Serializable id) {
//		userDao.deleteById(User.class,id);
//		
//	}

}
