package com.ssafy.Algorithm_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import sun.java2d.pipe.BufferedBufImgOps;

public class BOJ_1149_RGB거리 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int tc = Integer.parseInt(input.readLine());
		int arr[][] = new int[tc+1][3];	
		for (int i = 0; i < tc; i++) {			// N번째 집
			StringTokenizer tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < 3; j++) {		// 색상별
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		for (int i = 1; i <= tc; i++) {
			arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
			arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
			arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]);
        }

        System.out.println(Math.min(arr[tc - 1][0], Math.min(arr[tc - 1][1], arr[tc - 1][2])));
	}
	
	

	public static String src = 
			"3\r\n" + 
			"26 40 83\r\n" + // 26
			"49 60 57\r\n" + // 57
			"13 89 99";		 // 13		96
}
