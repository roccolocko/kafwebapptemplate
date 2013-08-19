package com.kaf.example.dao;

import com.kaf.hibernate.dao.DaoHelper;

public class UserDao extends DaoHelper {

	
	public UserDao() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		super("com.kaf.example.bean.User");
	}
	

}
