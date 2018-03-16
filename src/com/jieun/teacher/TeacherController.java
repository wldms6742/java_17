package com.jieun.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jieun.input.Memberinput;
import com.jieun.member.MemberDTO;
import com.jieun.view.MemberView;

public class TeacherController {

	private MemberView view;
	private TeacherDAO dao;
	private TeacherDTO teacherDTO ;
	
	private TeacherService teacherService;
	private Memberinput iMemberinput;
	public TeacherController() {
		view = new MemberView();
		dao = new TeacherDAO();
		teacherDTO =new TeacherDTO();
		teacherService = new TeacherService();
		iMemberinput = new Memberinput();
	}
	public void start() throws Exception {
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			System.out.println("1.전체선생님조회");
			System.out.println("2.해당선생님검색");
			System.out.println("3.선생님 추가");
			System.out.println("4.선생님 수정");
			System.out.println("5.선생님 삭제");
			System.out.println("6.종료");
			System.out.println("번호를 입력하세요");
			int select = sc.nextInt();
			if(select==1) {
				List<MemberDTO> ar = teacherService.selectList();
				
				view.view(ar);
				
			}else if(select==2) {
				int num = iMemberinput.search();
					MemberDTO memberDTO= teacherService.selectOne(num);
					view.view(memberDTO);
				
			}else if(select==3) {
				iMemberinput.insert(teacherDTO);
				String message = teacherService.insert(teacherDTO);
				view.view(message);
			}else if(select==4) {
				iMemberinput.update(teacherDTO);
				String message = teacherService.update(teacherDTO);
				view.view(message);
			}else if(select==5) {
				int num = iMemberinput.search();
				String message= teacherService.delete(num);
				view.view(message);
				}else if(select==6) {
				break;
			}
		}
	}
}
