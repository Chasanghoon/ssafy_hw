package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution22 {
	static int N, O;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/Solution22.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	//테스트 케이스 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N=sc.nextInt();
//			1. 데이터 로드
			int [][] map = new int[N][N];
			
			O = sc.nextInt();
			int[][] bug=new int[O][3];
			for(int j=0; j < O; j++) {
				bug[j][0]=sc.nextInt();
				bug[j][1]=sc.nextInt();
				bug[j][2]=sc.nextInt();
			}
			for(int r=0; r<O; r++) {
				int cnt=3;
				int len = map.length;
				int row, col;
				row = bug[r][0];
				col = bug[r][1];
				
				int step=0;
				
				if(map[row][col]==1) {
					System.out.println("#"+test_case + " " + (r+1));
					break;
				}
			}
/*
 * for (int r = 1; r < N-1; r++) {
				for (int c = 1; c < N-1; c++) {
					big = 0;
					small = 0;
//					2.1 팔방을 검사해서 현재 좌표의 데이터보다 모두 큰지 또는 모두 작은지 검사	=> 카운트 세기
					for (int i = 0; i < n; i++) {
						nr = r+dr[i];
						nc = c+dc[i];
						if(matrix[nr][nc]>matrix[r][c]) {
							small++;
						}
						if(matrix[nr][nc]<matrix[r][c]) {
							big++;
						}
					}
 */
		}
		
	}

}
