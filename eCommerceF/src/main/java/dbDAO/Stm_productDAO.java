package dbDAO;

import classes.Stm_product;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import datalayer.ConnectionDB;
import datalayerDAO.StmProduct;




public class Stm_productDAO implements StmProduct {
	
	private ConnectionDB connection;
	private Connection connect;
	
	
	
	public Stm_productDAO() {
		this.connection= new ConnectionDB();
		this.connect =connection.getConnection();
	}

	
	
	
	
	
	
		public void insert(Stm_product obj) {
		PreparedStatement st=null;
		String mysql="INSERT INTO stm_product (product_ds,product_st,product_jd,product_image_cd)VALUES(?,?,?,?);";
		
		try {
			st=connect.prepareStatement(mysql,Statement.RETURN_GENERATED_KEYS);
			st.setString(1,obj.getProducts_ds());
			st.setString(2,obj.getProduct_st());
			st.setString(3,obj.getProduct_jd());
			st.setString(4,obj.getProduct_image_cd());
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
		public void update(Stm_product obj) {
		String sql="Update stm_product set product_ds=?,product_st=?, product_image_cd=?  where product_id=?;";
		PreparedStatement st=null;
		
		try {
			
			st=this.connect.prepareStatement(sql);
			st.setString(1, obj.getProducts_ds());
			st.setString(2,obj.getProduct_st());
			st.setString(3, obj.getProduct_image_cd());
			st.setInt(4, obj.getProduct_id());
			st.execute();
			}
		catch(Exception error) {
			System.out.println("Erro ao inserir "+error.getMessage());
		}finally {
			ConnectionDB.closeStatment(st);
		}
	}
	
	
	
	
	

		@Override
		public void deleteById(Integer id){
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
		public Stm_product findById(Integer id) {
			
			String sql ="SELECT * FROM stm_product WHERE product_id = ?";
			ResultSet rs;
			PreparedStatement st=null;
			try {
				st= this.connect.prepareStatement(sql);
				st.setObject(1,BigInteger.valueOf(id),Types.BIGINT);
				rs = st.executeQuery();
				boolean ok = rs.next();
				System.out.println(ok);
				System.out.println(rs.getString("product_st"));
				Stm_product product =new Stm_product();
				product.setProduct_id(id);
				product.setProduct_image_cd(rs.getString("product_image_cd"));
				product.setProduct_jd(rs.getString("product_jd"));
				product.setProduct_st(rs.getString("product_st"));
				product.setProducts_ds(rs.getString("product_ds"));
				
				return product;
				
			} catch(SQLException error) {
				throw new DbException(error.getMessage());
			}finally {
				ConnectionDB.closeStatment(st);
			}
		}
		
		
		
		
		@Override
		public List <Stm_product>findAll() {
			

			List<Stm_product> productList = new ArrayList<Stm_product>();
			String sql ="SELECT * FROM stm_product";
			ResultSet rs=null;
			PreparedStatement st=null;
			
			try {
				st= this.connect.prepareStatement(sql);
				rs = st.executeQuery();
				while(rs.next()) {
					
				Stm_product product =new Stm_product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProducts_ds(rs.getString("product_ds"));
				product.setProduct_st(rs.getString("product_st"));
				product.setProduct_jd(rs.getString("product_jd"));
				product.setProduct_image_cd(rs.getString("product_image_cd"));
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
