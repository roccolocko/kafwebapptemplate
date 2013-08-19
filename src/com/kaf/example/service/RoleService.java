package com.kaf.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kaf.example.bean.Role;
import com.kaf.example.bean.User;
import com.kaf.example.dao.RoleDao;
import com.kaf.example.dao.UserDao;

public class RoleService {
	
	@Autowired
	RoleDao roleDao;

	public Long save(User user) throws Exception{
		return roleDao.save(user);
	}
	
	public Role getById(Long id){
		return (Role)roleDao.getById(id);
	}

	public RoleDao getDaoHelper() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}


}
