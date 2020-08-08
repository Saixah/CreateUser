package com.example.interfaces;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.model.User;

public interface UserRepo{
	
	void saveUser(User user);
    
    List<User> findAllUser();
     
    User findById(int id);
     
    void updateLogin(User user);

	void deleteUser(User user);
	
//	void deleteById(Class<?> type, Serializable id);
}
