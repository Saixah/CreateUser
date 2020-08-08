package com.example.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.UserDao;
import com.example.model.User;

@RestController
public class HomeController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("home")
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	//Creates user, and checks if one exists already
	@RequestMapping("createUser")
	public void createUser(User user) {
		try{
			if(userDao.exists(User.class,"username",user.getUsername())==false)
			{
				userDao.saveUser(user);	
			}else {
				System.out.println("Username is taken");
			}
			//general exception
		}catch(Exception e) {
			System.out.println("Broke it");
		}
	}
	
	@RequestMapping("display")
	@ResponseBody
	public List<User> getUsers(User user) {
		return userDao.findAllUser();
	}
	
	
	
	@RequestMapping("deleteUser")
	public void deleteUser(User user) {
	
		userDao.delete(user);		

	}
	
}
