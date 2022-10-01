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

import classes.Stm_product;
import classes.Stm_site_client;
import datalayer.ConnectionDB;
import datalayerDAO.StmSiteClient;

public class Stm_site_clientDAO implements StmSiteClient {
	
	
	
	
	
	private ConnectionDB connection;
	private Connection connect;
	
	
	
	public Stm_site_clientDAO() {
		this.connection= new ConnectionDB();
		this.connect =connection.getConnection();
	}


	@Override
	public void insert(Stm_site_client obj) {
		PreparedStatement st=null;
		String mysql="INSERT INTO stm_site_client (site_id,client_ds)VALUES(?,?);";
		
		try {
			st=connect.prepareStatement(mysql,Statement.RETURN_GENERATED_KEYS);
			st.setInt(1,obj.getSite_id());
			st.setString(2,obj.getClient_ds());
			int rowsAffected=st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs= st.getGeneratedKeys();
				if(rs.next()) {
					int id=rs.getInt(1);
					obj.setClient_id(id);
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
	public void update(Stm_site_client obj) {
		String sql="Update stm_site_client set client_ds=? where client_id=?;";
		PreparedStatement st=null;
		
		try {
			
			st=this.connect.prepareStatement(sql);
			st.setString(1, obj.getClient_ds());
			st.setInt(2,obj.getClient_id());
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
		String sql="Delete from stm_site_client where client_id= ? ";
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
	public Stm_site_client findById(Integer id) {
		String sql ="SELECT * FROM stm_site_client WHERE client_id= ?";
		ResultSet rs;
		PreparedStatement st=null;
		try {
			st= this.connect.prepareStatement(sql);
			st.setObject(1,BigInteger.valueOf(id),Types.BIGINT);
			rs = st.executeQuery();
			boolean ok = rs.next();
			Stm_site_client client =new Stm_site_client();
			client.setSite_id(rs.getInt("site_id"));
			client.setClient_id(id);
			client.setClient_ds(rs.getString("client_ds"));
		
			
			return client;
			
		} catch(SQLException error) {
			throw new DbException(error.getMessage());
		}finally {
			ConnectionDB.closeStatment(st);
		}
	}
	

	@Override
	public List<Stm_site_client> findAll() {


		List<Stm_site_client> clientList = new ArrayList<Stm_site_client>();
		String sql ="SELECT * FROM stm_site_client";
		ResultSet rs=null;
		PreparedStatement st=null;
		
		try {
			st= this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				
			Stm_site_client client =new Stm_site_client();
			client.setSite_id(rs.getInt("site_id"));
			client.setClient_id(rs.getInt("client_id"));
			client.setClient_ds(rs.getString("client_ds"));
			clientList.add(client);
			}
			}catch(SQLException error) {
			throw new DbException(error.getMessage());
		    }finally {
			ConnectionDB.closeStatment(st);
		}
	
		

		
		
		return clientList;
	}
	

}
