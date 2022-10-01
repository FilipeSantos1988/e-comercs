package datalayerDAO;

import java.util.List;

import classes.Stm_site;




public interface StmSite {

	public void insert(Stm_site obj);
	public void update(Stm_site obj);
	public void deleteById(Integer id);
	public Stm_site findById(Integer id);
	public List<Stm_site>findAll();
	
}
