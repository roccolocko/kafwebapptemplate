package com.kaf.example.dao;

import com.kaf.hibernate.dao.DaoHelper;

public class ProductDao extends DaoHelper {

	
	public ProductDao() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		super("com.kaf.example.bean.Product");
	}
	

}
