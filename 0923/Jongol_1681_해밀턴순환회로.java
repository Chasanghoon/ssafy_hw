package com.ssafy.Algorithm22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Jongol_1681_해밀턴순환회로{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int answer = Integer.MAX_VALUE>>2;
	static boolean[] visited;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException{
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine()," ");
		N = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dfs(0,0,0);
		System.out.println(answer);
	}

	public static void dfs(int start, int idx, int money) {
		if (money>=answer) return;
		
		if (idx == N-1) {
			if (map[start][0]!=0) answer = Math.min(answer, money+map[start][0]);
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if(map[start][i] !=0 && !visited[i]) {
				visited[i] = true;
				dfs(i, idx+1, map[start][i]+money);
				visited[i] = false;
			}
		}
	}
	
	public static String src =
			"5 \r\n" + 
			"0 14 4 10 20 \r\n" + 
			"14 0 7 8 7 \r\n" + 
			"4 5 0 7 16 \r\n" + 
			"11 7 9 0 2 \r\n" + 
			"18 7 17 4 0";
}