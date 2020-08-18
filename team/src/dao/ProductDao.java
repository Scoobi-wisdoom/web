package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Product;

public class ProductDao extends Dao<String, Product> {

	@Override
	public void insert(Connection con, Product v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.productInsert);
			pstmt.setString(1,v.getId());
			pstmt.setString(2,v.getCategory_id());
			pstmt.setString(3,v.getName());
			pstmt.setInt(4,v.getPrice());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}	
	}
	@Override
	public void delete(Connection con, String k) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.productDelete);
			pstmt.setString(1,k);
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}			
	}


	@Override
	public void update(Connection con, Product v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.productUpdate);
			pstmt.setString(4,v.getId());
			pstmt.setString(1,v.getCategory_id());
			pstmt.setString(2,v.getName());
			pstmt.setInt(3,v.getPrice());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}			
	}

	@Override
	public Product select(Connection con, String k) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product product = null;
		try {
			pstmt = con.prepareStatement(Sql.productSelect);
			pstmt.setString(1,k);
			rset = pstmt.executeQuery();
			rset.next();
			String id = rset.getString("ID");
			String category_id = rset.getString("CATEGORY_ID");
			String name = rset.getString("NAME");
			int price = rset.getInt("PRICE");
			product = new Product(id, category_id, name, price);
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}
		return product;
	}

	@Override
	public ArrayList<Product> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(Sql.productSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD");
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				Product product = new Product(id, pwd, name, price);
				list.add(product);
			}
		
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

}