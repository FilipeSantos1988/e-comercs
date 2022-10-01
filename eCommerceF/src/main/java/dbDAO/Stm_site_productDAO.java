package dbDAO;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import classes.Stm_site_product;
import datalayer.ConnectionDB;
import datalayerDAO.StmSiteProduct;

public class Stm_site_productDAO implements StmSiteProduct {

	
	
	private ConnectionDB connection;
	private Connection connect;
	
	
	
	public Stm_site_productDAO() {
		this.connection= new ConnectionDB();
		this.connect =connection.getConnection();
	}

	
	
	
	@Override
	public void insert(Stm_site_product obj) {
		// TODO Auto-generated method stub
		PreparedStatement st=null;
		String mysql="INSERT INTO stm_site_product (site_id,product_id)VALUES(?,?);";
		try {
			st=connect.prepareStatement(mysql,Statement.RETURN_GENERATED_KEYS);
			st.setObject(1,BigInteger.valueOf(obj.getSite_id()),Types.BIGINT);
			st.setObject(1,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
			int rowsAffected=st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs= st.getGeneratedKeys();
				
				if(rs.next()) {
					int id1=rs.getInt(1);
					int id2=rs.getInt(2);
					obj.setSite_id(id1);
					obj.setProduct_id(id2);
					}	
			}
			else {
				throw new DbException("Unexpeted erroor! no rows affected");
			}
		}
			catch(SQLException error) {
				throw new DbException(error.getMessage());
			}
			finally{
				ConnectionDB.closeStatment(st);
			}
		
	}
	
	
	
	
	
	

	@Override
	public void update(Stm_site_product obj) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		PreparedStatement st=null;
		String sql="update stm_site_product set product_id=?, site_id =? where product_id= ? or site_id=?;";

		try {
		st=connect.prepareStatement(sql);
		
		/*buscar o valor do meu objecto e colocalo no no statment*/
		st.setObject(1,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
		st.setObject(2,BigInteger.valueOf(obj.getSite_id()),Types.BIGINT);
		st.setObject(3,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
		st.setObject(4,BigInteger.valueOf(obj.getSite_id()),Types.BIGINT);
		st.executeUpdate();
	
		
		
	}
		catch(SQLException error) {
			throw new DbException(error.getMessage());
		}
		finally{
			ConnectionDB.closeStatment(st);
		}
	}
		
		
	
	
	
	

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		String sql="Delete from stm_site_product where product_id=?";
		PreparedStatement st=null;
		try {
			st=this.connect.prepareStatement(sql);
			st.setInt(1,id);
			st.execute();
		}catch(Exception error) {
	    	 System.out.println("Erro ao inserir curso"+error.getMessage());
		}
		}
		
	
	
	

	@Override
	public Stm_site_product findById(Integer id) {
		String sql ="SELECT * FROM stm_site_product WHERE product_id = ?";
		ResultSet rs;
		PreparedStatement st=null;
		try {
			st= this.connect.prepareStatement(sql);
			st.setObject(1,BigInteger.valueOf(id),Types.BIGINT);
			rs = st.executeQuery();
			rs.next();
			Stm_site_product product =new Stm_site_product();
			product.setProduct_id(id);
			product.setSite_id(rs.getInt("site_id"));
			
			
			
			return product;
			
		} catch(SQLException error) {
			throw new DbException(error.getMessage());
		}finally {
			ConnectionDB.closeStatment(st);
		}

	}
	
	
	

	@Override
	public List<Stm_site_product> findAll() {
		// TODO Auto-generated method stub
		List<Stm_site_product> productList = new ArrayList<Stm_site_product>();
		String sql ="SELECT * FROM stm_site_product";
		ResultSet rs=null;
		PreparedStatement st=null;
		
		try {
			
			st= this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
			Stm_site_product product =new Stm_site_product();
			product.setSite_id(rs.getInt("site_id"));
			product.setProduct_id(rs.getInt("product_id"));
			productList.add(product);
			}
			}catch(SQLException error) {
			throw new DbException(error.getMessage());
		    }finally {
			ConnectionDB.closeStatment(st);
		}
	
		
		return productList;
	
	}

}
