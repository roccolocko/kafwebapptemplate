package com.kaf.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kaf.example.bean.Product;
import com.kaf.example.dao.ProductDao;

public class ProductService {
	
	@Autowired
	ProductDao productDao;

	public Long save(Product product) throws Exception{
		return productDao.save(product);
	}
	
	public Product getById(Long id){
		return (Product)productDao.getById(id);
	}

	public Boolean update(Product product){
		return productDao.update(product);
	}
	
	public Boolean deleteById(Long id){
		return productDao.delete(id);
	}
	
	public List<Object> getAll(){
		List<Object> listProduct = productDao.getAll();
		return listProduct;
	}
	
	public ProductDao getDaoHelper() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


}
