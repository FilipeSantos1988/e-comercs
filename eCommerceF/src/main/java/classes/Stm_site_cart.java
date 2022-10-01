package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stm_site_cart implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer site_id;
	private String cart_tk;
	private String session_tk;
	private Integer client_id;
	private List<Integer> fk_site_session;
	private List<Integer> fk_site_cliente;
	private List<Stm_site_cart_product> products = new ArrayList<Stm_site_cart_product>();

	public Stm_site_cart(Integer site_id, String cart_tk, String session_tk, Integer client_id,
			List<Integer> fk_site_session, List<Integer> fk_site_cliente) {
		super();
		this.site_id = site_id;
		this.cart_tk = cart_tk;
		this.session_tk = session_tk;
		this.client_id = client_id;
		this.fk_site_session = fk_site_session;
		this.fk_site_cliente = fk_site_cliente;
	}

	public Stm_site_cart() {
		super();
	}

	public List<Integer> getFk_site_session() {
		return fk_site_session;
	}

	public void setFk_site_session(List<Integer> fk_site_session) {
		this.fk_site_session = fk_site_session;
	}

	public List<Integer> getFk_site_cliente() {
		return fk_site_cliente;
	}

	public void setFk_site_cliente(List<Integer> fk_site_cliente) {
		this.fk_site_cliente = fk_site_cliente;
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

	public String getSession_tk() {
		return session_tk;
	}

	public void setSession_tk(String session_tk) {
		this.session_tk = session_tk;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public List<Stm_site_cart_product> getProducts() {
		return products;
	}

	public void setProducts(List<Stm_site_cart_product> products) {
		this.products = products;
	}

	
	
	
	

	public void addItem(int siteId,String cartName,Stm_site_cart_product cartProduct) {

		for (Stm_site_cart_product p : products) {
			if (p.getProduct_id() == cartProduct.getProduct_id()) {
				p.setOrder_qt(p.getOrder_qt() + 1);
				return;
			} else {
				cartProduct.setCart_tk(cartName);
				cartProduct.setSite_id(siteId);
				cartProduct.setOrder_qt(1);
				products.add(cartProduct);

			}

		}

	}

	// implementar
	public void removeProdut(Stm_site_cart_product product) {

		int remove = 0;

		for (Stm_site_cart_product p : products) {
			if (p.getProduct_id() == product.getProduct_id()) {
				p.setOrder_qt(p.getOrder_qt() - 1);
				if (p.getOrder_qt() == 0) {
					products.remove(p);
				}
				return;
			} else {
				products.add(product);
				return;

			}

		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(client_id, fk_site_cliente, fk_site_session, site_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stm_site_cart other = (Stm_site_cart) obj;
		return Objects.equals(client_id, other.client_id) && Objects.equals(fk_site_cliente, other.fk_site_cliente)
				&& Objects.equals(fk_site_session, other.fk_site_session) && Objects.equals(site_id, other.site_id);
	}

	@Override
	public String toString() {
		return "Stm_site_cart [site_id=" + site_id + ", cart_tk=" + cart_tk + ", session_tk=" + session_tk
				+ ", client_id=" + client_id + "]";
	}

	

}
