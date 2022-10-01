package userInterfaces;

import logicLayer.BussinesFacadeOperation;
import logicLayer.LogicLayer;
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

		HttpSession session = request.getSession();
		int option = Integer.parseInt(request.getParameter("button"));
		session.setMaxInactiveInterval(50);

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
			List<C_Products> products = logicLayer.Searchproducts();
			request.setAttribute("lProducts", products);
			RequestDispatcher rd = request.getRequestDispatcher("/Items.jsp");
			rd.forward(request, response);
			break;

		}
		
		case 2 : 
			
			List<Products> products = bfo.showProductOnCart(sessionAcess,cartTk);
			request.setAttribute("lProducts", products);
			RequestDispatcher rd = request.getRequestDispatcher("/Items.jsp");
			rd.forward(request, response);
			break;

	}

}
