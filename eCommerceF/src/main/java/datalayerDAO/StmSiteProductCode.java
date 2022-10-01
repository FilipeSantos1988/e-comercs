package datalayerDAO;

import java.util.List;

import classes.Stm_site_product_code;


public interface StmSiteProductCode {

	
	void insert(Stm_site_product_code obj);
	void update(Stm_site_product_code obj);
	void deleteById(Integer id);
	Stm_site_product_code findById(Integer id);
	List<Stm_site_product_code>findAll();
	
}
