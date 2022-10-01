package classes;

import java.io.Serializable;
import java.util.Objects;

public class Stm_site implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer site_id;
	private String site_ds;
	private String site_tp;
	private String site_st;
	private String site_jd;
	
	
	
	
	public Stm_site() {
		super();
	}
	

	public Stm_site(Integer site_id, String site_ds, String site_tp, String site_st, String site_jd) {
		super();
		this.site_id = site_id;
		this.site_ds = site_ds;
		this.site_tp = site_tp;
		this.site_st = site_st;
		this.site_jd = site_jd;
	}


	
	
	




	public Integer getSite_id() {
		return site_id;
	}




	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}




	public String getSite_ds() {
		return site_ds;
	}




	public void setSite_ds(String site_ds) {
		this.site_ds = site_ds;
	}




	public String getSite_tp() {
		return site_tp;
	}




	public void setSite_tp(String site_tp) {
		this.site_tp = site_tp;
	}




	public String getSite_st() {
		return site_st;
	}




	public void setSite_st(String site_st) {
		this.site_st = site_st;
	}




	public String getSite_jd() {
		return site_jd;
	}




	public void setSite_jd(String site_jd) {
		this.site_jd = site_jd;
	}


	@Override
	public int hashCode() {
		return Objects.hash(site_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stm_site other = (Stm_site) obj;
		return Objects.equals(site_id, other.site_id);
	}


	@Override
	public String toString() {
		return "Stm_site [site_id=" + site_id + ", site_ds=" + site_ds + ", site_tp=" + site_tp + ", site_st=" + site_st
				+ ", site_jd=" + site_jd + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
