package com.jieun.score;

import java.util.ArrayList;
import java.util.Scanner;

import com.jieun.input.ScoreInput;
import com.jieun.view.ScoreView;


public class ScoreController {

	private Scanner sc;
	private ScoreInput input;
	private ScoreDTO scoreDTO;
	private ScoreService scoreService;
	private ScoreView scoreView;
	public ScoreController() {
		sc = new Scanner(System.in);
		input = new ScoreInput();
		scoreDTO = new ScoreDTO();
		scoreService = new ScoreService();
		scoreView = new ScoreView();
		
	}
	public void start() {
		while(true) {
			System.out.println("1.점수 등록");
			System.out.println("2.점수 삭제");
			System.out.println("3.점수 조회");
			System.out.println("4.종     료");
			int select = sc.nextInt();
			
			if(select==1) {
				scoreDTO = input.input();
				String message = scoreService.insert(scoreDTO);
				scoreView.view(message);
			}else if(select==2) {
				int num = input.delete();
				String message = scoreService.delete(num);
				scoreView.view(message);
			}else if(select==3) {
				ArrayList<ScoreDTO> ar = scoreService.selectAll();
				scoreView.view(ar);
				
			}else {
				break;
			}

		}
	}
}
