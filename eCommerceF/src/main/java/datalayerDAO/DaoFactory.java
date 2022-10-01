package datalayerDAO;


import dbDAO.Stm_productDAO;
import dbDAO.Stm_product_codeDAO;
import dbDAO.Stm_siteDAO;
import dbDAO.Stm_site_cartDAO;
import dbDAO.Stm_site_cart_productDAO;
import dbDAO.Stm_site_clientDAO;
import dbDAO.Stm_site_client_orderDAO;
import dbDAO.Stm_site_productDAO;
import dbDAO.Stm_site_product_priceDAO;
import dbDAO.Stm_site_sessionDAO;

public class DaoFactory {

	
	public static StmProductCode createProductCode() {
		return new Stm_product_codeDAO();
	}
	
	
	public static StmProduct createStmProduct() {
		return new Stm_productDAO();
	}
	
	
	public static StmSite createStmSite() {
		return new Stm_siteDAO();
	}
	
	
	
	public static StmSiteCart createStmSiteCart() {
		return new Stm_site_cartDAO();
	}
	
	
	public static StmSiteCartProduct createStmSiteCartProduct() {
		return new Stm_site_cart_productDAO();
	}
	
	
	public static StmSiteClient createStmSiteClient() {
		return new Stm_site_clientDAO();
	}
	
	
	public static StmSiteClientOrder createStmSiteClientOrder() {
		return new Stm_site_client_orderDAO();
	}
	
	
	
	public static StmSiteProduct createSStmSiteProduct() {
		return new Stm_site_productDAO();
	}
	
	
	public static StmProductCode createStmProductCode() {
		return new Stm_product_codeDAO();
	}
	
	
	
	public static StmSiteProductPrice createStmSiteProductPrice() {
		return new Stm_site_product_priceDAO();
	}
	
	
	
	public static StmSiteSession createStmSiteSession() {
		return new Stm_site_sessionDAO();
	}
	
}
