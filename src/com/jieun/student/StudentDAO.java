package com.jieun.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jieun.member.MemberDAO;
import com.jieun.member.MemberDTO;
import com.jieun.teacher.TeacherDTO;
import com.jieun.util.DBConnector;

public class StudentDAO implements MemberDAO{

	@Override
	public int insert(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into student values(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getName());
		st.setInt(3, memberDTO.getAge());
		st.setString(4,memberDTO.getEmail());
		st.setString(5, memberDTO.getBirth());
		st.setString(6, memberDTO.getJob());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;

	}

	@Override
	public int update(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "update student set name=?,age=?,email=?,birth=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getName());
		st.setInt(2, memberDTO.getAge());
		st.setString(3,memberDTO.getEmail());
		st.setString(4, memberDTO.getBirth());
		st.setInt(5, memberDTO.getId());
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	
	}

	@Override
	public int delete(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete student where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public List<MemberDTO> selectList() throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from student";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<MemberDTO> ar = new ArrayList<>();
		
		while(rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setName(rs.getString("name"));
			memberDTO.setId(rs.getInt("id"));
			memberDTO.setAge(rs.getInt("age"));
			memberDTO.setBirth(rs.getString("birth"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setJob(rs.getString("job"));
			ar.add(memberDTO);			
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;	
		
	}

	@Override
	public MemberDTO selectOne(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from student where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		st.setString(1, id);
		rs.next();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(rs.getString("name"));
		memberDTO.setId(rs.getInt("id"));
		memberDTO.setAge(rs.getInt("age"));
		memberDTO.setBirth(rs.getString("birth"));
		memberDTO.setEmail(rs.getString("email"));
		memberDTO.setJob(rs.getString("job"));
	
		
		DBConnector.disConnect(rs, st, con);
		
		return memberDTO; 
	}
	
	
}
