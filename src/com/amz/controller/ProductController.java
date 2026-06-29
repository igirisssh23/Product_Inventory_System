package com.amz.controller;

import java.util.List;

import com.amz.entity.Products;
import com.amz.service.ProductService;

public class ProductController {

	public static void main(String[] args) {

		// Display Inventory
		ProductService productservice = new ProductService();
		List<Products> viewInventory = productservice.getAllProducts();
		viewInventory.forEach(p -> System.out.println("Id=" + p.getPid() + "\tName=" + p.getName() + "\tCategory="
				+ p.getCategory() + "\tMRP=" + p.getPrice() + "\tQuantity=" + p.getQuantity() + "\n"));

		// Search product by id

		// Products searchProductsById = productservice.getProductsById(101);
		// if (searchProductsById != null) {
		// System.out.println("Name = " + searchProductsById.getName() + "\tId = " +
		// searchProductsById.getPid()
		// + "\tPrice = " + searchProductsById.getPrice() + "\tQuantity = " +
		// searchProductsById.getQuantity()
		// + "\tCategory = " + searchProductsById.getCategory());
		// } else {
		// System.out.println("Product not found.");
		// }

		// Add product
		// Products p1 = new Products(114, "doll", 10, 40, "Girls");
		 //System.out.println(productservice.insertProduct(p1)); //return added
		// successfully

		// Update quantity
		//Products p1= new Products(114, "Barbie Doll", 5000000, 105, "Girls");
		 //System.out.println(productservice.updateproducts(p1)); //return updated
		// successfully

		// get expensive product
		 //Products product = productservice.getExpensiveProduct();
		 //if (product != null) {
		 //System.out.println("Most Expensive="+product.getName()+"\tPrice="+product.getPrice());
		 //} else {
		 //System.out.println("No products found.");
		// }
		
		//calculate total inventory value
		//int totalValue = productservice.getTotalInventoryValue();
		//System.out.println("Total Inventory Value = " + totalValue);
		
		
		
		
		 
		
		
		

	}
}
