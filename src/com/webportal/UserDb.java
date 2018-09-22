package com.webportal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDb {

	private static DataSource dataSource;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static Statement statement;
	private static ResultSet resultSet;
	boolean b;

	public UserDb(DataSource dataSource) {
		UserDb.dataSource = dataSource;
	}

	/**
	 * This method is use to new user accound create, This method return boolean
	 * value
	 * 
	 * @param seller
	 */
	public boolean creatAccount(User seller) {
		try {
			connection = dataSource.getConnection();
			String sql = "INSERT INTO "
					+ "seller_store (name_reg, shop_name_reg, address_reg, email_reg, contact_reg, password_reg,user_type)"
					+ " VALUES(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, seller.getName_reg());
			preparedStatement.setString(2, seller.getShop_name_reg());
			preparedStatement.setString(3, seller.getAddress_reg());
			preparedStatement.setString(4, seller.getEmail_reg());
			preparedStatement.setString(5, seller.getContact_reg());
			preparedStatement.setString(6, seller.getPassword_reg());
			preparedStatement.setString(7, seller.getUser_type());

			b = preparedStatement.execute();

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(connection, preparedStatement, null);
		}
		return b;
	}

	/**
	 * This method is used to Check user details.
	 * @param table
	 * @param column
	 * @param data
	 * @param user_type
	 * @return the boolean value
	 */
	public boolean checkRegisterDetails(String table, String column, String data, String user_type) {
		boolean b = true;
		try {
			connection = dataSource.getConnection();
			if (connection != null) {
				String sql = " select * from " + table + " WHERE " + column + " = '" + data
						+ "' AND user_type = '"+user_type+"'";
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				b = resultSet.next();
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		} finally {
			close(connection, statement, resultSet);
		}
		return b;
	}

	/**
	 * This method is used all database connection closed.
	 * @param myConn
	 * @param myStmt
	 * @param myRs
	 */
	public static void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close(); // doesn't really close it ... just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	/**
	 * This method is used to forget password.
	 * @param password
	 * @param filled
	 * @param user_id
	 * @param user_type
	 * @return the boolean value
	 */
	public static boolean forgetPassword(String password, String filled, String user_id, String user_type) {
		boolean b = false;
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String sql = " UPDATE seller_store SET  password_reg  = ? WHERE seller_store." + filled
				+ "= ? AND seller_store.user_type = ?";
		try {
			connection = dataSource.getConnection();

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, user_id);
			preparedStatement.setString(3, user_type);

			b = preparedStatement.executeUpdate() > 0;

		} catch (SQLException ex) {
			ex.getStackTrace();
		} finally {
			close(connection, preparedStatement, null);
		}
		return b;
	}

	/**
	 * This method is given the user information and this method RETURN List.
	 * 
	 * @param email
	 * @param password
	 * @param user_type
	 */
	public static List<User> userInfo(String email, String password) throws Exception {
		ArrayList<User> arrayList = new ArrayList<>();
		User user;
		try {
			connection = dataSource.getConnection();
			String sql = "select * from seller_store where email_reg = '" + email + "' AND password_reg = " + password;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String name_reg = resultSet.getString("name_reg");
				String shop_name_reg = resultSet.getString("shop_name_reg");
				String address_reg = resultSet.getString("address_reg");
				String email_reg = resultSet.getString("email_reg");
				String contact_reg = resultSet.getString("contact_reg");
				String password_reg = resultSet.getString("password_reg");
				String user_type = resultSet.getString("user_type");

				user = new User(id,name_reg, shop_name_reg, address_reg, email_reg, contact_reg, password_reg, user_type);
				arrayList.add(user);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(connection, statement, resultSet);
		}
		return arrayList;

	}
	
	public static String checkUserType(String email, String colume) throws Exception {
		String user_type = "null";
		try {
			connection = dataSource.getConnection();
			String sql = "select * from seller_store where "+colume+" = '" + email+"'";// + "' AND password_reg = " + password
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				user_type = resultSet.getString("user_type");
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(connection, statement, resultSet);
		}
		return user_type;
	}
}
