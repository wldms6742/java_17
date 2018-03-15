package com.jieun.student;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jieun.util.DBConnector;

public class StudentDAO {
	public void insert() throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into student values(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
	}
}
