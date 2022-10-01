package classes;

import java.io.Serializable;
import java.util.Objects;

public class Stm_site_client_order implements Serializable {
	
	
	
	
	private static final long serialVersionUID = 1L;
	private Integer order_id;
	private Integer site_id;
	private Integer client_id;
	private String order_jd;
	
	
	
	
	
	public Stm_site_client_order() {
		super();
	}





	public Stm_site_client_order(Integer order_id, Integer site_id, Integer client_id, String order_jd) {
		super();
		this.order_id = order_id;
		this.site_id = site_id;
		this.client_id = client_id;
		this.order_jd = order_jd;
	}





	public Integer getOrder_id() {
		return order_id;
	}





	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}





	public Integer getSite_id() {
		return site_id;
	}





	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}





	public Integer getClient_id() {
		return client_id;
	}





	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}





	public String getOrder_jd() {
		return order_jd;
	}





	public void setOrder_jd(String order_jd) {
		this.order_jd = order_jd;
	}



	
	
	
	


	@Override
	public int hashCode() {
		return Objects.hash(client_id, order_id, site_id);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stm_site_client_order other = (Stm_site_client_order) obj;
		return Objects.equals(client_id, other.client_id) && Objects.equals(order_id, other.order_id)
				&& Objects.equals(site_id, other.site_id);
	}





	
	
	
	@Override
	public String toString() {
		return "Stm_site_client_order [order_id=" + order_id + ", site_id=" + site_id + ", client_id=" + client_id
				+ ", order_jd=" + order_jd + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
