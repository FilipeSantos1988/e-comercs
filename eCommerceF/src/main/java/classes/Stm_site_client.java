package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stm_site_client implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Integer site_id;
	private Integer client_id;
	private String client_ds;
	private List<Stm_site_session> sessions = null;
	
	
	
	
	
	public Stm_site_client() {
		super();
	}


	public Stm_site_client(Integer site_id, Integer client_id, String client_ds) {
		super();
		this.site_id = site_id;
		this.client_id = client_id;
		this.client_ds = client_ds;
		this.sessions= new ArrayList<Stm_site_session>();
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


	public String getClient_ds() {
		return client_ds;
	}


	public void setClient_ds(String client_ds) {
		this.client_ds = client_ds;
	}
	
	
	


	public List<Stm_site_session> getSessions() {
		return sessions;
	}


	public void setSessions(List<Stm_site_session> sessions) {
		this.sessions = sessions;
	}


	@Override
	public int hashCode() {
		return Objects.hash(client_id, site_id);
	}

	
	
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stm_site_client other = (Stm_site_client) obj;
		return Objects.equals(client_id, other.client_id) && Objects.equals(site_id, other.site_id);
	}


	@Override
	public String toString() {
		return "Stm_site_client [site_id=" + site_id + ", client_id=" + client_id + ", client_ds=" + client_ds + "]";
	}
	
	
		
	
	
	
	

}
