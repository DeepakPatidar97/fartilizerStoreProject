package com.webportal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ProductDb {

	private static DataSource dataSource;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static Statement statement;
	private static ResultSet resultSet;
	boolean b = false;

	public ProductDb(DataSource dataSource) {
		ProductDb.dataSource = dataSource;
	}

	/**
	 * This method given the Product List.
	 * 
	 * @return list
	 */
	public static List<Product> productList() throws Exception {
		ArrayList<Product> arrayList = new ArrayList<>();
		Product product;
		try {
			connection = dataSource.getConnection();
			String sql = "select * from master_product";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String product_name = resultSet.getString("product_name");
				String product_type = resultSet.getString("product_type");
				String product_company = resultSet.getString("product_company");
				String product_duration = resultSet.getString("product_duration");
				String product_expairy = resultSet.getString("product_expairy");
				String product_price = resultSet.getString("product_price");
				String product_quantity = resultSet.getString("product_quantity");
				String product_variety = resultSet.getString("product_variety");
				String product_type_organic = resultSet.getString("product_type_organic");
				String product_type_inorganic = resultSet.getString("product_type_inorganic");
				String product_type_machines = resultSet.getString("product_type_machines");
				String product_seeds = resultSet.getString("product_seeds");
				String product_medicine = resultSet.getString("product_medicine");
				String product_fertizer = resultSet.getString("product_fertizer");
				String shop_name = resultSet.getString("store_name");

				product = new Product(id, product_name, product_type, product_company, product_duration,
						product_expairy, product_price, product_quantity, product_variety, product_type_organic,
						product_type_inorganic, product_type_machines, product_seeds, product_medicine,
						product_fertizer, shop_name);
				arrayList.add(product);
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			UserDb.close(connection, statement, resultSet);
		}
		return arrayList;

	}

	/**
	 * This method is user of delete product
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean deleteProduct(String id) {
		int productId = Integer.parseInt(id);
		try {
			connection = dataSource.getConnection();
			String sql = "DELETE FROM `master_product` WHERE `master_product`.`id` = ? ";
//			DELETE FROM `master_product` WHERE `master_product`.`id` = 30 AND `master_product`.`product_name` = ;	

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, productId);
			b = preparedStatement.execute();
		} catch (Exception e) {
			e.getStackTrace();

		} finally {
			UserDb.close(connection, statement, resultSet);
		}
		return b;

	}

	/**
	 * This method is New Add the product And product detail,
	 * 
	 * @return boolean
	 * @param product
	 */
	public boolean addProduct(Product product) {
		try {
			connection = dataSource.getConnection();
			String sql = "INSERT INTO " + "master_product (product_name, " + "product_company, " + "product_expairy,"
					+ "product_price, " + "product_quantity," + "product_duration, " + "product_type,"
					+ "product_variety)" + " VALUES(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, product.getProduct_name());
			preparedStatement.setString(2, product.getProduct_company());
			preparedStatement.setString(3, product.getProduct_price());
			preparedStatement.setString(4, product.getProduct_expairy());
			preparedStatement.setString(5, product.getProduct_quantity());
			preparedStatement.setString(6, product.getProduct_duration());
			preparedStatement.setString(7, product.getProduct_type());
			preparedStatement.setString(8, product.getProduct_variety());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();

		} finally {
			UserDb.close(connection, preparedStatement, resultSet);
		}
		return b;

	}

	/**
	 * This method is update the single product details. 
	 * @param theProduct
	 * @throws Exception
	 */
	public void updateProduct(Product theProduct) throws Exception {
		
		int productId = Integer.parseInt( theProduct.getId());
		ProductValue.Product_Name = theProduct.getProduct_name();
		ProductValue.Product_Company = theProduct.getProduct_company();
		ProductValue.Product_Veraity = theProduct.getProduct_variety();
		ProductValue.Product_Expairy = theProduct.getProduct_expairy();
		ProductValue.Product_Price = theProduct.getProduct_price();
		ProductValue.Product_quantity = theProduct.getProduct_quantity();
		ProductValue.Product_duration = theProduct.getProduct_duration();
		
		try {
			connection = dataSource.getConnection();

			String sql = "UPDATE `master_product` SET `product_name` = ?, `product_company` = ?,"
					+ " `product_variety` = ?, `product_expairy` = ?, `product_price` = ?,"
					+ " `product_quantity` = ?, `product_duration` = ? WHERE `master_product`.`id` = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ProductValue.Product_Name);
			preparedStatement.setString(2, ProductValue.Product_Company);
			preparedStatement.setString(3, ProductValue.Product_Veraity);
			preparedStatement.setString(4, ProductValue.Product_Expairy);
			preparedStatement.setString(5, ProductValue.Product_Price);
			preparedStatement.setString(6, ProductValue.Product_quantity);
			preparedStatement.setString(7, ProductValue.Product_duration);
			preparedStatement.setInt(8, productId);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.getStackTrace();
		} finally {
			UserDb.close(connection, preparedStatement, null);
		}
	}

	/**
	 * This method is given to single product detail.
	 * @param id
	 * @return the list
	 * @throws Exception
	 */
	public static List<Product> ProductInfo(String id) throws Exception {
		ArrayList<Product> arrayList = new ArrayList<>();
		Product product;

		try {
			connection = dataSource.getConnection();
			String sql = "select * from master_product where id = " + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String Id = resultSet.getString("id");
				String product_name = resultSet.getString("product_name");
				String product_type = resultSet.getString("product_type");
				String product_company = resultSet.getString("product_company");
				String product_duration = resultSet.getString("product_duration");
				String product_expairy = resultSet.getString("product_expairy");
				String product_price = resultSet.getString("product_price");
				String product_quantity = resultSet.getString("product_quantity");
				String product_variety = resultSet.getString("product_variety");
				String product_type_organic = resultSet.getString("product_type_organic");
				String product_type_inorganic = resultSet.getString("product_type_inorganic");
				String product_type_machines = resultSet.getString("product_type_machines");
				String product_seeds = resultSet.getString("product_seeds");
				String product_medicine = resultSet.getString("product_medicine");
				String product_fertizer = resultSet.getString("product_fertizer");
				String shop_name = resultSet.getString("store_name");

				product = new Product(Id, product_name, product_type, product_company, product_duration,
						product_expairy, product_price, product_quantity, product_variety, product_type_organic,
						product_type_inorganic, product_type_machines, product_seeds, product_medicine,
						product_fertizer, shop_name);
				arrayList.add(product);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			UserDb.close(connection, statement, resultSet);
		}
		return arrayList;
	}

}
