package com.amz.service;

import java.util.List;

import com.amz.dao.DAO;
import com.amz.entity.Products;

public class ProductService {
	private DAO dao = null;
	private List<Products> productsdb = null;

	public List<Products> getAllProducts() {

		dao = new DAO();

		productsdb = dao.getAllProducts();

		return productsdb;

	}

	public Products getProductsById(int id) {

		dao = new DAO();
		productsdb = dao.getAllProducts();

		return productsdb.stream().filter(product -> product.getPid() == id).findFirst().orElse(null);
	}

	public String insertProduct(Products p1) {
		dao = new DAO();
		dao.insertProducts(p1);

		return"added successfuully";
	}

	public String updateproducts(Products p1) {
		
		dao=new DAO();
		dao.updateproducts(p1);
		
		
		return "updated successfully";
	}

	public Products getExpensiveProduct() {
		dao=new DAO();
		dao.getexpensiveproduct();
		
		return dao.getexpensiveproduct();
	}
	
	
	public int getTotalInventoryValue() {

	    dao = new DAO();

	    return dao.getTotalInventoryValue();
	}

}
