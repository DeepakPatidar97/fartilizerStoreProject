package com.webportal;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection  connection;
		PreparedStatement myStat;
		boolean b;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmer_store","root","");
			String sql = "INSERT INTO "
					+ "seller_store (name_reg, shop_name_reg, address_reg, email_reg, contact_reg, password_reg,user_type)"
					+ " VALUES(?,?,?,?,?,?,?)";

			myStat = (PreparedStatement) connection.prepareStatement(sql);

			myStat.setString(1, "deepak");
			myStat.setString(2, "deepak");
			myStat.setString(3, "mahahh");
			myStat.setString(4, "dmxzczffffffdmnfa");
			myStat.setString(5, "jhguvbjhghg");
			myStat.setString(6, "887871218787");
			myStat.setString(7, "seller");
			
			if(myStat.executeUpdate()>0) {
				b=true;
				
			}else {
				b=false;				
			}		
			connection.close();
			System.out.println(b);
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
