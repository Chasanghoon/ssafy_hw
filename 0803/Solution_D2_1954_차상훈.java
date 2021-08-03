package com.ssafy.Algorithm_02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1954_차상훈 {

	public static void main(String[] args){Scanner scan = new Scanner(System.in);
	int T = scan.nextInt();
	int answer = 1;
	
	// 테스트케이스(T)의 수 동안 반복
	for(int test_case=0; test_case<T; test_case++) {
		
		// 각 케이스별 배열, 변수 초기화
		int N = scan.nextInt();
		int [][]arr = new int[N][N];
		int col = 0;	// 행
		int row = -1;	// 열
		int flag = 1;	// 위치 조정(1, -1)
		int number = 1;	// 값 넣기
		int count = N;	// 각 열당 숫자가 N, N-1, N-1, N-2, N-2, ... 로 감소
		System.out.println("#" + answer);
		answer +=1;
		while(true) {
			for(int i=0; i<N; i++) {
				row += flag;	
				arr[col][row] = number;
				number += 1;	
			}
			
			N -= 1;
			if(N == 0)	break;	
			
			for(int i=0; i<N; i++) {
				col += flag;
				arr[col][row] = number;
				number +=1;
			}
			flag *= (-1);	 
		}
		
		for(int i=0; i<count; i++) {
			for(int j=0; j<count; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	scan.close();
	}
}
