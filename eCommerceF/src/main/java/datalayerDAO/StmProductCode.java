package datalayerDAO;

import java.util.List;

import classes.Stm_product_code;



public interface StmProductCode {

	
	void insert(Stm_product_code obj);
	void update(Stm_product_code obj);
	void deleteById(Integer id);
	Stm_product_code findById(Integer id);
	List<Stm_product_code>findAll();
	
}
