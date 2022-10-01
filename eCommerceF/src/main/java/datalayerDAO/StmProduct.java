package datalayerDAO;

import java.util.List;

import classes.Stm_product;


public interface StmProduct {

	
	void insert(Stm_product obj);
	void update(Stm_product obj);
	void deleteById(Integer id);
	Stm_product findById(Integer id);
	List<Stm_product>findAll();
	
}
