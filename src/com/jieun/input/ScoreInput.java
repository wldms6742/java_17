package com.jieun.input;

import java.util.Scanner;

import com.jieun.score.ScoreDTO;

public class ScoreInput {
	//insert, delete
	//추가
	private Scanner sc;
	public ScoreInput() {
		sc = new Scanner(System.in);
	}
	public ScoreDTO input() {
		ScoreDTO scoreDTO = new ScoreDTO();
		System.out.println("이름을 입력하세요");
		scoreDTO.setName(sc.next());
		System.out.println("학번을 입력하세요");
		scoreDTO.setSnum(sc.nextInt());
		System.out.println("국어점수 : ");
		scoreDTO.setKor(sc.nextInt());
		System.out.println("영어점수 :");
		scoreDTO.setEng(sc.nextInt());
		System.out.println("수학점수 : ");
		scoreDTO.setMath(sc.nextInt());
		
		return scoreDTO;
	}
	public int delete() {
		System.out.println("삭제할 번호 입력");
		int num = sc.nextInt();
		return num;
	}
}
