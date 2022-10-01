package classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Stm_site_cart_product implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private Integer site_id;
	private String cart_tk;
	private Integer product_id;
	private Integer order_qt;
	private String units_tp;
	private List<Integer> fk_site_product;
	
	
	
	
	
	public Stm_site_cart_product() {
		super();
	}



	public Stm_site_cart_product(Integer site_id, String cart_tk, Integer product_id, Integer order_qt, String units_tp,
			List<Integer> fk_site_product) {
		super();
		this.site_id = site_id;
		this.cart_tk = cart_tk;
		this.product_id = product_id;
		this.order_qt = order_qt;
		this.units_tp = units_tp;
		this.fk_site_product = fk_site_product;
	}


	
	

	public Stm_site_cart_product(Stm_product product) {
		this.product_id=product.getProduct_id();
	}



	public List<Integer> getFk_site_product() {
		return fk_site_product;
	}



	public void setFk_site_product(List<Integer> fk_site_product) {
		this.fk_site_product = fk_site_product;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Integer getSite_id() {
		return site_id;
	}



	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}



	public String getCart_tk() {
		return cart_tk;
	}



	public void setCart_tk(String cart_tk) {
		this.cart_tk = cart_tk;
	}



	public Integer getProduct_id() {
		return product_id;
	}



	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}



	public Integer getOrder_qt() {
		return order_qt;
	}



	public void setOrder_qt(Integer order_qt) {
		this.order_qt = order_qt;
	}



	public String getUnits_tp() {
		return units_tp;
	}



	public void setUnits_tp(String units_tp) {
		this.units_tp = units_tp;
	}
	
	
	
	
	
	
	
	


	@Override
	public int hashCode() {
		return Objects.hash(fk_site_product, product_id, site_id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stm_site_cart_product other = (Stm_site_cart_product) obj;
		return Objects.equals(fk_site_product, other.fk_site_product) && Objects.equals(product_id, other.product_id)
				&& Objects.equals(site_id, other.site_id);
	}



	
	
	
	
	
	public String toString() {
		return "Stm_site_cart_product [site_id=" + site_id + ", cart_tk=" + cart_tk + ", product_id=" + product_id
				+ ", order_qt=" + order_qt + ", units_tp=" + units_tp + "]";
	}

	
	
	

}
