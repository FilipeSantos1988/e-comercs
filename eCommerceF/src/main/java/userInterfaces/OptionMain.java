package userInterfaces;

import logicLayer.BussinesFacadeOperation;
import logicLayer.Cart;
import logicLayer.LogicLayer;
import logicLayer.Products;
import logicLayer.SessionAcess;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.C_Products;
import classes.Option;

/**
 * Servlet implementation class OptionMain
 */
@WebServlet("/OptionMain")
public class OptionMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LogicLayer logicLayer;
	BussinesFacadeOperation bfo = new BussinesFacadeOperation();
	SessionAcess sessionAcess = new SessionAcess();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OptionMain() {
		super();
		logicLayer = new LogicLayer();
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
		// TODO Auto-generated method stub
		
		
		HttpSession session= request.getSession(false);
		
		
		
		if(session == null) {
			session = request.getSession();
			session.setMaxInactiveInterval(30);
			sessionAcess = logicLayer.createSession(session.getId());
			System.out.println(sessionAcess.getClientId()+ sessionAcess.getSessionId());
			session.setAttribute("sessionAcess", sessionAcess);
			
		
		}
	
		
		int option = Integer.parseInt(request.getParameter("button"));
		System.out.println("Esqou aqui");
		
		/*Long startDate = session.getCreationTime();
		Long updateDate = session.getLastAccessedTime();

		
		
		if (session.isNew()) {

			int idSite = logicLayer.createSite();
			int idClient = logicLayer.createClient(idSite, request.getParameter("button"), session.getCreationTime(),
					session.getCreationTime());
			session.setAttribute("siteId", idSite);
			session.setAttribute("clientId", idClient);

		}

		else {

			logicLayer.updateClient(request.getParameter("button"), session.getLastAccessedTime(),
					(int) session.getAttribute("siteId"), (int) session.getAttribute("clientId"));

		}*/

		
		
		
		
		
		switch (option) {

		case 1:
			System.out.println("Esqou aqui");
			List<Products> products = bfo.showProducts();
			
			for(Products p: products)
				System.out.println(p.getProduct_id());
			
			request.setAttribute("lProducts", products);
			RequestDispatcher rd = request.getRequestDispatcher("/Items.jsp");
			rd.forward(request, response);
			break;

		
		
		case 2 : 
			
			//verificar se tem sessao
			
			break;
			
		
		case 3:
			System.out.println("aqui ja cheguei1");
			sessionAcess = (SessionAcess) session.getAttribute("sessionAcess");
			System.out.println("aqui ja cheguei2");
			System.out.println(sessionAcess.getClientId() + sessionAcess.getSessionId());
			List<Cart> carts = bfo.showCarts(sessionAcess);
			RequestDispatcher rd1 = request.getRequestDispatcher("/CartList.jsp");
			rd1.forward(request, response);
			
		break;
		
		
		case 5:
			
			
		break;
			

	}

}}
