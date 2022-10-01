package datalayerDAO;

import java.util.List;

import classes.Stm_site_product;



public interface StmSiteProduct {
	
	
	void insert(Stm_site_product obj);
	void update(Stm_site_product obj);
	void deleteById(Integer id);
	Stm_site_product findById(Integer id);
	List<Stm_site_product>findAll();

}
