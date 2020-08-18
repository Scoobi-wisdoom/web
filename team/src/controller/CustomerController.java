package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CustomerDao;
import frame.Controller;
import frame.Dao;
import vo.Customer;


public class CustomerController extends Controller<String, Customer> {
	
	Dao<String,Customer> dao;
	
	public CustomerController() {
		dao = new CustomerDao();
	}

	@Override
	public void register(Customer v) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.insert(con, v);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}
		

	@Override
	public void remove(String k) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.delete(con, k);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}		
	}

	@Override
	public void modify(Customer v) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.update(con, v);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}		
	}

	@Override
	public Customer get(String k) throws Exception {
		Customer product = null;
		Connection con = null;
		
		try {
			con = getConnection();
			product = dao.select(con,k);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return product;
	}

	@Override
	public ArrayList<Customer> get() throws Exception {
		ArrayList<Customer> list = null;
		Connection con = null;
		try {
			con = getConnection();
			list = dao.select(con);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return list;
	}

}
