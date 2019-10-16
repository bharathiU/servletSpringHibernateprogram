package com.customerapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString=request.getParameter("id");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String salaryString=request.getParameter("salary");
		int id=Integer.parseInt(idString);
		Double salary=Double.parseDouble(salaryString);
		
		try{
			Connection connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hcl_batch3","root","root");
		PreparedStatement pstmt=connection.prepareStatement("insert into customer(id,name,address,mobile,email,salary)values(?,?,?,?,?,?)");
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, address);
		pstmt.setString(4, mobile);
		pstmt.setString(5, email);
		pstmt.setDouble(6, salary);
		int noOfRows=pstmt.executeUpdate();
		System.out.println(noOfRows);
		System.out.println("rec is inserted..");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		//response.sendRequestDispatcher rd=request.getRequestDispatcher("success.jsp");
		
		response.sendRedirect("success.jsp");
		
	
	}

}
