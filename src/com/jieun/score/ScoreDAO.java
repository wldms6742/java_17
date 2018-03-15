package com.jieun.score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.jieun.util.DBConnector;


public class ScoreDAO {

	//추가 메서드명은 insert
	public int insert(ScoreDTO scoreDTO) throws Exception {
		
		Connection con = DBConnector.getConnect();
		
		String sql = "insert into score values(?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, scoreDTO.getNum());;
		st.setString(2, scoreDTO.getName());
		st.setInt(3, scoreDTO.getSnum());
		st.setInt(4, scoreDTO.getKor());
		st.setInt(5, scoreDTO.getEng());
		st.setInt(6, scoreDTO.getMath());
		st.setInt(7, scoreDTO.getTotal());
		st.setDouble(8, scoreDTO.getAvg());
		
		int result = st.executeUpdate();

		DBConnector.disConnect(st, con);

		return result;

		
	}
	public ArrayList<ScoreDTO> selectAll() throws Exception {
		
		Connection con = DBConnector.getConnect();
		
		String sql = "select * from score order by num desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<ScoreDTO> ar  = new ArrayList<>();
		
		while(rs.next()) {
			ScoreDTO scoreDTO = new ScoreDTO();
			scoreDTO.setNum(rs.getInt("num"));
			scoreDTO.setName(rs.getString("name"));
			scoreDTO.setSnum(rs.getInt("snum"));
			scoreDTO.setKor(rs.getInt("kor"));
			scoreDTO.setEng(rs.getInt("eng"));
			scoreDTO.setTotal(rs.getInt("total"));
			scoreDTO.setAvg(rs.getDouble("avg"));
			ar.add(scoreDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
	 
		//번호를 받아서 삭제 delete  
	public int delete(int num) throws Exception{
		Connection con  = DBConnector.getConnect();
		String sql = "delete score where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	//전체조회 메서드명 selectAll 최신순
	public int getMax() throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select max(nvl(num,0)) from score"; //num의 값이null인경우는 0을 넣어준다
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		rs.next(); //1번만 읽으면 되니까 반복문 사용X
		int num = rs.getInt(1);//max(num) 
		DBConnector.disConnect(rs, st, con);
				
		return num;
		
	}
	
}
