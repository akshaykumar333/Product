package com.Amazon.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertData {

	public void addData(Product product) throws FileNotFoundException {
		Connection CON = null;
		PreparedStatement pstmt = null;

		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);

			String dburl = "jdbc:mysql://localhost:3306/market?user=root&password=root";
			CON = DriverManager.getConnection(dburl);

			String query = "insert into mobile values(?,?,?,?,?)";
			pstmt = CON.prepareStatement(query);

			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getDescription());
			pstmt.setDouble(4, product.getRating());

			FileInputStream file = new FileInputStream(product.getImage());
			pstmt.setBinaryStream(5, file);

			int res = pstmt.executeUpdate();

			if (res != 0) {
				System.out.println("data added");
			}

		} catch (SQLException e)

		{

			e.printStackTrace();
		}
		
		finally
		{
		try {
			if(CON!=null)
			CON.close();
			
			if(pstmt!=null)
				pstmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}

	}

}
