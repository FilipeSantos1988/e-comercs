package logicLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Stm_product;
import classes.Stm_site;
import classes.Stm_site_cart;
import classes.Stm_site_cart_product;
import classes.Stm_site_client;
import classes.Stm_site_session;
import datalayer.ConnectionDB;
import datalayer.Datalayer;

public class BussinesFacadeTransiction {

	private ConnectionDB connection;
	private Connection connect;
	Site site = new Site();
	Session session = new Session();
	Client client = new Client();
	Products product = new Products();
	Cart cart = new Cart();
	CartProducts cartProducts = new CartProducts();
	List<Stm_site_cart> carts = new ArrayList<Stm_site_cart>();
	List<Stm_site_cart_product> productsList = new ArrayList<Stm_site_cart_product>();
	List<Stm_product> products = new ArrayList<Stm_product>();

	public SessionAcess createAcess(String sessionTk) {

		SessionAcess sessionAcess = new SessionAcess();
		int siteId = site.acessSite();
		int clientId = client.createClient(siteId);
		session.createSession(siteId, sessionTk, clientId);
		sessionAcess.setClientId(clientId);
		sessionAcess.setSessionId(sessionTk);
		sessionAcess.setSiteId(siteId);
		return sessionAcess;

	}

	public Boolean getAcess(SessionAcess sessionAcess) {

		if (session.checkAcess(sessionAcess.getSessionId())) {
			return true;
		} else {

			return false;
		}

	}

	public void closeAcess() {

	}

	public void updateSession(SessionAcess sessionAcess) {

		session.updateSession(sessionAcess.getSessionId(), sessionAcess.getActualDate());

	}

	public void openTransiction() throws SQLException {

		this.connection = new ConnectionDB();
		this.connect = connection.getConnection();
		PreparedStatement st = null;
		String mysql = "START TRANSICTION;";
		st = connect.prepareStatement(mysql);
		st.execute();

	}

	public void doneTransiction() throws SQLException {

		this.connection = new ConnectionDB();
		this.connect = connection.getConnection();
		PreparedStatement st = null;
		String mysql = "COMMIT;";
		st = connect.prepareStatement(mysql);
		st.execute();

	}

	public void backTransiction() throws SQLException {

		this.connection = new ConnectionDB();
		this.connect = connection.getConnection();
		PreparedStatement st = null;
		String mysql = "ROLLBACK;";
		st = connect.prepareStatement(mysql);
		st.execute();

	}

	/*
	public void addProductToCartName(SessionAcess sessionAcess, int productId, String cart_Tk) {

		CartProducts cartProducts = null;

		cartProducts.addProduct(sessionAcess.getSiteId(), cartTk, productId);
		
		 * Stm_site_cart carts = cart.getCartByName(cartTk,
		 * sessionAcess.getSessionId()); cart.addCart(carts.getCart_tk(), productId,
		 * sessionAcess.getSiteId());
		

	} */

	public void addProductToCart(SessionAcess sessionAcess, int productId) throws SQLException {

		try {
			openTransiction();
			Cart cart = new Cart();
			cart.getCartBySession(sessionAcess);
			cart.addProduct(productId);
			doneTransiction();
		} catch (SQLException e) {

			backTransiction();

		}
	}

	/*
	 * public void getOffProduct(SessionAcess sessionAcess, int productId, String
	 * cartTk) {
	 * 
	 * 
	 * 
	 * Stm_product products = product.getProducts(productId); Stm_site_cart carts =
	 * cart.getCartByName(cartTk,sessionAcess.getSessionId());
	 * 
	 * cart.removeCartProduct(carts.getCart_tk(),products.getProduct_id(),
	 * sessionAcess.getSiteId(),)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public void buyCart() {

	}

	public void createCart() {

	}

	public void removeCart() {

	}

}
