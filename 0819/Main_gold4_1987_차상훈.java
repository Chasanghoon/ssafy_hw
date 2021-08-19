package com.ssafy.Algorithm_13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_gold4_1987_차상훈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int r, c;
	static char [][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));

		tokens = new StringTokenizer(input.readLine());
		r = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		map = new char[r][c];
		
		for(int i =0; i<r; i++) {
			for(int j=0; j<c; j++) {
				map[i][j] = (char) (map[r][c]-'A');
			}
		}
		
		System.out.println();
	}
	
	private static void dfs(char[][] map, int x, int y) {
		int idx = map[x][y];

		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if (nr>-1 && nr<c && nc>-1 && nc<r) {
				//map[nr][nc];
			}
		}
		
	}
	
	private static String src =
			"3 6\r\n" + 
			"HFDFFB\r\n" + 
			"AJHGDH\r\n" + 
			"DGAGEH";
}