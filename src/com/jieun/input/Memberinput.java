package com.jieun.input;

import java.util.Scanner;

import com.jieun.member.MemberDTO;
import com.jieun.teacher.TeacherDTO;

public class Memberinput {
	private Scanner sc;
	public Memberinput() {
		sc = new Scanner(System.in);
	}
	//insert
	public void insert(MemberDTO memberDTO) {
		//학생,선생님 
		System.out.println("id를 입력하세요");
		memberDTO.setId(sc.nextInt());
		System.out.println("이름을 입력하세요");
		memberDTO.setName(sc.next());
		System.out.println("나이를 입력하세요");
		memberDTO.setAge(sc.nextInt());
		System.out.println("생일을 입력하세요");
		memberDTO.setEmail(sc.next());
		System.out.println("EMAIL을 입력하세요");
		memberDTO.setEmail(sc.next());
		System.out.println("직업을 입력하세요");
		memberDTO.setJob(sc.next());
		if(memberDTO instanceof TeacherDTO) {
		this.insert((TeacherDTO)memberDTO);
		}
		
		
		
	}
	private void insert(TeacherDTO teacherDTO) {
		System.out.println("급여를 입력하세요");
		teacherDTO.setSal(sc.nextInt());
	}
	//delete
	public int search() {
		//delete와 selectOne에 필요한 아이디 입력받는다
		System.out.println("검색할 id입력:");
		int num = sc.nextInt();
		return num;
	}
	//update
	public void update(MemberDTO memberDTO) {
		System.out.println("수정할 아이디 입력:");
	
		if(sc.nextInt()==memberDTO.getId()) {
			System.out.println("수정할 이름");
			memberDTO.setName(sc.next());
			System.out.println("수정할 나이");
			memberDTO.setAge(sc.nextInt());
			System.out.println("수정할 EMAIL :");
			memberDTO.setEmail(sc.next());
			System.out.println("수정할 생일 :");
			memberDTO.setBirth(sc.next());
		}else {
			System.out.println("해당 아이디 없음");
			}
		
	
	}
	//selectOne
	
}
