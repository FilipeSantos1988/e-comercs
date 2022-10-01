package datalayerDAO;

import java.util.List;

import classes.Stm_site_client_order;


public interface StmSiteClientOrder {

	
	void insert(Stm_site_client_order obj);
	void update(Stm_site_client_order obj);
	void deleteById(Integer id);
	Stm_site_client_order findById(Integer id);
	List<Stm_site_client_order>findAll();
}
