package classes;

import java.util.List;

public class C_cart {

	
	
	private float precoTotal;
	private String units;
	private List<C_Products>products=null;
	private float preco;
	private String url;
	
	
	public C_cart( ) {
		super();
		
		}
	
	
	
	
	public C_cart( float preco, List<C_Products> products) {
		super();
		precoTotal = 0;
		this.preco = preco;
		this.units = "Euros";
		this.products = products;
		
		if(products!=null) {
			for(C_Products p: products) {
				precoTotal+=p.getValue();
			}}
			else {
				precoTotal+=0 ;
			}
		}
	



	public float getPrecoTotal() {
		return precoTotal;
	}






	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}




	public float getPreco() {
		return preco;
	}



	public void setPreco(float preco) {
		this.preco = preco;
	}



	public String getUnits() {
		return units;
	}



	public void setUnits(String units) {
		this.units = units;
	}



	public List<C_Products> getProducts() {
		return products;
	}



	public void setProducts(List<C_Products> products) {
		
		if(products!=null) {
			for(C_Products p: products) {
				precoTotal+=p.getValue();
			}}
			else {
				precoTotal+=0 ;
			}
		
		this.products=products;
	}
	
	
	
	
	
	
	
	
	
	
	
}
