package logicLayer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import classes.Stm_product;
import classes.Stm_site_cart;
import classes.Stm_site_cart_product;
import datalayer.Datalayer;

public class Cart {

	String cart_tk;
	float totalValue;
	List<Products> products;
	
	
	
	public Cart() {
		;
	}

	public Cart(String cart_tk) {
		this.cart_tk = cart_tk;
	}

	public void getProductsCart() {

		Datalayer dataLayer = new Datalayer();
		List<Stm_site_cart_product> cartProducts = dataLayer.getAllcartproductByName(cart_tk);
		Products product = null;
		for (Stm_site_cart_product cartProduct : cartProducts) {
			product.getProduct(cartProduct.getProduct_id());
			products.add(product);

		}

	}

	public void createCart(SessionAcess sessionAcess) {

		Datalayer dataLayer = new Datalayer();
		Stm_site_cart cart = new Stm_site_cart();

		cart.setSite_id(sessionAcess.getSiteId());
		cart.setCart_tk(Integer.toString(sessionAcess.getSiteId()) + Integer.toString(sessionAcess.getClientId()));
		cart.setSession_tk(sessionAcess.getSessionId());
		cart.setClient_id(sessionAcess.getClientId());
		dataLayer.insertCart(cart);

	}

	public void removeProductsCart(String cartTk, int productId) {

		Datalayer dataLayer = new Datalayer();
		dataLayer.removeProductCart(cartTk, productId);

	}

	public void getCartByName(String cartTk, String SessionTk) {

		Datalayer dataLayer = new Datalayer();
		Stm_site_cart cart = new Stm_site_cart();
		cart = dataLayer.getCartByNames(cartTk, SessionTk);
		this.cart_tk = cart.getCart_tk();

	}

	/*
	 * public void addCart(String cartId, int productId, int siteId, int clientId) {
	 * 
	 * Datalayer dataLayer = new Datalayer(); Stm_site_cart cart = new
	 * Stm_site_cart(); Stm_product product = new Stm_product();
	 * 
	 * // aqui inicializa o car com os produtos no car cart = getCart(cartId);
	 * 
	 * // vai buscar o product getProduct(productId, product);
	 * 
	 * // verificar se existe o Id do product nos produtos if
	 * (checkProduct(product)) { cart.addItem(siteId, Integer.toString(cartId), new
	 * Stm_site_cart_product(product)); dataLayer.addItemCart(cart);
	 * 
	 * }}
	 */

	/*
	 * public boolean chekCart(String sessionTk, int clientId) {
	 * 
	 * Datalayer dataLayer = new Datalayer();
	 * 
	 * List<Stm_site_cart> carts = dataLayer.getAllCart();
	 * 
	 * for (Stm_site_cart cart : carts) { if (cart.getSession_tk().equals(sessionTk)
	 * && cart.getClient_id() == clientId) { return true; } }
	 * 
	 * 
	 * }
	 */

	/*
	 * public void addToCart(int cartId, int productId, int siteId, int clientId,
	 * Long updateD) {
	 * 
	 * Datalayer dataLayer = new Datalayer(); Stm_site_cart cart = new
	 * Stm_site_cart(); Stm_product product = new Stm_product();
	 * 
	 * // aqui inicializa o car com os produtos no car cart = getCart(cartId);
	 * 
	 * // vai buscar o product getProduct(productId, product);
	 * 
	 * // verificar se existe o Id do product nos produtos if
	 * (checkProduct(product)) { cart.addItem(siteId, Integer.toString(cartId), new
	 * Stm_site_cart_product(product)); dataLayer.addItemCart(cart);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */

	public void addToCart(SessionAcess sessionAcess, String cart_tk, int product_id) {

		Datalayer dataLayer = new Datalayer();
		Stm_site_cart carts = new Stm_site_cart();
		Stm_site_cart_product product = new Stm_site_cart_product();
		List<Stm_site_cart_product> productsOncart = dataLayer.getAllcartproductByName(cart_tk);

		for (Stm_site_cart_product p : productsOncart) {
			if (p.getProduct_id() == product_id) {
				product.setCart_tk(cart_tk);
				product.setSite_id(p.getSite_id());
				product.setOrder_qt(p.getOrder_qt() + 1);
				product.setProduct_id(p.getProduct_id());
				dataLayer.addQntProductOnCart(product);
				return;
			}

		}

		product.setCart_tk(cart_tk);
		product.setSite_id(sessionAcess.getSiteId());
		product.setOrder_qt(1);
		product.setProduct_id(product_id);
		dataLayer.setItemCart(product);
		
		
		Products productC = new Products();
		productC.getProduct(product_id);

		this.products.add(productC);

	}
	

	public void getCart(SessionAcess sessionAcess) {

		Datalayer dataLayer = new Datalayer();
		List<Stm_site_cart> carts = dataLayer.getAllCart();

	}

	public void addCart(String cart_tk, Integer product_id, int siteId) {
		// TODO Auto-generated method stub

	}

}
