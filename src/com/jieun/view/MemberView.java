package com.jieun.view;

import java.util.List;

import com.jieun.member.MemberDTO;
import com.jieun.teacher.TeacherDTO;

public class MemberView {
	public void view(MemberDTO memberDTO) {
		System.out.println("=================");
		System.out.println("ID : "+memberDTO.getId());
		System.out.println("Name : "+memberDTO.getName());
		System.out.println("Birth : "+memberDTO.getBirth());
		System.out.println("Age : "+memberDTO.getAge());
		System.out.println("Email : "+memberDTO.getEmail());
		System.out.println("Job : "+ memberDTO.getJob());
		if(memberDTO instanceof TeacherDTO) {
			this.view((TeacherDTO)memberDTO);
			}

	}
	private void view(TeacherDTO teacherDTO) {
		System.out.println("SAL : "+teacherDTO.getSal());
	}
	public void view(List<MemberDTO> ar) {
		for(MemberDTO memberDTO : ar) {
			this.view(memberDTO);
		}
	}
	public void view(String message) {
		System.out.println(message);
	}
}
