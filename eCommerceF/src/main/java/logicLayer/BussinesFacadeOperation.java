package logicLayer;

import java.util.ArrayList;
import java.util.List;

import classes.C_Products;
import classes.Stm_product;
import classes.Stm_site;
import classes.Stm_site_cart;
import classes.Stm_site_cart_product;
import classes.Stm_site_client;
import classes.Stm_site_product_price;
import classes.Stm_site_session;
import datalayer.Datalayer;

public class BussinesFacadeOperation {

	Cart cart = new Cart();
	Products product = new Products();
	List<Products> products = new ArrayList<Products>();
	productsList productsList = new productsList();
	CartsList cartsList = new CartsList();

	public List<Products> showProducts(String product_ds) {

		
		List<Products> products = new ArrayList<Products>();
		products = productsList.getProductsListByName(product_ds);
		
		return products;

	}
	
	public List<Products> showProducts(){
		List<Products> products = new ArrayList<Products>();
		products = productsList.getAllProducts();
		return products;
	}

	public List<Cart> showCarts(SessionAcess sessionAcess) {
		System.out.println("aqui ja cheguei3");
		List<Cart>carts= new ArrayList<Cart>();
		System.out.println("aqui ja cheguei4");
		carts = cartsList.getCart(sessionAcess);
		return carts;

	}

	public List<Products> showProductOnCart(SessionAcess sessionAcess) {
		

		return productsList.getProductOnCart(sessionAcess, cartTk);

	}

	public List<C_Products> Searchproducts() {

		Datalayer model = new Datalayer();
		List<C_Products> products = new ArrayList<C_Products>();
		List<Stm_product> productM = new ArrayList<Stm_product>();
		List<Stm_site_product_price> productP = new ArrayList<>();
		productM = model.getAllProducts();
		productP = model.getAllPrices();

		for (Stm_product p : productM) {
			for (Stm_site_product_price prices : productP) {
				if (p.getProduct_id() == prices.getProduct_id()) {
					C_Products productV = new C_Products(p.getProduct_id(), p.getProducts_ds(), p.getProduct_st(),
							prices.getPrice_vl());
					products.add(productV);
				} else {
					C_Products productV = new C_Products(p.getProduct_id(), p.getProducts_ds(), p.getProduct_st());
					products.add(productV);
				}
			}

		}

		return products;

	}

	/*
	 * public void showProducts(int cartId, long updateD, int siteId, int clientId)
	 * {
	 * 
	 * Datalayer dataLayer = new Datalayer(); updateClient("show Cart", updateD,
	 * siteId, clientId); Stm_site_cart cart = getCart(cartId); List<C_Products>
	 * productView = new ArrayList<C_Products>(); List<Stm_site_cart_product>
	 * cartProducts = new ArrayList<Stm_site_cart_product>(); List<Stm_product>
	 * products = dataLayer.getAllProducts(); List<Stm_site_product_price>
	 * productsPrice = dataLayer.getAllProductsPrice();
	 * 
	 * cartProducts = cart.getProducts();
	 * 
	 * for (int i = 0; i < cartProducts.size(); i++) { if
	 * (cartProducts.get(i).getProduct_id() == productsPrice.get(i).getProduct_id()
	 * && cartProducts.get(i).getProduct_id() == products.get(i).getProduct_id()) {
	 * C_Products productsView = new C_Products(cartProducts.get(i),
	 * products.get(i), productsPrice.get(i)); productView.add(productsView);
	 * 
	 * } else if (cartProducts.get(i).getProduct_id() ==
	 * products.get(i).getProduct_id()) { C_Products productsView = new
	 * C_Products(cartProducts.get(i), products.get(i));
	 * productView.add(productsView); } else { ; }
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	/*
	 * public void showCartsProducts(SessionAcess sessioAcess,int site_id,Cart cart)
	 * {
	 * 
	 * 
	 * List<CartProducts>cartProducts= new ArrayList<CartProducts>(); cartProducts=
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}
