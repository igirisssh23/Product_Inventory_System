package com.amz.service;

import java.util.List;

import com.amz.dao.ProductDao;
import com.amz.entity.Products;

public class ProductService {
	private ProductDao dao = null;
	private List<Products> productsdb = null;

	public List<Products> getAllProducts() {

		dao = new ProductDao();

		productsdb = dao.getAllProducts();

		return productsdb;

	}

	public Products getProductsById(int id) {

		dao = new ProductDao();
		productsdb = dao.getAllProducts();

		return productsdb.stream().filter(product -> product.getPid() == id).findFirst().orElse(null);
	}

	public String insertProduct(Products p1) {
		dao = new ProductDao();
		dao.insertProducts(p1);

		return"added successfuully";
	}

	public String updateproducts(Products p1) {
		
		dao=new ProductDao();
		dao.updateproducts(p1);
		
		
		return "updated successfully";
	}

	public Products getExpensiveProduct() {
		dao=new ProductDao();
		dao.getexpensiveproduct();
		
		return dao.getexpensiveproduct();
	}
	
	
	public int getTotalInventoryValue() {

	    dao = new ProductDao();

	    return dao.getTotalInventoryValue();
	}

}
