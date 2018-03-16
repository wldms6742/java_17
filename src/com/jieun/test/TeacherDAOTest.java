package com.jieun.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.jieun.member.MemberDTO;
import com.jieun.teacher.TeacherDAO;

public class TeacherDAOTest {

	@Test
	public void test() {
	TeacherDAO teacherDAO = new TeacherDAO();
	List<MemberDTO> ar = null;
	try {
		ar = teacherDAO.selectList();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertNotEquals(0, ar.size());
	}
	@Test //annotaition을 써줘야 테스트 실행
	public void test2() {
		assertEquals(0, 0);
	}

}
