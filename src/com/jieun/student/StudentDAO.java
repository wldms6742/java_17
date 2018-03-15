package com.jieun.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jieun.util.DBConnector;

public class StudentDAO {
	public int insert(StudentDTO studentDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into student values(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, studentDTO.getId());
		st.setString(2, studentDTO.getName());
		st.setInt(3, studentDTO.getAge());
		st.setString(4,studentDTO.getEmail());
		st.setString(5, studentDTO.getBirth());
		st.setString(6, studentDTO.getJob());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
}
