package logicLayer;

import java.util.ArrayList;
import java.util.List;

import classes.Stm_product;
import classes.Stm_site_cart_product;
import classes.Stm_site_product_price;
import datalayer.Datalayer;

public class productsList {

	List<Products> products = new ArrayList<Products>();

	public List<Products> getProductsListByName(String product_ds) {

		Datalayer dataLayer = new Datalayer();
		List<Stm_product> product = new ArrayList<Stm_product>();
		Stm_site_product_price productPrice =  new Stm_site_product_price();
		product = dataLayer.getProductByName(product_ds);

		
		for (Stm_product prod : product) {
			
			productPrice = dataLayer.getProductPriceByproductId(prod.getProduct_id());
			
			
			
			
			if (productPrice.getPrice_vl() == 0 && prod.getProduct_image_cd() != null) {
				products.add(new Products(prod.getProducts_ds(), prod.getProduct_image_cd()));
			} else if (prod.getProduct_image_cd() == null && productPrice.getPrice_vl() != 0) {
				products.add(new Products(prod.getProducts_ds(), productPrice.getPrice_vl()));
			} else if (productPrice.getPrice_vl() == 0 && prod.getProduct_image_cd() == null) {
				products.add(new Products(prod.getProducts_ds()));
			} else {
				products.add(new Products(prod.getProducts_ds(), productPrice.getPrice_vl(), prod.getProduct_image_cd()));
						
				
			}
		}
		
		return products;

	}

	// criar esta funcao e associar a de baixo
	public Products getProductById(Integer product_id) {

		Datalayer dataLayer = new Datalayer();
		Stm_product product = new Stm_product();
		Stm_site_product_price productPrice = new Stm_site_product_price();
		product = dataLayer.getProductById(product_id);
		productPrice = dataLayer.getProductPriceByproductId(product.getProduct_id());
		Products products = null;

		if (productPrice == null) {
			products = new Products(product.getProducts_ds(), product.getProduct_image_cd());
		} else if (product.getProduct_image_cd() == null) {
			products = new Products(product.getProducts_ds(), productPrice.getPrice_vl());
		} else if (productPrice == null && product.getProduct_image_cd() == null) {
			products = new Products(product.getProducts_ds());
		} else {
			products = new Products(product.getProducts_ds(), productPrice.getPrice_vl(),
					product.getProduct_image_cd());
		}

		return products;

	}

	public List<Products> getProductOnCart(SessionAcess sessionAcess, String cartTk) {

		Datalayer dataLayer = new Datalayer();
		List<Stm_site_cart_product> products = new ArrayList<Stm_site_cart_product>();
		products = dataLayer.getByCartName(cartTk);
		List<Products> productsOnCart = new ArrayList<Products>();

		for (Stm_site_cart_product prod : products) {
			Products productOnCart = new Products();
			productOnCart.getProduct(prod.getProduct_id());
			productsOnCart.add(productOnCart);

		}
		return productsOnCart;

	}
	

	public void onCart(SessionAcess sessionAcess, String cartTk) {
		
		
		
	}

}
