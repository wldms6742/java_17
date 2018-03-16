package com.jieun.teacher;

import java.util.ArrayList;
import java.util.List;

import com.jieun.member.MemberDTO;
import com.jieun.member.MemberService;

public class TeacherService implements MemberService {
	private TeacherDAO teacherDAO;
	public TeacherService() {
		teacherDAO = new TeacherDAO();
	}
	@Override
	public MemberDTO selectOne(int num) throws Exception {
		MemberDTO memberDTO = teacherDAO.selectOne(num);
		return memberDTO;
	}

	@Override
	public List<MemberDTO> selectList() throws Exception {
		List<MemberDTO> ar = new ArrayList<>();
	      try {
	         ar = teacherDAO.selectList();
	      } catch (Exception e) {
	         // TODO: handle exception
	      }
	      return ar;
	}

	@Override
	public String insert(MemberDTO memberDTO) throws Exception {
		 int result = teacherDAO.insert(memberDTO);
	      String message = "Insert-Fail";
	      if(result > 0 ) {
	         message = "Insert-Success";
	      }
	      return message;
	}

	@Override
	public String delete(int num) throws Exception {
		   
		int result=teacherDAO.delete(num);
		      String message = "Delete-Fail";
		      if(result > 0 ) {
		         message = "Delete-Success";
		      }
		      return message;
		   
	}

	@Override
	public String update(MemberDTO memberDTO) throws Exception {
		int result = teacherDAO.update(memberDTO);
		String message = "Update-fail";
		if(result>0) {
			message ="Update-success";
		}
		return message;
		
		
	}

}
