package datalayerDAO;

import java.util.List;

import classes.Stm_site_cart_product;



public interface StmSiteCartProduct {

	
	void insert(Stm_site_cart_product obj);
	void update(Stm_site_cart_product obj);
	void deleteById(Integer id);
	Stm_site_cart_product findById(Integer id);
	List<Stm_site_cart_product>findAll();

	
}
