package logicLayer;



import java.util.ArrayList;
import java.util.List;
import classes.C_Products;
import classes.C_cart;
import classes.Stm_product;
import classes.Stm_site;
import classes.Stm_site_cart;
import classes.Stm_site_cart_product;
import classes.Stm_site_client;
import classes.Stm_site_product;
import classes.Stm_site_product_price;
import classes.Stm_site_session;
import datalayer.Datalayer;
import java.sql.Date;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class LogicLayer {

	
	BussinesFacadeTransiction bft = new BussinesFacadeTransiction();
	SessionAcess sessionAcess = new SessionAcess();

	public LogicLayer() {

		
		
		
	}

	
	
	public SessionAcess createSession(String sessionTk) {
		
		System.out.println("Esqou aqui1");
	sessionAcess = bft.createAcess(sessionTk);
	return sessionAcess;
		
	}
	
	
	

	public void chekSession(String sessionTk){
		
		
		
	}
	
	
	
	public void addCart(SessionAcess sessionAcess,String cartTk) {
		
		
		
	}

	
	public void removeCart(SessionAcess sessionAcess,String cartTk) {
	
	
		
	}

	
	
	
	
	
	public void addCartProduct(SessionAcess sessionAcess,int productId) {
		
		
		try {
			bft.addProductToCart(sessionAcess, productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void removeCartProduct(SessionAcess sessionAcess,String cartTk,int productId) {
		
	
		
		
	}
	
	
	
	
	public void buyCart(SessionAcess sessionAcess,String cartTk) {
		
		
		
		
	}
	
	
	
	


	
	
	
	
	
	
	

	

	
	
	
	
	
	
	
	

	





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public List<C_Products> Searchproducts(String name) {

		Datalayer model = new Datalayer();
		List<C_Products> products = new ArrayList<C_Products>();
		List<Stm_product> productM = new ArrayList<>();
		List<Stm_site_product_price> productP = new ArrayList<>();
		productM = model.getAllProducts();
		productP = model.getAllPrices();

		if (name.isBlank()) {

			products = Searchproducts();
		} else {
			for (Stm_product p : productM) {
				if (p.getProducts_ds().equals(name)) {
					for (Stm_site_product_price prices : productP) {
						if (p.getProduct_id() == prices.getProduct_id()) {
							C_Products productV = new C_Products(p.getProduct_id(), p.getProducts_ds(),
									p.getProduct_st(), prices.getPrice_vl(), p.getProduct_image_cd());
							products.add(productV);
						} else {
							C_Products productV = new C_Products(p.getProduct_id(), p.getProducts_ds(),
									p.getProduct_st(), p.getProduct_image_cd());
							products.add(productV);
						}
					}

				}
			}

		}

		return products;

	}

	

}*/

	
	
	
	
	
	
}
	


