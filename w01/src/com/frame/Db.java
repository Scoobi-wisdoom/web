package com.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Db<K,V> {
	private String url;
	private String dbid;
	private String dbpwd;
	//constructor
	public Db() {
	}
	
	//login
	public Db(String ip, String dbid, String dbpwd) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found..!");
			e.printStackTrace();
		}
		this.url = "jdbc:oracle:thin:@"+ip+":1521:xe";
		this.dbid = dbid;
		this.dbpwd = dbpwd;
	}
	//connection
	public Connection getConnection () {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, dbid, dbpwd);
		} catch (SQLException e) {
			System.out.println("No Connection..!");
			e.printStackTrace();
		}
		return con;
	}
	public void close(ResultSet rset) {
		if(rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void insert(V v) throws Exception;
	public abstract void delete(K k) throws Exception;
	public abstract void update(V v) throws Exception;
	public abstract V select(K k) throws Exception;
	public abstract ArrayList<V>select() throws Exception;
}
