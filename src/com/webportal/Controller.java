package com.webportal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/farmer_store")
	private DataSource dataSource;
	private UserDb db;
	private User user;
	private Product product;
	private ProductDb productDb;
	private List<User> list = new ArrayList<User>();
	private List<Product> product_list = new ArrayList<Product>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub+

		db = new UserDb(dataSource);
		productDb = new ProductDb(dataSource);
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String params = request.getParameter("page");

		// login page parameters

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String confirm_Password = request.getParameter("confirm_Password");
		String id = request.getParameter("id");
		String shop_name = request.getParameter("shop_name");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String product_name = request.getParameter("product_name");
		String product_company = request.getParameter("product_company");
		String product_expairy = request.getParameter("product_expairy");
		String product_price = request.getParameter("product_price");
		String product_quantity = request.getParameter("product_quantity");
		String product_duration = request.getParameter("product_duration");
		String product_type = request.getParameter("product_type");
		String product_variety = request.getParameter("product_variety");
		String product_type_organic = null;
		String product_type_inorganic = null;
		String product_type_machines = null;
		String product_seeds = null;
		String product_medicine = null;
		String product_fertizer = null;

		String user_id = request.getParameter("user_id");
		String filled = request.getParameter("filled");

		if (params.equals("login")) {
			login(request, response, email, password);
		} else if (params.equals("register")) {
			register(request, response, name, shop_name, address, email, contact, password);
		} else if (params.equals("forget")) {
			forgetPassword(request, response, password, confirm_Password, filled, user_id);
		} else if (params.equals("addProduct")) {
			addProduct(request, response, email, password, product_name, product_company, product_expairy,
					product_price, product_quantity, product_duration, product_type, product_variety,
					product_type_organic, product_type_inorganic, product_type_machines, product_seeds,
					product_medicine, product_fertizer, shop_name);
		} else if (params.equals("updatePage")) {
			updatePage(request, response, id);
		} else if (params.equals("update")) {
			updateProduct(request, response, id, email, password, product_name, product_company, product_expairy,
					product_price, product_quantity, product_duration, product_type, product_variety,
					product_type_organic, product_type_inorganic, product_type_machines, product_seeds,
					product_medicine, product_fertizer, shop_name);
		} else if (params.equals("delete")) {
			deleteProduct(request, response, id, email, password);
		}
	}

	/**
	 * This method is use to login user.
	 * 
	 * @param request
	 * @param response
	 * @param email
	 * @param password
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response, String email, String password) {
		if (db.checkRegisterDetails("seller_store", "email_reg", email, "seller")
				&& db.checkRegisterDetails("seller_store", "password_reg", password, "seller")) {
			try {
				homeDisp(request, response, email, password);
				getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				getServletContext().getRequestDispatcher("/incorrect.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method to be used in register the user.
	 * 
	 * @param request
	 * @param response
	 * @param name
	 * @param shop_name
	 * @param address
	 * @param email
	 * @param contact
	 * @param password
	 */
	protected void register(HttpServletRequest request, HttpServletResponse response, String name, String shop_name,
			String address, String email, String contact, String password) {
		if (email != null && contact != null) {
			if (db.checkRegisterDetails("seller_store", "email_reg", email, "seller")
					|| db.checkRegisterDetails("seller_store", "contact_reg", contact, "seller")) {
				try {
					getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			} else {
				user = new User(name, shop_name, address, email, contact, password, "seller");
				db.creatAccount(user);
				try {
					homeDisp(request, response, email, password);
					getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to add New Product.
	 * 
	 * @param request
	 * @param response
	 * @param email
	 * @param password
	 * @param product_name
	 * @param product_company
	 * @param product_expairy
	 * @param product_price
	 * @param product_quantity
	 * @param product_duration
	 * @param product_type
	 * @param product_variety
	 * @param product_type_organic
	 * @param product_type_inorganic
	 * @param product_type_machines
	 * @param product_seeds
	 * @param product_medicine
	 * @param product_fertizer
	 * @param shop_name
	 */
	protected void addProduct(HttpServletRequest request, HttpServletResponse response, String email, String password,
			String product_name, String product_company, String product_expairy, String product_price,
			String product_quantity, String product_duration, String product_type, String product_variety,
			String product_type_organic, String product_type_inorganic, String product_type_machines,
			String product_seeds, String product_medicine, String product_fertizer, String shop_name) {
		if (product_company != null && product_name != null) {
			try {
				if (!db.checkRegisterDetails("master_product", "product_company", product_company, "seller")
						|| db.checkRegisterDetails("master_product", "product_name", product_name, "seller")) {

					product = new Product(product_name, product_company, product_expairy, product_price,
							product_quantity, product_duration, product_type, product_variety, product_type_organic,
							product_type_inorganic, product_type_machines, product_seeds, product_medicine,
							product_fertizer, shop_name);
					productDb.addProduct(product);
					try {
						homeDisp(request, response, email, password);
						getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			try {
				getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * This method is used to Delete product in database.
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param email
	 * @param password
	 */
	protected void deleteProduct(HttpServletRequest request, HttpServletResponse response, String id, String email,
			String password) {
		if (!productDb.deleteProduct(id)) {
			try {
				homeDisp(request, response, email, password);
				getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to dispatch the update page.
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	protected void updatePage(HttpServletRequest request, HttpServletResponse response, String id) {

		if (id != null) {
			try {
				product_list = ProductDb.ProductInfo(id);
				request.setAttribute("tempProduct_list", product_list);
				getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to update the product list.
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param email
	 * @param password
	 * @param product_name
	 * @param product_company
	 * @param product_expairy
	 * @param product_price
	 * @param product_quantity
	 * @param product_duration
	 * @param product_type
	 * @param product_variety
	 * @param product_type_organic
	 * @param product_type_inorganic
	 * @param product_type_machines
	 * @param product_seeds
	 * @param product_medicine
	 * @param product_fertizer
	 * @param shop_name
	 */
	protected void updateProduct(HttpServletRequest request, HttpServletResponse response, String id, String email,
			String password, String product_name, String product_company, String product_expairy, String product_price,
			String product_quantity, String product_duration, String product_type, String product_variety,
			String product_type_organic, String product_type_inorganic, String product_type_machines,
			String product_seeds, String product_medicine, String product_fertizer, String shop_name) {
		try {
			product = new Product(id, product_name, product_company, product_expairy, product_price, product_quantity,
					product_duration, product_type, product_variety, product_type_organic, product_type_inorganic,
					product_type_machines, product_seeds, product_medicine, product_fertizer, shop_name);

			productDb.updateProduct(product);
			homeDisp(request, response, email, password);
			getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to take data home page.
	 * 
	 * @param request
	 * @param response
	 * @param email
	 * @param password
	 */
	protected void homeDisp(HttpServletRequest request, HttpServletResponse response, String email, String password) {
		try {
			list = UserDb.userInfo(email, password);
			request.setAttribute("name", list);

			product_list = ProductDb.productList();
			request.setAttribute("product_list", product_list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to change the password.
	 * @param request
	 * @param response
	 * @param password
	 * @param confirm_Password
	 * @param filled
	 * @param user_id
	 */
	protected void forgetPassword(HttpServletRequest request, HttpServletResponse response, String password,
			String confirm_Password, String filled, String user_id) {
		try {
			if (password.equals(confirm_Password)) {
				UserDb.forgetPassword(password, filled, user_id, "seller");
				homeDisp(request, response, user_id, confirm_Password);
				getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/forget.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
