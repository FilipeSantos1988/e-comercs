package classes;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Stm_site_product_price implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer site_id;
	private Integer product_id;
	private String currency_cd;
	private Date start_dt;
	private float price_vl;
	private String price_st;
	
	
	
	

	
	public Stm_site_product_price() {
		super();
	}



	public Stm_site_product_price(Integer site_id, Integer product_id, String currency_cd, Date start_dt,
			float price_vl, String price_st) {
		super();
		this.site_id = site_id;
		this.product_id = product_id;
		this.currency_cd = currency_cd;
		this.start_dt = start_dt;
		this.price_vl = price_vl;
		this.price_st = price_st;
	}



	public Integer getSite_id() {
		return site_id;
	}



	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}



	public Integer getProduct_id() {
		return product_id;
	}



	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}



	public String getCurrency_cd() {
		return currency_cd;
	}



	public void setCurrency_cd(String currency_cd) {
		this.currency_cd = currency_cd;
	}



	public Date getStart_dt() {
		return start_dt;
	}



	public void setStart_dt(Date start_dt) {
		this.start_dt = start_dt;
	}



	public float getPrice_vl() {
		return price_vl;
	}



	public void setPrice_vl(float price_vl) {
		this.price_vl = price_vl;
	}



	public String getPrice_st() {
		return price_st;
	}



	public void setPrice_st(String price_st) {
		this.price_st = price_st;
	}


	
	

	@Override
	public int hashCode() {
		return Objects.hash(product_id, site_id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stm_site_product_price other = (Stm_site_product_price) obj;
		return Objects.equals(product_id, other.product_id) && Objects.equals(site_id, other.site_id);
	}



	@Override
	public String toString() {
		return "Stm_site_product_price [site_id=" + site_id + ", product_id=" + product_id + ", currency_cd="
				+ currency_cd + ", start_dt=" + start_dt + ", price_vl=" + price_vl + ", price_st=" + price_st + "]";
	}
	
	
	
	
	
	
	
	
}
