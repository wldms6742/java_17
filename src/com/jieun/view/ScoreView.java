package com.jieun.view;

import java.util.ArrayList;

import com.jieun.score.ScoreDTO;

public class ScoreView {
	
	public void view(String message) {
		System.out.println(message);
		}
	public void view(ArrayList<ScoreDTO> ar) {
		for(ScoreDTO scoreDTO : ar) { //ar에서 scoredto타입을 꺼낸다
			System.out.println("==========================");
			System.out.println("Name : "+scoreDTO.getName());
			System.out.println("Total : "+scoreDTO.getTotal());
			System.out.println("Avg: "+scoreDTO.getAvg());
		}
	}
}
