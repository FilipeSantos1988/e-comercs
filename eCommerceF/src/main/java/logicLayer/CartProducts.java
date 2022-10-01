package logicLayer;

import datalayer.Datalayer;

import java.util.ArrayList;
import java.util.List;

import classes.Stm_site_cart;
import classes.Stm_site_cart_product;

public class CartProducts {

	Datalayer dataLayer = new Datalayer();
	String units_tp = "Eur";

//primeiro tenho de deletar os productos dentro do carro
	public void deleteCart(Stm_site_cart cart) {

		List<Stm_site_cart_product> cartProducts = new ArrayList<Stm_site_cart_product>();
		cartProducts = cart.getProducts();

		for (Stm_site_cart_product p : cartProducts) {

		}

	}

	public List<Stm_site_cart_product> getCartproducts(Stm_site_cart cart) {

		List<Stm_site_cart_product> cartproducts = new ArrayList<Stm_site_cart_product>();

		return cartproducts = dataLayer.getAllcartproductByName(cart.getCart_tk());

	}

	public void removeProductByName(String cartTk, int productId) {

		dataLayer.removeProductCart(cartTk, productId);

	}

	public boolean chekCart(String cartTk) {

		return false;
	}
	
	

	public void addProduct(int siteId, String cartTk, int productId) {
		
		List<Stm_site_cart_product> productsOnCart = new ArrayList<Stm_site_cart_product>();
		productsOnCart = dataLayer.getAllcartproductByName(cartTk);
		Stm_site_cart_product newProduct = null;
		
		for(Stm_site_cart_product productOnCart : productsOnCart) {
			if(productOnCart.getProduct_id() == productId) {
				productOnCart.setOrder_qt(productOnCart.getOrder_qt()+1);
				dataLayer.addExistentProduct(productOnCart); 
				return;
			}}
			
			newProduct.setCart_tk(cartTk);
			newProduct.setSite_id(null);
			newProduct.setProduct_id(null);
			newProduct.setOrder_qt(null);
			newProduct.setUnits_tp(units_tp);
		
		
			dataLayer.setItemCart(newProduct);
		}

	}





