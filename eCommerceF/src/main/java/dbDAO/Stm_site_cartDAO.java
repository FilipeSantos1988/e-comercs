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
import classes.Stm_site_cart;
import datalayer.ConnectionDB;
import datalayerDAO.StmSiteCart;

public class Stm_site_cartDAO implements StmSiteCart {

	private ConnectionDB connection;
	private Connection connect;

	public Stm_site_cartDAO() {
		this.connection = new ConnectionDB();
		this.connect = connection.getConnection();
	}

	@Override
	public void insert(Stm_site_cart obj) {
		PreparedStatement st = null;
		String mysql = "INSERT INTO stm_site_cart (site_id,cart_tk,session_tk,client_id)VALUES(?,?,?,?);";

		try {
			st = connect.prepareStatement(mysql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getSite_id());
			st.setString(2, obj.getCart_tk());
			st.setString(3, obj.getSession_tk());
			st.setInt(4, obj.getClient_id());
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();

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
	public void update(Stm_site_cart obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		String sql = "Delete from stm_site_cart where client_id= ? ";
		PreparedStatement st = null;
		try {
			st = this.connect.prepareStatement(sql);
			st.setObject(1, BigInteger.valueOf(id), Types.BIGINT);
			st.execute();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}

	@Override
	public Stm_site_cart findById(Integer id) {

		String sql = "SELECT * FROM stm_site_cart WHERE client_id = ?";
		ResultSet rs;
		PreparedStatement st = null;
		try {
			st = this.connect.prepareStatement(sql);
			st.setObject(1, BigInteger.valueOf(id), Types.BIGINT);
			rs = st.executeQuery();
			Stm_site_cart cart = new Stm_site_cart();
			cart.setSite_id(rs.getInt("site_id"));
			cart.setCart_tk(rs.getString("cart_tk"));
			cart.setSession_tk(rs.getString("session_tk"));
			cart.setClient_id(id);
			return cart;

		} catch (SQLException error) {
			throw new DbException(error.getMessage());
		} finally {
			ConnectionDB.closeStatment(st);
		}
	}

	@Override
	public List<Stm_site_cart> findAll() {


		List<Stm_site_cart> cartList = new ArrayList<Stm_site_cart>();
		String sql ="SELECT * FROM stm_site_cart";
		ResultSet rs=null;
		PreparedStatement st=null;
		
		try {
			st= this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				
			Stm_site_cart cart =new Stm_site_cart();
			cart.setSite_id(rs.getInt("site_id"));
			cart.setCart_tk(rs.getString("cart_tk"));
			cart.setSession_tk(rs.getString("session_tk"));
			cart.setClient_id(rs.getInt("client_id"));
			cartList.add(cart);
			}
			}catch(SQLException error) {
			throw new DbException(error.getMessage());
		    }finally {
			ConnectionDB.closeStatment(st);
		}
	
		

		
		
		return cartList;
	}

}
