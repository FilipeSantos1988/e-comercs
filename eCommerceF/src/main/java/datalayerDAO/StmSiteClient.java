package datalayerDAO;

import java.util.List;

import classes.Stm_site_client;


public interface StmSiteClient {

	void insert(Stm_site_client obj);
	void update(Stm_site_client obj);
	void deleteById(Integer id);
	Stm_site_client findById(Integer id);
	List<Stm_site_client>findAll();
	
}
