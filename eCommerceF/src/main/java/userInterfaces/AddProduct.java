package userInterfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datalayer.Datalayer;
import logicLayer.LogicLayer;
import logicLayer.SessionAcess;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		LogicLayer logicLayer= new LogicLayer();
		HttpSession session = request.getSession(false);
		String productId = request.getParameter("add");
		System.out.println(productId);
		int idProduct = Integer.parseInt(productId);
		SessionAcess sessionAcess = (SessionAcess) session.getAttribute("sessionAcess");
		logicLayer.addCartProduct(sessionAcess, idProduct);
		//logicLayer.addCart(productId, idProduct, idProduct, idProduct, null)
		
		
		/*
		int client_Id = (int) session.getAttribute("siteId");
		int site_Id = (int) session.getAttribute("clientId");
		
		System.out.println("cheguei aqui");
		
		
		
		
		if (session.getAttribute("cartId") != null) {
			logicLayer.addCart((int)session.getAttribute("cartId"),idProduct, site_Id, client_Id,session.getLastAccessedTime());
		} else {
			int cartId = logicLayer.createCart(site_Id,client_Id,session.getLastAccessedTime());
			session.setAttribute("cartId", cartId);
			logicLayer.addCart((int)session.getAttribute("cartId"),idProduct, site_Id, client_Id,session.getLastAccessedTime());
		}*/

		doGet(request, response);
	}

}
