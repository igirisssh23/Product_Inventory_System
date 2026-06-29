package com.amz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amz.entity.Products;

public class DAO {
	private List<Products> productsdb = null;
	private Connection con = null;
	private String path = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_amz_products?createDatabaseIfNotExist=true";
	private String user = "root";
	private String pass = "Girish@2301";
	private PreparedStatement pst = null;
	ResultSet rs = null;

	String query = "Select * from productslist";

	public List<Products> getAllProducts() {

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, user, pass);
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();

			productsdb = new ArrayList<Products>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int mrp = rs.getInt(3);
				int amount = rs.getInt(4);
				String type = rs.getString(5);

				Products obj = new Products(id, name, mrp, amount, type);
				productsdb.add(obj);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productsdb;
	}

	public void insertProducts(Products p1) {

		String insertQuery = "insert into productslist values(?,?,?,?,?)";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, user, pass);
			pst = con.prepareStatement(insertQuery);

			pst.setInt(1, p1.getPid());
			pst.setString(2, p1.getName());
			pst.setInt(3, p1.getPrice());
			pst.setInt(4, p1.getQuantity());
			pst.setString(5, p1.getCategory());

			pst.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int updateproducts(Products p1) {

		String updateQuery = "update productslist set name=?, price=?, quantity=?,category=? where pid=?";
		int rows = 0;

		try {
			Class.forName(path);

			con = DriverManager.getConnection(url, user, pass);

			pst = con.prepareStatement(updateQuery);

			pst.setString(1, p1.getName());
			pst.setInt(2, p1.getPrice());
			pst.setInt(3, p1.getQuantity());
			pst.setString(4, p1.getCategory());
			pst.setInt(5, p1.getPid());

			rows = pst.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	
	public Products getexpensiveproduct() {

		String query = "SELECT * FROM productslist ORDER BY price DESC LIMIT 1";
		Products product=null;

		try {
			Class.forName(path);

			con = DriverManager.getConnection(url, user, pass);

			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			 if (rs.next()) {

		            product = new Products();

		            product.setPid(rs.getInt("pid"));
		            product.setName(rs.getString("name"));
		            product.setPrice(rs.getInt("price"));
		            product.setQuantity(rs.getInt("quantity"));
		            product.setCategory(rs.getString("category"));
		        }

		        rs.close();
		        pst.close();
		        con.close();


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	
	public int getTotalInventoryValue() {

	    String query = "SELECT SUM(price * quantity) AS total_inventory_value FROM productslist";

	    int totalValue = 0;

	    try {
	        Class.forName(path);

	        con = DriverManager.getConnection(url, user, pass);

	        pst = con.prepareStatement(query);

	        rs = pst.executeQuery();

	        if (rs.next()) {
	            totalValue = rs.getInt("total_inventory_value");
	        }

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return totalValue;
	}
	

}
