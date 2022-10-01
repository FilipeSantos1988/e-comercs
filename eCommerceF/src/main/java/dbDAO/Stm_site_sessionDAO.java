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
import classes.Stm_site_session;
import datalayer.ConnectionDB;
import datalayerDAO.StmSiteSession;

public class Stm_site_sessionDAO implements StmSiteSession {

	private Connection connect;
	private ConnectionDB connection;

	public Stm_site_sessionDAO() {
		this.connection = new ConnectionDB();
		this.connect = connection.getConnection();

	}

	@Override
	public void insert(Stm_site_session obj) {

		PreparedStatement st = null;
		String mysql = "INSERT INTO stm_site_session (site_id,session_tk,client_id,created_dt,updated_dt)VALUES(?,?,?,?,?);";

		try {

			st = connect.prepareStatement(mysql, Statement.RETURN_GENERATED_KEYS);
			st.setObject(1, BigInteger.valueOf(obj.getSite_id()), Types.BIGINT);
			st.setString(2, obj.getSession_tk());
			st.setObject(3, BigInteger.valueOf(obj.getClient_id()), Types.BIGINT);
			st.setDate(4, obj.getCreated_dt());
			st.setDate(5, obj.getUpdated_dt());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				

			} else {
				throw new DbException("Unexpeted erroor! no rows affected");
			}

		} catch (SQLException error) {
			throw new DbException(error.getMessage());

		} finally {
			ConnectionDB.closeStatment(st);
		}

	}

	@Override
	public void update(Stm_site_session obj) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		PreparedStatement st=null;
		String sql="update stm_site_product set updated_dt where session_tk=?;";

		try {
		st=connect.prepareStatement(sql);
		
		/*buscar o valor do meu objecto e colocalo no no statment*/
		st.setObject(1,obj.getUpdated_dt());
		st.setObject(2,obj.getSession_tk());
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

		String sql = "Delete from stm_site_session where client_id=?";
		PreparedStatement st = null;
		try {
			st = this.connect.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();
		} catch (Exception error) {
			System.out.println("Erro ao eliminar" + error.getMessage());
		}

	}

	@Override
	public List<Stm_site_session> findById(Integer id) {

		List<Stm_site_session> sessionList = new ArrayList<Stm_site_session>();
		String sql = "SELECT * FROM stm_site_session where client_id=? ";
		ResultSet rs = null;
		PreparedStatement st = null;

		try {
			st = this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {

				Stm_site_session session = new Stm_site_session();
				session.setSite_id(rs.getInt("site_id"));
				session.setSession_tk(rs.getString("session_tk"));
				session.setClient_id(rs.getInt("client_id"));
				session.setCreated_dt(rs.getDate("created_dt"));
				session.setUpdated_dt(rs.getDate("updated_dt"));

				sessionList.add(session);
			}

		} catch (SQLException error) {
			throw new DbException(error.getMessage());
		} finally {
			ConnectionDB.closeStatment(st);
		}

		return sessionList;
	}

	public List<Stm_site_session> findAll() {

		List<Stm_site_session> sessionList = new ArrayList<Stm_site_session>();
		String sql = "SELECT * FROM stm_site_session";
		ResultSet rs = null;
		PreparedStatement st = null;

		try {
			st = this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {

				Stm_site_session session = new Stm_site_session();
				session.setSite_id(rs.getInt("site_id"));
				session.setSession_tk(rs.getString("session_tk"));
				session.setClient_id(rs.getInt("client_id"));
				session.setCreated_dt(rs.getDate("created_dt"));
				session.setUpdated_dt(rs.getDate("updated_dt"));

				sessionList.add(session);
			}

		} catch (SQLException error) {
			throw new DbException(error.getMessage());
		} finally {
			ConnectionDB.closeStatment(st);
		}

		return sessionList;
	}

}
