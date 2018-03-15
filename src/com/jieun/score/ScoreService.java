package com.jieun.score;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScoreService {
	//insert
	private ScoreDAO dao;
	public ScoreService() {
	dao = new ScoreDAO();
	}
	public String insert(ScoreDTO scoreDTO) { //insert관련 사전작업
		
		
		int total = scoreDTO.getKor()+scoreDTO.getEng()+scoreDTO.getMath();
		scoreDTO.setTotal(total);
		scoreDTO.setAvg(total/3.0);
		
		try {
			int num = dao.getMax();
			scoreDTO.setNum(num+1);
			total = dao.insert(scoreDTO);
		} catch (Exception e) {
			total = 0; //실패할경우 원래의 total값이 나오는것을 ㅁ가아줌
			e.printStackTrace();
		}
		String message= "Insert Fail";
		if(total>0) {
			message = "Insert Success";
		} //else를 쓰지않아도 위에서 fail인경우 if문을 안돌기때문에 fail이 출력된다.
		return message;
		
	}
	public String delete(int num) {
		
		try {
			num = dao.delete(num);
		} catch (Exception e) {
			num=0;
			e.printStackTrace();
			// TODO: handle exception
		}
		String message = "Delete Fail";
		if(num>0) {
			message = "Delete Success";
		}
		return message;
	}
	public ArrayList<ScoreDTO> selectAll(){
		ArrayList<ScoreDTO> ar = new ArrayList<>();
		try {
			ar = dao.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
}
