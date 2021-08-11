package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Silver3_16926_차상훈 {
	private static int [][] map;
	private static int [][] invisited;
	private static int n, m, o;
	
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	
	private static int sr, sc, er, ec;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		o = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int count = Math.min(n, m)/2;
		
		for(int i=0; i<o; i++) {
			for(int j=0; j<count; j++) {
				int temp = arr[j][i];
				
				for(int k=j+1; k<m-j; k++) {
					arr[j][k-1]=arr[j][k];
				}
				for(int k=j+1; k<n-j; k++) {
					arr[k-1][m-1-j]=arr[k][m-1-j];
				}
				
				arr[j+1][j] = temp;
			}
		}
	}
}
