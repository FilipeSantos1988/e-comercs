package classes;

import java.util.List;

public class C_Products {

	private int id;
	private String name;
	private String desc;
	private int order_qt;
	private double value;
	private String urlImage;
	
	
	

	public C_Products(Stm_site_cart_product cart, Stm_product product, Stm_site_product_price price) {

		this.id = product.getProduct_id();
		this.name = product.getProducts_ds();
		this.desc = product.getProducts_ds();
		this.order_qt = cart.getOrder_qt();
		this.value = price.getPrice_vl();
		this.urlImage = product.getProduct_image_cd();

	}
	
	
	
	public C_Products(Stm_site_cart_product cartProduct, Stm_product product) 	{
		
		this.id = cartProduct.getProduct_id();
		this.name = product.getProducts_ds();
		this.desc = product.getProducts_ds();
		this.order_qt = cartProduct.getOrder_qt();
		this.urlImage = product.getProduct_image_cd();
		
	}
	
	

	public C_Products(int id, String name, String desc, String image) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.value = 0;
		this.urlImage = image;

	}

	public C_Products(int id, String name, String desc, double value) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.value = value;
	}

	public C_Products(int id, String name, String desc, double value, String image) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.value = value;
		this.urlImage = image;
	}



	public C_Products(Integer product_id, String products_ds, String product_st) {
		// TODO Auto-generated constructor stub
		this.id=product_id;
		this.name=products_ds;
		this.desc=products_ds;
	}



	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public int getId() {
		return id;
	}

	public int getStock() {
		return order_qt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "C_Products [name=" + name + ", desc=" + desc + ", value=" + value + "]";
	}

}
