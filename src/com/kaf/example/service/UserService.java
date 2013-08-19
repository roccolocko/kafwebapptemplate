package com.kaf.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kaf.example.bean.Role;
import com.kaf.example.bean.User;
import com.kaf.example.dao.UserDao;

public class UserService {
	
	@Autowired
	UserDao userDao;

	public Long save(User user) throws Exception{
		return userDao.save(user);
	}
	
	public User getById(Long id){
		return (User)userDao.getById(id);
	}

	public void update(User user){
		userDao.update(user);
	}
	
	public List<Object> getAll(){
		List<Object> listUser = userDao.getAll();
		return listUser;
	}
	
	public UserDao getDaoHelper() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


}
