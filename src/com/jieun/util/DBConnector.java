package com.jieun.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
	//st, con 
	public static void disConnect(ResultSet rs , PreparedStatement st,Connection con) {
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void disConnect(PreparedStatement st, Connection con) {
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//로그인 = connection객체 생성
	public static Connection getConnect() {
		String user  = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@192.168.20.22:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con =null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}//메서드만 있는 클래스에는 객체 생성이 필요없도록 static을 붙여준다
	
	
}
