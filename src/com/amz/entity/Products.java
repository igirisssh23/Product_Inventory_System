package com.amz.entity;

public class Products {
	
	 private int pid;
	 private String name;
	 private int price;
	 private int quantity;
	 private String category;
	 
	 
	 
	 @Override
	 public String toString() {
		return "Products [pid=" + pid + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", category="
				+ category + "]";
	 }



	 public Products() {
		super();
		// TODO Auto-generated constructor stub
	 }



	 public Products(int pid, String name, int price, int quantity, String category) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	 }



	 public int getPid() {
		 return pid;
	 }



	 public void setPid(int pid) {
		 this.pid = pid;
	 }



	 public String getName() {
		 return name;
	 }



	 public void setName(String name) {
		 this.name = name;
	 }



	 public int getPrice() {
		 return price;
	 }



	 public void setPrice(int price) {
		 this.price = price;
	 }



	 public int getQuantity() {
		 return quantity;
	 }



	 public void setQuantity(int quantity) {
		 this.quantity = quantity;
	 }



	 public String getCategory() {
		 return category;
	 }



	 public void setCategory(String category) {
		 this.category = category;
	 }
	 
	 
	 
	
	
	

}
