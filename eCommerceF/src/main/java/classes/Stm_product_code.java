package classes;

import java.io.Serializable;
import java.util.Objects;

public class Stm_product_code implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private Integer product_id;
	private String product_code_cd;
	private String product_code_tp;
	private String product_code_jd;
	
	
	
	
	
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
		Stm_product_code other = (Stm_product_code) obj;
		return Objects.equals(product_id, other.product_id);
	}


	public Stm_product_code() {
		super();
	}
	
	
	public Stm_product_code(Integer product_id, String product_code_cd, String product_code_tp,
			String product_code_jd) {
		super();
		this.product_id = product_id;
		this.product_code_cd = product_code_cd;
		this.product_code_tp = product_code_tp;
		this.product_code_jd = product_code_jd;
	}
	
	
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_code_cd() {
		return product_code_cd;
	}
	public void setProduct_code_cd(String product_code_cd) {
		this.product_code_cd = product_code_cd;
	}
	public String getProduct_code_tp() {
		return product_code_tp;
	}
	public void setProduct_code_tp(String product_code_tp) {
		this.product_code_tp = product_code_tp;
	}
	public String getProduct_code_jd() {
		return product_code_jd;
	}
	public void setProduct_code_jd(String product_code_jd) {
		this.product_code_jd = product_code_jd;
	}


	@Override
	public String toString() {
		return "Stm_product_code [product_id=" + product_id + ", product_code_cd=" + product_code_cd
				+ ", product_code_tp=" + product_code_tp + ", product_code_jd=" + product_code_jd + "]";
	}

	
	
}
