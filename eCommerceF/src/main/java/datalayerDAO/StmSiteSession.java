package datalayerDAO;

import java.util.List;

import classes.Stm_site_session;



public interface StmSiteSession {

	
	void insert(Stm_site_session obj);
	void update(Stm_site_session obj);
	void deleteById(Integer id);
	List<Stm_site_session>findById(Integer id);
	List<Stm_site_session>findAll();
	
	
}
