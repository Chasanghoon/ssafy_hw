package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이_차상훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//조건 1. 100 x 100 도화지이므로 101 배열 선언(0,0) 포함
		int map[][] = new int[101][101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		for (int k = 0; k < N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			//조건 2. 색종이의 가로, 세로 크기가 10이므로 10씩 추가
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					//조건3. [중요] 겹치는 영역에 대해 0의 경우 cnt를 증가, 0이 아닌 기존의 겹치는 부분(map[r+i][c+j])은 pass
					if(map[r+i][c+j] == 0) {
						cnt++;
						map[r+i][c+j]=1;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}