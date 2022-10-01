package classes;

import java.io.Serializable;
import java.util.Objects;



public class Stm_product implements Serializable  {

	private static final long serialVersionUID = 1L;
	private Integer product_id;
	private String products_ds;
	private String product_st;
	private String product_jd;
	private String product_image_cd;
	
	
	
	
	public Stm_product() {
		super();
	}
	
	
	public Stm_product(Integer product_id, String products_ds, String product_st, String product_jd,
			String product_image_cd) {
		super();
		this.product_id = product_id;
		this.products_ds = products_ds;
		this.product_st = product_st;
		this.product_jd = product_jd;
		this.product_image_cd = product_image_cd;
	}


	

	public Integer getProduct_id() {
		return product_id;
	}


	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}


	


	public String getProducts_ds() {
		return products_ds;
	}


	public void setProducts_ds(String products_ds) {
		this.products_ds = products_ds;
	}


	public String getProduct_st() {
		return product_st;
	}


	public void setProduct_st(String product_st) {
		this.product_st = product_st;
	}


	public String getProduct_jd() {
		return product_jd;
	}


	public void setProduct_jd(String product_jd) {
		this.product_jd = product_jd;
	}


	public String getProduct_image_cd() {
		return product_image_cd;
	}


	public void setProduct_image_cd(String product_image_cd) {
		this.product_image_cd = product_image_cd;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(product_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stm_product other = (Stm_product) obj;
		return Objects.equals(product_id, other.product_id);
	}


	@Override
	public String toString() {
		return "Stm_product [product_id=" + product_id + ", products_ds=" + products_ds + ", product_st=" + product_st
				+ ", product_jd=" + product_jd + ", product_image_cd=" + product_image_cd + "]";
	}
	
	
}
