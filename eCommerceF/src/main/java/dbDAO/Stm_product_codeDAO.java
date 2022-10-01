package dbDAO;

import datalayerDAO.StmProductCode;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import classes.Stm_product_code;
import datalayer.ConnectionDB;



public class Stm_product_codeDAO implements StmProductCode {

	
	private ConnectionDB connection;
	private Connection connect;
	
	
	
	public Stm_product_codeDAO() {
		this.connection= new ConnectionDB();
		this.connect =connection.getConnection();
	}

	
	
	
	
	@Override
	public void insert(Stm_product_code obj) {
		PreparedStatement st=null;
		String mysql="INSERT INTO stm_product_code (product_id,product_code_cd,product_code_tp,product_code_jd)VALUES(?,?,?,?);";
		
		try {
			st=connect.prepareStatement(mysql,Statement.RETURN_GENERATED_KEYS);
			st.setInt(1,obj.getProduct_id());
			st.setString(2,obj.getProduct_code_cd());
			st.setString(3,obj.getProduct_code_tp());
			st.setString(4,obj.getProduct_code_jd());
			int rowsAffected=st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs= st.getGeneratedKeys();
				
				if(rs.next()) {
					int id=rs.getInt(1);
					obj.setProduct_id(id);
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
	public void update(Stm_product_code obj) {
		// TODO Auto-generated method stub
		PreparedStatement st=null;
		String sql="update stm_product_code set product_code_cd=?,product_code_tp=?,product_code_jd=? where product_id= ?;";

		try {
		st=connect.prepareStatement(sql);
		
		/*buscar o valor do meu objecto e colocalo no no statment*/
		st.setObject(4,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
		st.setString(1,obj.getProduct_code_cd());
		st.setString(2,obj.getProduct_code_tp());
		st.setString(3,obj.getProduct_code_jd());
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
		String sql="Delete from stm_products_code where product_id=?";
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
	public Stm_product_code findById(Integer id) {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM stm_product_code WHERE product_id = ?";
		ResultSet rs;
		PreparedStatement st=null;
		try {
			st= this.connect.prepareStatement(sql);
			st.setObject(1,BigInteger.valueOf(id),Types.BIGINT);
			rs = st.executeQuery();
			rs.next();
			Stm_product_code product =new Stm_product_code();
			product.setProduct_id(id);
			product.setProduct_code_cd(rs.getString("product_code_cd"));
			product.setProduct_code_tp(rs.getString("product_code_tp"));
			product.setProduct_code_jd(rs.getString("product_code_jd"));
			
			
			return product;
			
		} catch(SQLException error) {
			throw new DbException(error.getMessage());
		}finally {
			ConnectionDB.closeStatment(st);
		}

	}








	@Override
	public List<Stm_product_code> findAll() {
		// TODO Auto-generated method stub
		List<Stm_product_code> productList = new ArrayList<Stm_product_code>();
		String sql ="SELECT * FROM stm_product_code";
		ResultSet rs=null;
		PreparedStatement st=null;
		
		try {
			
			st= this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
			Stm_product_code product =new Stm_product_code();
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_code_cd(rs.getString("product_code_cd"));
			product.setProduct_code_tp(rs.getString("product_code_tp"));
			product.setProduct_code_jd(rs.getString("product_code_jd"));
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


