package com.ssafy.Algorithm_12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Silver1_1992_차상훈 {
	private static int[][] img;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input_12.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		img = new int[N][N];

		for (int i = 0; i < N; i++) {
			// StringTokenizer str = new StringTokenizer(br.readLine());
			// int A = Integer.parseInt(str.nextToken());
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				img[i][j] = str.charAt(j) - '0';			//기존 str.charAt(x) => 문자 출력, str.charAt(x)-0=> int 형 정수 출력 
			}
		}
		Quadtree(0, 0, N);
		System.out.println(sb);
	}

	public static void Quadtree(int x, int y, int size) {
		// 하나의 색상으로 압축
		if (isPossible(x, y, size)) {
			sb.append(img[x][y]);
			return;
		}

		// 압축이 불가능할 경우 절반으로 사이즈 분할
		int newSize = size / 2;

		// 각 레벨(depth)에서 여는 괄호로 시작
		sb.append('(');

		Quadtree(x, y, newSize);							// 왼쪽 위
		Quadtree(x, y + newSize, newSize);					// 오른쪽 위
		Quadtree(x + newSize, y, newSize);					// 왼쪽 아래
		Quadtree(x + newSize, y + newSize, newSize);		// 오른쪽 아래

		sb.append(')');
	}
	
	// 압축이 가능한지 해당 공간을 체크해주는 함수
	public static boolean isPossible(int x, int y, int size) {
		int value = img[x][y];
		
		for(int i=x; i<x+size;i++) {
			for(int j=y; j<y+size;j++) {
				if(value != img[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
