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



import classes.Stm_site;
import datalayer.ConnectionDB;
import datalayerDAO.StmSite;

public class Stm_siteDAO implements StmSite {
	
	
	
	private Connection connect;
	private ConnectionDB connection;
	
	
	
	public  Stm_siteDAO() {
	 this.connection= new ConnectionDB();
	 this.connect =connection.getConnection();
	 
	}
	
	
	
	@Override
	public void insert(Stm_site obj) {
		
		PreparedStatement st=null;
		String mysql="INSERT INTO stm_site (site_ds,site_st,site_tp,site_jd)VALUES(?,?,?,?);";
		
		
		
		try {
			
			st=connect.prepareStatement(mysql,Statement.RETURN_GENERATED_KEYS);
			st.setString(1,obj.getSite_ds());
			st.setString(2,obj.getSite_st());
			st.setString(3,obj.getSite_tp());
			st.setString(4,obj.getSite_jd());
			
			
			int rowsAffected=st.executeUpdate();
			System.out.println("aqui");
			if(rowsAffected > 0) {
				
				ResultSet rs= st.getGeneratedKeys();
				System.out.println("aqui");
				if(rs.next()) {
					int id=rs.getInt(1);
					obj.setSite_id(id);
					
					
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
	public void update(Stm_site obj) {
PreparedStatement st=null;
		

			String sql="update stm_site set site_ds=?,site_tp=?,site_st=?,site_jd=? where site_id= ?;";

		try {
			st=connect.prepareStatement(sql);
			
			/*buscar o valor do meu objecto e colocalo no no statment*/
			st.setObject(5,BigInteger.valueOf(obj.getSite_id()),Types.BIGINT);
			st.setString(1,obj.getSite_ds());
			st.setString(2,obj.getSite_tp());
			st.setString(3,obj.getSite_st());
			st.setString(4,obj.getSite_jd());
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
		
		PreparedStatement st= null;
		
		
		
		try {
			st=connect.prepareStatement("DELETE FROM stm_site WHERE site_id=?");
			st.setInt(1,id);
			st.executeUpdate();
			
		}catch(SQLException error){
			
			throw new DbException(error.getMessage());
		
		}finally {
			
			ConnectionDB.closeStatment(st);
		}
		
	}

	

	
	
	
	
	
	
	@Override
	public Stm_site findById(Integer id) {
		
		String sql ="SELECT * FROM stm_site WHERE site_id = ?";
		ResultSet rs=null;
		PreparedStatement st=null;
		
		try {
			
			st= this.connect.prepareStatement(sql);
			st.setObject(1,BigInteger.valueOf(id),Types.BIGINT);
			rs = st.executeQuery();
			boolean ok = rs.next();
			Stm_site site =new Stm_site();
			site.setSite_id(id);
			site.setSite_tp(rs.getString("site_tp"));
			site.setSite_jd(rs.getString("site_jd"));
			site.setSite_st(rs.getString("site_st"));
			site.setSite_ds(rs.getString("site_ds"));
			return site;
		} catch(SQLException error) {
			throw new DbException(error.getMessage());
		}finally {
			ConnectionDB.closeStatment(st);
		}
	}
	

	
	
	
	@Override
	public List<Stm_site> findAll() {
		

		List<Stm_site> siteList = new ArrayList<Stm_site>();
		String sql ="SELECT * FROM stm_site";
		ResultSet rs=null;
		PreparedStatement st=null;
		
		try {
			
			st= this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
			Stm_site site =new Stm_site();
			site.setSite_id(rs.getInt("site_id"));
			site.setSite_ds(rs.getString("site_ds"));
			site.setSite_tp(rs.getString("site_tp"));
			site.setSite_st(rs.getString("site_st"));
			site.setSite_jd(rs.getString("site_jd"));
			

			
			siteList.add(site);
			}
			}
			
		 catch(SQLException error) {
			throw new DbException(error.getMessage());
		}finally {
			ConnectionDB.closeStatment(st);
		}
	
		
	
		
		
		return siteList;
	}
	
	
	

}
