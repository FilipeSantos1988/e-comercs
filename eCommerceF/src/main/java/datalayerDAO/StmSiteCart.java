package datalayerDAO;

import java.util.List;

import classes.Stm_site_cart;



public interface StmSiteCart {

	void insert(Stm_site_cart obj);
	void update(Stm_site_cart obj);
	void deleteById(Integer id);
	Stm_site_cart findById(Integer id);
	List<Stm_site_cart>findAll();
	
	
}
