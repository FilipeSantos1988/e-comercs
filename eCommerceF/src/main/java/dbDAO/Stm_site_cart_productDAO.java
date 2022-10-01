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
import classes.Stm_site_cart_product;
import datalayer.ConnectionDB;
import datalayerDAO.StmSiteCartProduct;

public class Stm_site_cart_productDAO implements StmSiteCartProduct {

	private ConnectionDB connection;
	private Connection connect;

	public Stm_site_cart_productDAO() {
		this.connection = new ConnectionDB();
		this.connect = connection.getConnection();
	}

	@Override
	public void insert(Stm_site_cart_product obj) {
		PreparedStatement st = null;
		String mysql = "INSERT INTO stm_site_cart_product (site_id,cart_tk,product_id,order_qt,units_tp)VALUES(?,?,?,?,?,?,?);";

		try {
			st = connect.prepareStatement(mysql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getSite_id());
			st.setString(2, obj.getCart_tk());
			st.setInt(3, obj.getProduct_id());
			st.setInt(4, obj.getOrder_qt());
			st.setString(4, obj.getUnits_tp());
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
	public void update(Stm_site_cart_product obj) {
		String sql = "Update stm_site_cart_product set order_qt=?,units_tp=? where product_id=?;";
		PreparedStatement st = null;

		try {

			st = this.connect.prepareStatement(sql);
			st.setInt(1, obj.getOrder_qt());
			st.setString(2, obj.getUnits_tp());
			st.setInt(3, obj.getProduct_id());
			st.execute();
		} catch (Exception error) {
			System.out.println("Erro ao inserir " + error.getMessage());
		} finally {
			ConnectionDB.closeStatment(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		String sql = "Delete from stm_site_cart_product where product_id= ? ";
		PreparedStatement st = null;
		try {
			st = this.connect.prepareStatement(sql);
			st.setObject(1, BigInteger.valueOf(id), Types.BIGINT);
			st.execute();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}
	
	
	
	public void deleteByCartProduct(String cartTk, Integer productId) {
		
		
		String sql = "Delete from stm_site_cart_product where product_id= ? and cart_tk = ?";
		PreparedStatement st = null;
		try {
			st = this.connect.prepareStatement(sql);
			st.setObject(1, BigInteger.valueOf(productId), Types.BIGINT);
			st.setString(2,cartTk);
			st.execute();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}
		
		
		
	

	@Override
	public Stm_site_cart_product findById(Integer id) {
		String sql = "SELECT * FROM stm_site_cart_product WHERE product_id = ?";
		ResultSet rs;
		PreparedStatement st = null;
		try {
			st = this.connect.prepareStatement(sql);
			st.setObject(1, BigInteger.valueOf(id), Types.BIGINT);
			rs = st.executeQuery();
			Stm_site_cart_product product = new Stm_site_cart_product();
			product.setProduct_id(id);
			product.setSite_id(rs.getInt("site_id"));
			product.setCart_tk(rs.getString("cart_tk"));
			product.setOrder_qt(rs.getInt("order_qt"));
			product.setUnits_tp(rs.getString("units_tp"));

			return product;

		} catch (SQLException error) {
			throw new DbException(error.getMessage());
		} finally {
			ConnectionDB.closeStatment(st);
		}
	}

	@Override
	public List<Stm_site_cart_product> findAll() {
		List<Stm_site_cart_product> kartList = new ArrayList<Stm_site_cart_product>();
		String sql = "SELECT * FROM stm_site_cart_product";
		ResultSet rs = null;
		PreparedStatement st = null;

		try {
			st = this.connect.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {

				Stm_site_cart_product product = new Stm_site_cart_product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setSite_id(rs.getInt("site_id"));
				product.setCart_tk(rs.getString("cart_tk"));
				product.setOrder_qt(rs.getInt("order_qt"));
				product.setUnits_tp(rs.getString("units_tp"));
				kartList.add(product);
			}
		} catch (SQLException error) {
			throw new DbException(error.getMessage());
		} finally {
			ConnectionDB.closeStatment(st);
		}

		return kartList;
	}

}

