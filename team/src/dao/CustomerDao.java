package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Customer;

public class CustomerDao extends Dao<String, Customer> {

	@Override
	public void insert(Connection con, Customer v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.customerInsert);
			pstmt.setString(1,v.getPayment());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}	
	}
	
	@Override
	public void delete(Connection con, String k) throws Exception {
		/*
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
		*/			
	}



	@Override
	public void update(Connection con, Customer v) throws Exception {
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
	public Customer select(Connection con, String k) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Customer customer = null;
		try {
			pstmt = con.prepareStatement(Sql.productSelect);
			pstmt.setString(1,k);
			rset = pstmt.executeQuery();
			rset.next();
			String id = rset.getString("ID");
			String payment = rset.getString("PAYMENT");
			customer = new Customer(id, payment);
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}
		return customer;
	}

	@Override
	public ArrayList<Customer> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Customer> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(Sql.productSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String id = rset.getString("ID");
				String payment = rset.getString("PAYMENT");
				Customer product = new Customer(id, payment);
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
	*/
}