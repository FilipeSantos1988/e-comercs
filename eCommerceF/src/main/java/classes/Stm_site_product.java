package classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Stm_site_product implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer site_id;
	private Integer product_id;
	private List<Integer> fk_product;
	
	
	
	
	
	
	public Stm_site_product() {
		super();
	}


	public Stm_site_product(Integer site_id, Integer product_id) {
		super();
		this.site_id = site_id;
		this.product_id = product_id;
	}

	
	
	

	public List<Integer> getFk_product() {
		return fk_product;
	}


	public void setFk_product(List<Integer> fk_product) {
		this.fk_product = fk_product;
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


	@Override
	public int hashCode() {
		return Objects.hash(fk_product, product_id, site_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stm_site_product other = (Stm_site_product) obj;
		return Objects.equals(fk_product, other.fk_product) && Objects.equals(product_id, other.product_id)
				&& Objects.equals(site_id, other.site_id);
	}


	@Override
	public String toString() {
		return "Stm_site_product [site_id=" + site_id + ", product_id=" + product_id + ", fk_product=" + fk_product
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
