package datalayerDAO;

import java.util.List;

import classes.Stm_site_product_price;



public interface StmSiteProductPrice {

	
	void insert(Stm_site_product_price obj);
	void update(Stm_site_product_price obj);
	void deleteById(Integer id);
	Stm_site_product_price findById(Integer id);
	List<Stm_site_product_price>findAll();
	
}
