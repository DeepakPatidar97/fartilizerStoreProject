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
		String user_type = null;
		String filled = request.getParameter("filled");
		String user_id = request.getParameter("user_id");

		actionPerform(request, response, params, email, password, name, confirm_Password, id, shop_name, address,
				contact, product_name, product_company, product_expairy, product_price, product_quantity,
				product_duration, product_type, product_variety, product_type_organic, product_type_inorganic,
				product_type_machines, product_seeds, product_medicine, product_fertizer, user_type, filled, user_id);

	}

	/**
	 * This method is actions perform and it's called master method.
	 * @param request
	 * @param response
	 * @param params
	 * @param email
	 * @param password
	 * @param name
	 * @param confirm_Password
	 * @param id
	 * @param shop_name
	 * @param address
	 * @param contact
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
	 * @param user_type
	 * @param filled
	 * @param user_id
	 */
	protected void actionPerform(HttpServletRequest request, HttpServletResponse response, String params, String email,
			String password, String name, String confirm_Password, String id, String shop_name, String address,
			String contact, String product_name, String product_company, String product_expairy, String product_price,
			String product_quantity, String product_duration, String product_type, String product_variety,
			String product_type_organic, String product_type_inorganic, String product_type_machines,
			String product_seeds, String product_medicine, String product_fertizer, String user_type, String filled,
			String user_id) {
		if (params.equals("login")) {
			try {
				user_type = UserDb.checkUserType(email, "email_reg");
				login(request, response, email, password, user_type);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (params.equals("register")) {
			register(request, response, name, shop_name, address, email, contact, password, user_type);
		} else if (params.equals("forget")) {
			try {
				user_type = UserDb.checkUserType(user_id, filled);
				forgetPassword(request, response, password, confirm_Password, filled, user_id, user_type);
			} catch (Exception e) {
				e.printStackTrace();
			}

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
		} else if (params.equals("productMoreDetails")) {

			productMoreDetailsAndBuy(request, response, id, "productMoreDetails");
		} else if (params.equals("buyPage")) {
			productMoreDetailsAndBuy(request, response, id, "buyPage");
		}
	}

	/**
	 * This method is login user accounts.
	 * @param request
	 * @param response
	 * @param email
	 * @param password
	 * @param user_type
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response, String email, String password,
			String user_type) {
		if (db.loginUser(email, password, user_type)) {
			homeDisp(request, response, email, password, user_type);
			UserHome(request, response, user_type);
		} else {
			pageDispatcher(request, response, "index");
		}
	}

	/**
	 * this method is a register new user.
	 * @param request
	 * @param response
	 * @param name
	 * @param shop_name
	 * @param address
	 * @param email
	 * @param contact
	 * @param password
	 * @param user_type
	 */
	protected void register(HttpServletRequest request, HttpServletResponse response, String name, String shop_name,
			String address, String email, String contact, String password, String user_type) {
		if (email != null && contact != null) {
			if (db.checkRegisterDetails("seller_store", "email_reg", email, user_type)
					|| db.checkRegisterDetails("seller_store", "contact_reg", contact, user_type)) {
				pageDispatcher(request, response, "register");
			} else {
				user = new User(name, shop_name, address, email, contact, password, user_type);
				db.creatAccount(user);
				try {
					homeDisp(request, response, email, password, user_type);
					UserHome(request, response, user_type);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			pageDispatcher(request, response, "register");
		}
	}

	/**
	 * This method is add the new product in database.
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
					homeDisp(request, response, email, password, "seller");
					UserHome(request, response, "seller");
				} else {
					UserHome(request, response, "seller");
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			UserHome(request, response, "seller");
		}
	}

	/**
	 * this method is delete the product database.
	 * @param request
	 * @param response
	 * @param id
	 * @param email
	 * @param password
	 */
	protected void deleteProduct(HttpServletRequest request, HttpServletResponse response, String id, String email,
			String password) {
		if (!productDb.deleteProduct(id)) {
			homeDisp(request, response, email, password, "seller");
			UserHome(request, response, "seller");
		}
	}

	/**
	 * this method is a dispatch product info update page.
	 * @param request
	 * @param response
	 * @param id
	 */
	protected void updatePage(HttpServletRequest request, HttpServletResponse response, String id) {

		if (id != null) {
			try {
				product_list = ProductDb.productInfo(id);
				request.setAttribute("tempProduct_list", product_list);
				pageDispatcher(request, response, "update");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * this method is a update the product details.
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

			homeDisp(request, response, email, password, "seller");
			UserHome(request, response, "seller");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is a check to user type and dispatch the user Home page.
	 * @param request
	 * @param response
	 * @param user_type
	 */
	protected void UserHome(HttpServletRequest request, HttpServletResponse response, String user_type) {
		try {
			if (user_type.equals("seller")) {
				getServletContext().getRequestDispatcher("/seller/homepage.jsp").forward(request, response);
			}
			if (user_type.equals("buyer")) {
				getServletContext().getRequestDispatcher("/buyer/homepage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * this method is a display the product details and user details in home page.
	 * @param request
	 * @param response
	 * @param email
	 * @param password
	 * @param user_type
	 */
	protected void homeDisp(HttpServletRequest request, HttpServletResponse response, String email, String password,
			String user_type) {
		try {
			list = UserDb.userInfo(email, password, user_type);
			request.setAttribute("name", list);

			product_list = ProductDb.productList();
			request.setAttribute("product_list", product_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method is dispatch the pages.
	 * @param request
	 * @param response
	 * @param page
	 */
	protected void pageDispatcher(HttpServletRequest request, HttpServletResponse response, String page) {
		if (page.equals("index")) {
			try {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

		if (page.equals("register")) {
			try {
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		}
		if (page.equals("forget")) {
			try {
				getServletContext().getRequestDispatcher("/forget.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		}
		if (page.equals("update")) {
			try {
				getServletContext().getRequestDispatcher("/seller/update.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		}
		if (page.equals("productMoreDetails")) {
			try {
				getServletContext().getRequestDispatcher("/buyer/productDetail.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		if (page.equals("buyPage")) {
			try {
				getServletContext().getRequestDispatcher("/buyer/productBuy.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void forgetPassword(HttpServletRequest request, HttpServletResponse response, String password,
			String confirm_Password, String filled, String user_id, String user_type) {
		try {
			if (password.equals(confirm_Password)) {
				UserDb.forgetPassword(password, filled, user_id, user_type);
				homeDisp(request, response, user_id, confirm_Password, user_type);
				UserHome(request, response, user_type);
			} else {
				pageDispatcher(request, response, "forget");
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * this method is a buyer to action perform and product details show more details page and buy page.
	 * @param request
	 * @param response
	 * @param id
	 * @param page
	 */
	protected void productMoreDetailsAndBuy(HttpServletRequest request, HttpServletResponse response, String id,
			String page) {
		try {
			product_list = ProductDb.productInfo(id);
			request.setAttribute("product_list", product_list);
			pageDispatcher(request, response, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}