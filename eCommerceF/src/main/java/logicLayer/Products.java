package logicLayer;

import java.util.ArrayList;
import java.util.List;

import classes.Stm_product;
import classes.Stm_site_cart_product;
import classes.Stm_site_product_price;
import datalayer.Datalayer;

public class Products {
	
	
	int product_id;
	String product_ds;
	double price_vl;
	String productImg;
	
	
	

	public Products() {
		;
	}
	
	
	
	
	public Products(int productId,String product_ds,double price_vl,String productImg) {
		this.product_id = productId;
		this.product_ds = product_ds;
		this.price_vl = price_vl;
		this.productImg = productImg;
	}

	public Products(int productId,String products_ds, String product_image_cd) {
		this.product_id = productId;
		this.product_ds = products_ds;
		this.productImg = product_image_cd;
	}

	public Products(int productId,String products_ds, double price_vl) {
		this.product_id = productId;
		this.product_ds = products_ds;
		this.price_vl = price_vl;
		
	}

	public Products(String products_ds) {
		this.product_ds = products_ds;
		
	}

	public void getProduct(int product_id) {

		Datalayer dataLayer = new Datalayer();
		Stm_product product = new Stm_product();
		Stm_site_product_price productPrice = new Stm_site_product_price();
		product = dataLayer.getProductById(product_id);
		productPrice =dataLayer.getProductPriceBYProductId(product_id);
		this.product_ds = product.getProducts_ds();
		this.price_vl = productPrice.getPrice_vl();
		this.productImg = product.getProduct_image_cd();
		

	}
	
	public void getProductByName(String product_ds) {
		
		
		
	}
	
	
	
	
	

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_ds() {
		return product_ds;
	}

	public void setProduct_ds(String product_ds) {
		this.product_ds = product_ds;
	}

	public double getPrice_vl() {
		return price_vl;
	}

	public void setPrice_vl(double price_vl) {
		this.price_vl = price_vl;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public Boolean getProduct(int productId, Stm_product product) {

		Datalayer dataLayer = new Datalayer();
		product = dataLayer.getProductById(productId);

		return checkProduct(product);

	}

	public Boolean checkProduct(Stm_product product) {

		if (product != null) {
			return true;
		}
		return false;
	}
	
	
	public void getProductPrice() {
		
		Stm_site_product_price price;
		Datalayer dataLayer = new Datalayer();
		price= dataLayer.getProductPriceBYProductId(product_id);	
		price_vl=price.getPrice_vl();
	}


	
public void removeProducts(int productId) {
		
		Datalayer dataLayer = new Datalayer();
		//se remover da loja tenho de remover do cart
		dataLayer.removeProduct(productId);
		
	}
		
}
