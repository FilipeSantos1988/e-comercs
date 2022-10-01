package userInterfaces;

import classes.C_Products;
import logicLayer.BussinesFacadeOperation;
import logicLayer.LogicLayer;
import logicLayer.Products;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class SearchProducts
 */
@WebServlet("/SearchProducts")
public class SearchProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	BussinesFacadeOperation bFacade = new BussinesFacadeOperation();
	LogicLayer llayer;
	String name;
	String desc;
	double value;

	public SearchProducts() {
		super();
		llayer = new LogicLayer();
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
		
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		int clientId;
		// criar site
		//int siteId = llayer.createSite();
		//session.setAttribute("siteId", siteId);
		
		
		// criar cliente sessao
		/*if (!llayer.checkSession(session.getId())) {
			clientId = llayer.createClient(siteId, session.getId(),session.getCreationTime(), session.getLastAccessedTime());
			session.setAttribute("clientId", clientId);
		} else {
			System.out.println("client existe");
			
		}*/

		
		
		
		

		PrintWriter writer = response.getWriter();
		writer.println("<h1> cheguei aqui </h1>");
		String rqst = request.getParameter("nameProduct");
		writer.println("<h1> cheguei aqui com o nome:" + rqst + " </h1>");
		List<Products>products = bFacade.showProducts(rqst);
		
		
		//List<Products> products = llayer.Searchproducts(Rqst);

		writer.println("<h1> Consegui</h1>");
		writer.println("<h1> Consegui2</h1>");

		/*
		 * for(C_Products p: products) { this.name=p.getName(); this.desc=p.getDesc();
		 * this.value=p.getValue();
		 * writer.println("<p> producto nome: "+p.getName()+"producto descriçao: "+p.
		 * getDesc()+"product preco:"+String.valueOf(p.getValue())+"</p>");
		 * 
		 * }
		 */
		
		request.setAttribute("lProducts", products);
		RequestDispatcher rd = request.getRequestDispatcher("/Items.jsp");
		rd.forward(request, response);
		// response.sendRedirect("Item.jsp?products.get(i)
		/*
		*/

	}

}
