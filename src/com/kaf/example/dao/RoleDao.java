package com.kaf.example.dao;


import com.kaf.hibernate.dao.DaoHelper;

public class RoleDao extends DaoHelper {

	public RoleDao() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		super("com.kaf.example.bean.Role");
	}
	
}
