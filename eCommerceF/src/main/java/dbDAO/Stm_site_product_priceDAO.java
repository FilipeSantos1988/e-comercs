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
import classes.Stm_site_product_price;
import datalayer.ConnectionDB;
import datalayerDAO.StmSiteProductPrice;

public class Stm_site_product_priceDAO implements StmSiteProductPrice{

	
	
	
	private ConnectionDB connection;
	private Connection connect;
	
	
	
	public Stm_site_product_priceDAO() {
		this.connection= new ConnectionDB();
		this.connect =connection.getConnection();
	}

	
	
	
	@Override
	public void insert(Stm_site_product_price obj) {
		PreparedStatement st=null;
		String mysql="INSERT INTO stm_site_product_price (site_id,product_id,currency_cd,start_dt,price_vl,price_st)VALUES(?,?,?,?,?,?);";
		
		try {
			st=connect.prepareStatement(mysql,Statement.RETURN_GENERATED_KEYS);
			st.setObject(1,BigInteger.valueOf(obj.getSite_id()),Types.BIGINT);
			st.setObject(2,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
			st.setString(3,obj.getCurrency_cd());
			st.setDate(2,obj.getStart_dt());
			st.setObject(2,obj.getPrice_vl(),Types.DECIMAL);
			st.setString(4,obj.getPrice_st());
			int rowsAffected=st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs= st.getGeneratedKeys();
				
				if(rs.next()) {
					int id=rs.getInt(2);
					obj.setProduct_id(id);
					}	
			}
			else {
				throw new DbException("Unexpeted erroor! no.get rows affected");
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
	public void update(Stm_site_product_price obj) {
		String sql="Update stm_site_product_price set site_id=?,product_id=?,currency_cd=?,start_dt=?,price_vl=?,price_st=?  "
					+"WHERE site_id=? and product_id=? and currency_cd=? and start_dt=?";
		
		
		PreparedStatement st=null;
		
		try {
			st=connect.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			st.setObject(1,BigInteger.valueOf(obj.getSite_id()),Types.BIGINT);
			st.setObject(2,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
			st.setString(3,obj.getCurrency_cd());
			st.setDate(4,obj.getStart_dt());
			st.setObject(5,obj.getPrice_vl(),Types.DECIMAL);
			st.setString(6,obj.getPrice_st());
			st.setObject(7,BigInteger.valueOf(obj.getSite_id()),Types.BIGINT);
			st.setObject(8,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
			st.setString(9,obj.getCurrency_cd());
			st.setDate(10,obj.getStart_dt());
			st.execute();
			}
		catch(Exception error) {
			System.out.println("Erro ao inserir "+error.getMessage());
		}finally {
			ConnectionDB.closeStatment(st);
		}
	}
	
		
	

	@Override
	public void deleteById(Integer id) {
		String sql="Delete from stm_product where product_id= ? ";
		PreparedStatement st=null;
		try {
			st=this.connect.prepareStatement(sql);
			st.setObject(1,BigInteger.valueOf(id),Types.BIGINT);
			st.execute();
		}catch(Exception error) {
	    	 System.out.println(error.getMessage());
		}
		}
		
		
	

	@Override
	public Stm_site_product_price findById(Integer id) {
		String sql ="SELECT * FROM stm_site_product_price WHERE product_id = ?";
		ResultSet rs;
		PreparedStatement st=null;
		try {
			
			st= this.connect.prepareStatement(sql);
			st.setObject(1,BigInteger.valueOf(id),Types.BIGINT);
			rs = st.executeQuery();
			Stm_site_product_price product =new Stm_site_product_price();
			
			if(rs.next()) {
			product.setProduct_id(rs.getInt("product_id"));
			product.setSite_id(rs.getInt("site_id"));
			product.setCurrency_cd(rs.getString("currency_cd"));
			product.setStart_dt(rs.getDate("start_dt"));
			product.setPrice_vl(rs.getLong("price_vl"));
			product.setPrice_st(rs.getString("price_st"));
			
			}
			return product;
			
		} catch(SQLException error) {
			throw new DbException(error.getMessage());
		}finally {
			ConnectionDB.closeStatment(st);
		}
	}

	
	
	
	
	@Override
	public List<Stm_site_product_price> findAll() {
		
		List<Stm_site_product_price> productList = new ArrayList<Stm_site_product_price>();
		String sql ="SELECT * FROM stm_site_product_price";
		ResultSet rs=null;
		PreparedStatement st=null;
		
		try {
			
			st= this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
			Stm_site_product_price product =new Stm_site_product_price();
			product.setSite_id(rs.getInt("site_id"));
			product.setProduct_id(rs.getInt("product_id"));
			product.setPrice_vl(rs.getFloat("price_vl"));
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




