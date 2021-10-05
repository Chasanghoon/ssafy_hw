package com.ssafy.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G1_15961_차상훈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens; 
	static int n, d, k, c;
	static int[] arr, visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());		// 회전 초밥 벨트에 놓인 접시의 수
		d = Integer.parseInt(tokens.nextToken());		// 초밥의 가짓수
		k = Integer.parseInt(tokens.nextToken());		// 연속해서 먹는 접시의 수
		c = Integer.parseInt(tokens.nextToken());		// 쿠폰번호
		arr = new int[n];		
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}
		
		visited = new int[d+1];		// 먹은 스시 갯수를 저장할 배열
		
	}

	public static String src =
			"8 30 4 30\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"7\r\n" + 
			"30\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"25";
}