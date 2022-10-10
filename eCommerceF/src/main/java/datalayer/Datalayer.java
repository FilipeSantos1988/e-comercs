package datalayer;

import java.util.ArrayList;
import java.util.List;
import classes.Stm_product;
import classes.Stm_site;
import classes.Stm_site_cart;
import classes.Stm_site_cart_product;
import classes.Stm_site_client;
import classes.Stm_site_product_price;
import classes.Stm_site_session;
import datalayerDAO.DaoFactory;
import datalayerDAO.StmProduct;
import datalayerDAO.StmSite;
import datalayerDAO.StmSiteCart;
import datalayerDAO.StmSiteCartProduct;
import datalayerDAO.StmSiteClient;
import datalayerDAO.StmSiteProductPrice;
import datalayerDAO.StmSiteSession;
import logicLayer.Products;

public class Datalayer {

	public Datalayer() {
		;

	}

	public void getSiteInformaction(Stm_site site) {

		StmSite siteI = DaoFactory.createStmSite();
		site = siteI.findById(site.getSite_id());

	}

	public void createClient(Stm_site_client client) {

		StmSiteClient clientI = DaoFactory.createStmSiteClient();
		clientI.insert(client);

	}

	public void createSession(Stm_site_session session) {
		System.out.println("Esqou aqui2");
		StmSiteSession sessionI = DaoFactory.createStmSiteSession();
		sessionI.insert(session);
	
	}

	public List<Stm_site_session> getAllSessions(int clientId) {
		// quanda a trago para aqui vem como objecto,criar objecto
		List<Stm_site_session> sessions = new ArrayList<Stm_site_session>();
		StmSiteSession sessionsI = DaoFactory.createStmSiteSession();
		sessions = sessionsI.findById(clientId);
		return sessions;
	}

	public Stm_site_session getSessionByName(String session_Tk) {

		StmSiteSession sessionsI = DaoFactory.createStmSiteSession();
		List<Stm_site_session> sessions = new ArrayList<Stm_site_session>();
		sessions = sessionsI.findAll();

		for (Stm_site_session s : sessions) {
			if (s.getSession_tk().equals(session_Tk)) {
				return s;
			}
		}

		return null;
	}

	public void updateSession(Stm_site_session session) {
		StmSiteSession sessionsI = DaoFactory.createStmSiteSession();
		List<Stm_site_session> sessions = new ArrayList<Stm_site_session>();
		sessionsI.update(session);

	}

	public Stm_product getProductById(int productId) {

		StmProduct productI = DaoFactory.createStmProduct();
		return productI.findById(productId);

	}

	public List<Stm_product> getAllProducts() {

		List<Stm_product> product = new ArrayList<Stm_product>();
		StmProduct productI = DaoFactory.createStmProduct();
		product = productI.findAll();

		return product;
	}

	public List<Stm_site_product_price> getAllProductsPrice() {

		StmSiteProductPrice productPriceI = DaoFactory.createStmSiteProductPrice();
		List<Stm_site_product_price> productPrice = productPriceI.findAll();

		return productPrice;
	}

	public Stm_site_product_price getProductPriceBYProductId(int product_id) {
		System.out.println("nao me chateies4");
		System.out.println("nao me chateies");
		StmSiteProductPrice cartProductPriceI = DaoFactory.createStmSiteProductPrice();
		Stm_site_product_price cartProductPrice = new Stm_site_product_price();
		cartProductPrice = cartProductPriceI.findById(product_id);

		return cartProductPrice;
	}

	/* talvez possa apagar */
	public List<Stm_site_product_price> getAllPrices() {
		List<Stm_site_product_price> productP = new ArrayList<Stm_site_product_price>();
		StmSiteProductPrice productI = DaoFactory.createStmSiteProductPrice();
		productP = productI.findAll();

		for (Stm_site_product_price price : productP) {
			System.out.println(price.getPrice_vl());
		}

		return productP;
	}

	/*public void removeProductCart(String cartTk, int productId) {

		StmSiteCartProduct cartProductSiteI = DaoFactory.createStmSiteCartProduct();
		List<Stm_site_cart_product> cartProducts = new ArrayList<Stm_site_cart_product>();

		cartProductSiteI.deleteByCartProduct(cartTk, productId);
	}*/

	public void removeProduct(int productId) {
		StmSiteCartProduct cartProductSiteI = DaoFactory.createStmSiteCartProduct();

		cartProductSiteI.deleteById(productId);
	}

	public void insertCart(Stm_site_cart cart) {

		StmSiteCart cartI = DaoFactory.createStmSiteCart();
		cartI.insert(cart);

	}

	public void addItemCart(Stm_site_cart cart) {

		StmSiteCart cartI = DaoFactory.createStmSiteCart();
		cartI.insert(cart);
		List<Stm_site_cart_product> products = new ArrayList<Stm_site_cart_product>();
		StmSiteCartProduct productCartI = DaoFactory.createStmSiteCartProduct();
		products = cart.getProducts();

		for (Stm_site_cart_product p : products) {
			productCartI.insert(p);
		}

	}

	public Stm_site_cart getCartByName(String cartName) {
		List<Stm_site_cart> carts = new ArrayList<Stm_site_cart>();
		StmSiteCart cartI = DaoFactory.createStmSiteCart();

		carts = cartI.findAll();
		for (Stm_site_cart cart : carts) {
			if (cart.getCart_tk().equals(cartName)) {
				return cart;
			}
		}

		return null;

	}

	public List<Stm_site_cart_product> getByCartName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Stm_site_cart> getAllCart() {
		// TODO Auto-generated method stub
		List<Stm_site_cart> carts = new ArrayList<Stm_site_cart>();
		StmSiteCart cartsI = DaoFactory.createStmSiteCart();
		carts = cartsI.findAll();

		return carts;
	}

	public Stm_site_cart getCartByNames(String cartTk, String sessionTk) {

		StmSiteCart cartSiteI = DaoFactory.createStmSiteCart();
		List<Stm_site_cart> carts = new ArrayList<Stm_site_cart>();
		carts = cartSiteI.findAll();

		for (Stm_site_cart cart : carts) {
			if (cart.getCart_tk().equals(cartTk) && cart.getSession_tk().equals(sessionTk)) {
				return cart;
			}
		}

		return null;
	}

	public List<Stm_site_cart_product> getAllcartproductByName(String cartTk) {

		StmSiteCartProduct cartProductSiteI = DaoFactory.createStmSiteCartProduct();
		List<Stm_site_cart_product> cartProducts = new ArrayList<Stm_site_cart_product>();
		List<Stm_site_cart_product> productsOnCart = new ArrayList<Stm_site_cart_product>();
		cartProducts = cartProductSiteI.findAll();

		for (Stm_site_cart_product cartProduct : cartProducts) {
			if (cartProduct.getCart_tk().equals(cartTk)) {
				productsOnCart.add(cartProduct);
			}
		}

		return productsOnCart;
	}

	public List<Stm_product> getProductByName(String product_ds) {
		Datalayer dataLayer = new Datalayer();
		List<Stm_product> product = new ArrayList<Stm_product>();
		List<Stm_product> productByName = new ArrayList<Stm_product>();
		product = dataLayer.getAllProducts();
		for (Stm_product p : product) {
			if (p.getProducts_ds().equals(product_ds)) {
				productByName.add(p);
			}
		}
		return productByName;
	}
	
	

	public Stm_site_product_price getProductPriceByproductId(Integer product_id) {
		StmSiteProductPrice cartProductPriceI = DaoFactory.createStmSiteProductPrice();
		Stm_site_product_price price = cartProductPriceI.findById(product_id);
		return price;
	}

	public Stm_site_cart getClientCarts(int clientId, String sessionId) {

		System.out.println("aqui ja cheguei7");
		Datalayer dataLayer = new Datalayer();
		StmSiteCart cartI = DaoFactory.createStmSiteCart();
		List<Stm_site_cart> carts = cartI.findAll();
		System.out.println("aqui ja cheguei7");
		System.out.println("aqui ja cheguei7");
		
		for (Stm_site_cart cart : carts) {
			if (cart.getClient_id() == clientId && cart.getSession_tk() == sessionId) {
				return cart;
			}
		}
		System.out.println("aqui ja cheguei7");
		return null;
	}

	public void removeProduct(String cartTk, int productId) {
		// TODO Auto-generated method stub
		
	}

	public void setItemCart(Stm_site_cart_product cartProduct) {
		
		
	}

	
	//update stm_site_cart_product
	
	
	public Stm_site_cart_product getProductCartById(int productId) {
		Datalayer dataLayer = new Datalayer();
		StmSiteCartProduct cartProductI = DaoFactory.createStmSiteCartProduct();
		Stm_site_cart_product cartProduct = cartProductI.findById(productId);
		return cartProduct;
		
	}
	
	
	public void AddProductInCart(Stm_site_cart_product productOnCart) {
		
		StmSiteCartProduct cartProductI = DaoFactory.createStmSiteCartProduct();
		cartProductI.insert(productOnCart);
		
	}

	public void addExistentProduct(Stm_site_cart_product productOnCart) {
		
		StmSiteCartProduct cartProductI = DaoFactory.createStmSiteCartProduct();
		cartProductI.update(productOnCart);
	}

}
