package com.ssafy.IMTest;

import java.io.*;
import java.util.*;

public class Main_BJ_10163_색종이 {
	public static void main(String[] args) {
		int [][]map = new int[1001][1001];

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 색종이의 장수	<= 변수 이름 동일
		
		// 데이터 입력
		for(int k=1; k<=N; k++) {			//색종이 => 1,2,3,4...
			int C = sc.nextInt();			//열(컬럼)인데스
			int R = sc.nextInt();			//행 인덱스
			int width = sc.nextInt();		//너비
			int height = sc.nextInt();		//높이
			
			// 번호를 배에 번호 출력
			for(int i=R; i<R+height; i++) {
				for(int j=C; j<C+width; j++) {
					map[i][j]=k;			// 색종이 번호를 입력
				}
			}
		}
			
			// 색종이 번호를 카운트 ==> 1차원 배열의 인덱스 번호를 사용해서
			int []cnt=new int[N+1];			// 0번지 버림
			
			for (int i = 0; i < 1001; i++) {
				for(int j=0; j < 1001; j++) {
					cnt[map[i][j]]++;
				}
			}
			
			// 카운트된 색종이의 값을 출력
			for(int i=1; i<=N; i++) {
				System.out.println(cnt[i]);
			}
		sc.close();
	}	// main
}	// end class