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
import classes.Stm_site_client_order;
import datalayer.ConnectionDB;
import datalayerDAO.StmSiteClientOrder;

public class Stm_site_client_orderDAO implements StmSiteClientOrder {
	
	
	
	
	
	
	private ConnectionDB connection;
	private Connection connect;

	public Stm_site_client_orderDAO() {
		this.connection = new ConnectionDB();
		this.connect = connection.getConnection();
	}
	
	
	

	@Override
	public void insert(Stm_site_client_order obj) {
		PreparedStatement st=null;
		String mysql="INSERT INTO stm_site_client_order (site_id,client_id,order_jd)VALUES(?,?,?);";
		
		try {
			st=connect.prepareStatement(mysql,Statement.RETURN_GENERATED_KEYS);
			st.setInt(1,obj.getSite_id());
			st.setInt(2,obj.getClient_id());
			st.setString(3,obj.getOrder_jd());
			int rowsAffected=st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs= st.getGeneratedKeys();
				
				if(rs.next()) {
					int id=rs.getInt(1);
					obj.setOrder_id(id);
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
	public void update(Stm_site_client_order obj) {
		String sql="Update stm_site_client_order set site_id=?,client_id=?,order_jd=?  where order_id=?;";
		PreparedStatement st=null;
		
		try {
			
			st=this.connect.prepareStatement(sql);
			st.setInt(1, obj.getSite_id());
			st.setInt(2,obj.getClient_id());
			st.setString(3, obj.getOrder_jd());
			st.setInt(4, obj.getOrder_id());
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
		String sql="Delete from stm_site_client_order where order_id= ? ";
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
	public Stm_site_client_order findById(Integer id) {
		String sql ="SELECT * FROM stm_site_client_order WHERE order_id = ?";
		ResultSet rs;
		PreparedStatement st=null;
		try {
			st= this.connect.prepareStatement(sql);
			st.setObject(1,BigInteger.valueOf(id),Types.BIGINT);
			rs = st.executeQuery();
			Stm_site_client_order order =new Stm_site_client_order();
			order.setOrder_id(rs.getInt("order_id"));
			order.setSite_id(rs.getInt("site_id"));
			order.setClient_id(rs.getInt("client_id"));
			order.setOrder_jd(rs.getString("order_jd"));
			return order;
			
		} catch(SQLException error) {
			throw new DbException(error.getMessage());
		}finally {
			ConnectionDB.closeStatment(st);
		}
	}

	@Override
	public List<Stm_site_client_order> findAll() {

		List<Stm_site_client_order> orderList = new ArrayList<Stm_site_client_order>();
		String sql ="SELECT * FROM stm_site_client_order";
		ResultSet rs=null;
		PreparedStatement st=null;
		
		try {
			st= this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				
			Stm_site_client_order order =new Stm_site_client_order();
			order.setOrder_id(rs.getInt("order_id"));
			order.setSite_id(rs.getInt("site_id"));
			order.setClient_id(rs.getInt("client_id"));
			order.setOrder_jd(rs.getString("order_jd"));
			orderList.add(order);
			}
			}catch(SQLException error) {
			throw new DbException(error.getMessage());
		    }finally {
			ConnectionDB.closeStatment(st);
		}
	
		

		
		
		return orderList;
	}
	
}
