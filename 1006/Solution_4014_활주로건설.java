package com.ssafy.Algorithm_27;

import java.io.*;
import java.util.*;
               
public class Solution_4014_활주로건설 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map1 = new int[20][20];
	static int[][] map2 = new int[20][20];
	static int N, X, count;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		int tnum = Integer.parseInt(input.readLine());

		for (int t = 1; t <= tnum; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			X = Integer.parseInt(tokens.nextToken());
			count = 0;
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(input.readLine());
				for (int j = 0; j < N; j++) {
					map1[i][j] = Integer.parseInt(tokens.nextToken());
					map2[j][i] = map1[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				if (calc(map1, i)) {
					count++;
				}
				if (calc(map2, i)) {
					count++;
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}

	private static boolean calc(int[][] map, int idx) {
		int count = 1;
		int height = map[idx][0];

		for (int i = 1; i < N; i++) {
			if (height == map[idx][i]) {
				count++;
			} else if (map[idx][i] - height == 1) {
				if (count < X) {
					return false;
				} else {
					count = 1;
					height = map[idx][i];
				}
			} else if (height - map[idx][i] == 1) {
				if (N < X + i) {
					return false;
				}
				for (int j = 1; j < X; j++) {
					if (height - map[idx][++i] != 1) {
						return false;
					}
				}
				height = map[idx][i];
				count = 0;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static String src = 
			"10\r\n" + 
			"6 2\r\n" + 
			"3 3 3 2 1 1\r\n" + 
			"3 3 3 2 2 1\r\n" + 
			"3 3 3 3 3 2\r\n" + 
			"2 2 3 2 2 2\r\n" + 
			"2 2 3 2 2 2\r\n" + 
			"2 2 2 2 2 2\r\n" + 
			"6 4\r\n" + 
			"3 2 2 2 1 2 \r\n" + 
			"3 2 2 2 1 2 \r\n" + 
			"3 3 3 3 2 2 \r\n" + 
			"3 3 3 3 2 2 \r\n" + 
			"3 2 2 2 2 2 \r\n" + 
			"3 2 2 2 2 2 \r\n" + 
			"7 2\r\n" + 
			"1 1 1 1 2 1 1 \r\n" + 
			"1 1 1 2 2 2 1 \r\n" + 
			"2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 2 2 2 \r\n" + 
			"8 3\r\n" + 
			"2 2 2 3 3 4 2 2 \r\n" + 
			"2 2 2 3 3 4 2 2 \r\n" + 
			"2 2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 1 1 2 2 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"8 4\r\n" + 
			"1 1 1 1 1 1 1 1 \r\n" + 
			"1 1 1 1 1 1 1 1 \r\n" + 
			"1 1 1 1 1 1 1 1 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"1 1 1 1 1 1 1 2 \r\n" + 
			"1 1 1 1 1 1 1 2 \r\n" + 
			"9 4\r\n" + 
			"4 4 3 3 3 3 2 2 2 \r\n" + 
			"4 4 3 3 1 1 2 2 3 \r\n" + 
			"3 3 2 2 1 1 1 1 2 \r\n" + 
			"1 1 1 1 1 1 1 1 1 \r\n" + 
			"1 1 1 1 1 1 1 1 1 \r\n" + 
			"2 2 1 1 1 1 1 1 1 \r\n" + 
			"2 2 1 1 1 1 1 1 1 \r\n" + 
			"2 2 2 2 2 2 1 1 1 \r\n" + 
			"3 3 3 3 2 2 2 2 1 \r\n" + 
			"10 2\r\n" + 
			"2 2 3 5 3 1 1 1 1 1 \r\n" + 
			"2 2 3 5 3 1 1 1 1 1 \r\n" + 
			"3 3 4 5 4 3 2 1 1 2 \r\n" + 
			"3 3 4 5 4 3 2 1 1 2 \r\n" + 
			"5 5 5 5 5 5 3 1 1 3 \r\n" + 
			"4 4 4 5 5 5 4 3 3 3 \r\n" + 
			"4 4 4 5 5 5 5 5 5 3 \r\n" + 
			"4 4 4 4 4 5 5 5 5 3 \r\n" + 
			"4 4 4 4 4 5 5 5 5 3 \r\n" + 
			"5 5 4 4 4 5 5 5 5 4 \r\n" + 
			"12 4\r\n" + 
			"4 4 4 5 5 4 4 4 4 4 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 5 5 5 4 \r\n" + 
			"4 4 4 5 5 4 4 4 5 5 5 4 \r\n" + 
			"3 3 4 5 5 4 3 4 5 5 5 4 \r\n" + 
			"3 3 4 5 5 4 3 4 5 5 5 4 \r\n" + 
			"2 2 3 4 4 4 4 4 4 4 4 5 \r\n" + 
			"2 2 3 4 4 4 4 4 4 4 4 5 \r\n" + 
			"2 2 3 3 3 4 5 3 2 2 4 4 \r\n" + 
			"3 3 3 4 4 4 5 4 3 3 4 4 \r\n" + 
			"3 3 4 5 5 5 5 5 5 5 5 4 \r\n" + 
			"3 3 4 5 5 5 5 5 5 5 5 4 \r\n" + 
			"4 4 4 4 4 4 5 5 5 5 5 4 \r\n" + 
			"15 3\r\n" + 
			"5 4 4 3 3 3 2 2 2 3 4 4 4 4 4 \r\n" + 
			"5 4 4 3 3 3 2 2 2 3 4 4 4 4 4 \r\n" + 
			"5 5 5 5 4 4 2 2 3 4 4 4 4 4 5 \r\n" + 
			"5 4 4 3 3 3 2 2 3 4 4 4 4 4 4 \r\n" + 
			"5 3 3 1 2 2 3 3 3 4 4 4 4 4 4 \r\n" + 
			"3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 \r\n" + 
			"3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 \r\n" + 
			"2 3 3 4 3 3 3 3 3 3 3 4 4 4 3 \r\n" + 
			"2 3 3 4 3 3 3 3 3 3 3 4 4 4 3 \r\n" + 
			"3 4 4 4 4 4 3 3 3 3 3 3 4 4 4 \r\n" + 
			"5 5 5 4 4 4 4 4 3 3 3 3 4 4 5 \r\n" + 
			"5 5 5 4 4 4 4 4 3 3 3 3 4 4 5 \r\n" + 
			"5 5 5 5 4 4 4 4 3 3 2 2 3 3 4 \r\n" + 
			"5 5 5 5 5 5 4 4 3 3 2 1 2 2 3 \r\n" + 
			"5 5 5 5 5 5 4 4 3 3 2 1 2 2 3 \r\n" + 
			"20 3\r\n" + 
			"3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 \r\n" + 
			"3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 \r\n" + 
			"5 3 3 2 2 2 2 2 3 3 4 4 4 4 5 5 5 5 5 5 \r\n" + 
			"4 3 3 1 1 1 1 1 2 3 4 4 4 5 5 5 5 5 5 5 \r\n" + 
			"4 2 2 1 1 1 1 1 2 3 4 5 5 5 5 5 5 5 5 5 \r\n" + 
			"4 3 3 2 2 2 2 1 2 3 4 5 5 5 5 5 5 5 5 5 \r\n" + 
			"4 4 4 4 4 3 3 2 3 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
			"4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 \r\n" + 
			"4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 \r\n" + 
			"4 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
			"3 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
			"3 3 3 3 3 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 \r\n" + 
			"3 3 3 3 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 \r\n" + 
			"4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 \r\n" + 
			"4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 4 4 4 4 4 4 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 3 3 3 3 4 4 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 4 4 4 4 3 3 3 3 4 4 4 4 ";
}