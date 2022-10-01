package classes;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;



public class Stm_site_session implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Integer site_id;
	private String session_tk;
	private Integer client_id;
	private Date created_dt;
	private Date updated_dt; 
	private List<Integer> fk_site_client;
	
	
	
	
	
	
	public Stm_site_session() {
		super();
	}


	public Stm_site_session(Integer site_id, String session_tk, Integer client_id, Date created_dt, Date updated_dt
			/*List<Integer> fk_site_client*/) {
		super();
		this.site_id = site_id;
		this.session_tk = session_tk;
		this.client_id = client_id;
		this.created_dt = created_dt;
		this.updated_dt = updated_dt;
		this.fk_site_client = fk_site_client;
	}


	public Integer getSite_id() {
		return site_id;
	}


	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
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


	public Date getCreated_dt() {
		return created_dt;
	}


	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}


	public Date getUpdated_dt() {
		return updated_dt;
	}


	public void setUpdated_dt(Date updated_dt) {
		this.updated_dt = updated_dt;
	}


	public List<Integer> getFk_site_client() {
		return fk_site_client;
	}


	public void setFk_site_client(List<Integer> fk_site_client) {
		this.fk_site_client = fk_site_client;
	}


	@Override
	public int hashCode() {
		return Objects.hash(client_id, fk_site_client, site_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stm_site_session other = (Stm_site_session) obj;
		return Objects.equals(client_id, other.client_id) && Objects.equals(fk_site_client, other.fk_site_client)
				&& Objects.equals(site_id, other.site_id);
	}


	
	
	
	
	
	
	@Override
	public String toString() {
		return "Stm_site_session [site_id=" + site_id + ", session_tk=" + session_tk + ", client_id=" + client_id
				+ ", created_dt=" + created_dt + ", updated_dt=" + updated_dt + ", fk_site_client=" + fk_site_client
				+ "]";
	}
	
	
	
	
	
	

	
	
	

}
