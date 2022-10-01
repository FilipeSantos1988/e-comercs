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
import classes.Stm_site_product_code;
import datalayer.ConnectionDB;
import datalayerDAO.StmSiteProductCode;

public class Stm_site_product_codeDAO implements StmSiteProductCode{
	
	
	
	private ConnectionDB connection;
	private Connection connect;
	
	
	
	public Stm_site_product_codeDAO() {
		this.connection= new ConnectionDB();
		this.connect =connection.getConnection();
	}
	

	
	
	
	
	
	@Override
	public void insert(Stm_site_product_code obj) {
		// TODO Auto-generated method stub
		PreparedStatement st=null;
		String mysql="INSERT INTO stm_site_product_code (site_id,product_id,product_code_cd,product_code_tp,product_code_jd)VALUES(?,?,?,?,?);";
		
		try {
			st=connect.prepareStatement(mysql,Statement.RETURN_GENERATED_KEYS);
			st.setObject(1,BigInteger.valueOf(obj.getSite_id()),Types.BIGINT);
			st.setObject(2,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
			st.setString(3, obj.getProduct_code_cd());
			st.setString(4,obj.getProduct_code_tp());
			st.setString(5, obj.getProduct_code_jd());
			int rowsAffected=st.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("efectuado");}
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
	public void update(Stm_site_product_code obj) {
		String sql="Update stm_site_product_code set site_id=?,product_id=?,product_code_cd=?,"
				+"product_code_tp=?,product_code_jd=?  where product_id=? and ;"+
				"site_id=? and product_code_cd=? and product_code_tp=?;";
		PreparedStatement st=null;
		
		try {
			st=this.connect.prepareStatement(sql);
			st.setObject(1,BigInteger.valueOf(obj.getSite_id()),Types.BIGINT);
			st.setObject(2,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
			st.setString(3, obj.getProduct_code_cd());
			st.setString(4,obj.getProduct_code_tp());
			st.setString(5, obj.getProduct_code_jd());
			st.setObject(6,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
			st.setObject(7,BigInteger.valueOf(obj.getProduct_id()),Types.BIGINT);
			st.setString(8, obj.getProduct_code_cd());
			st.setString(9,obj.getProduct_code_tp());
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
		// TODO Auto-generated method stub
			String sql="Delete from stm_site_product_code where product_id=?";
			PreparedStatement st=null;
			try {
				st=this.connect.prepareStatement(sql);
				st.setInt(1,id);
				st.execute();
			}catch(Exception error) {
		    	 System.out.println("Erro ao inserir curso"+error.getMessage());
			}finally {
				ConnectionDB.closeStatment(st);
			}
			
		
	}

	@Override
	public Stm_site_product_code findById(Integer id) {
		String sql ="SELECT * FROM stm_site_product_code WHERE product_id = ?";
		ResultSet rs;
		PreparedStatement st=null;
		try {
			st= this.connect.prepareStatement(sql);
			st.setObject(1,BigInteger.valueOf(id),Types.BIGINT);
			rs = st.executeQuery();
			Stm_site_product_code product =new Stm_site_product_code();
			product.setProduct_id(id);
			product.setSite_id(rs.getInt(1));
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
	public List<Stm_site_product_code> findAll() {

		List<Stm_site_product_code> productList = new ArrayList<Stm_site_product_code>();
		String sql ="SELECT * FROM stm_site_product_code";
		ResultSet rs=null;
		PreparedStatement st=null;
		
		try {
			
			st= this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
			Stm_site_product_code product =new Stm_site_product_code();
			product.setProduct_id(rs.getInt("site_id"));
			product.setProduct_id(rs.getInt("prondutc_id"));
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
