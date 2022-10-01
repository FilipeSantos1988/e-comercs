package logicLayer;

import java.util.ArrayList;
import java.util.List;

import classes.Stm_site_cart;
import classes.Stm_site_cart_product;
import datalayer.Datalayer;

public class CartsList {

	
	
	List<Cart>carts = new ArrayList <Cart>();
	
	
	
	
		
		
		
		
	
	
	
	public void getCart(SessionAcess sessionAcess) {

		Datalayer dataLayer = new Datalayer();
		List<Stm_site_cart> cartS = dataLayer.getClientCarts(sessionAcess.getClientId(),sessionAcess.getSessionId());
		
		for(Stm_site_cart cart: cartS) {
			carts.add(new Cart(cart.getCart_tk()));
		}
		
		
		
		
	}
		
	
}
