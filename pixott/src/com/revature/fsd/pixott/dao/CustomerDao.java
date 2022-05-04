package com.revature.fsd.pixott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.fsd.pixott.Customer;

public class CustomerDao {
	public void signup(Customer Customer) {
		String sql = "insert into customer (name,mobilenumber,password) values (?,?,?)";
		try (
			Connection conn = Util.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		) {
			System.out.println("connected succesfully.");
			stmt.setString(1, Customer.getName());
			stmt.setString(2, Customer.getMobile());
			stmt.setString(3, Customer.getPassword());
			stmt.executeUpdate();
			System.out.println("Customer added successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public Customer getcustomer(String mobile) {
		String sql = "select * from customer where mobilenumber = ?";
		try (Connection conn = Util.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);
				)
		{
			//System.out.println("connected successfully");
			stmt.setString(1, mobile);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setMobile(rs.getString("mobilenumber"));
				customer.setName(rs.getString("name"));
				customer.setPassword(rs.getString("password"));
				System.out.println("Login successfull \n Welcome "+customer.getName());
			} else {
				System.out.println("invalid login details");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

	}
		return null;
	}
}


