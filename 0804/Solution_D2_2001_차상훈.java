package com.ssafy.Algorithm_03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_D2_2001_차상훈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int Test_case = Integer.parseInt(br.readLine());
		for (int i = 1; i <= Test_case; i++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int max = 0;
			int[][] nums = new int[N][N];
			for (int x = 0; x < N; x++) {
				String[] lineNums = br.readLine().split(" ");
				for (int y = 0; y < N; y++) {
					nums[x][y] = Integer.parseInt(lineNums[y]);
				}
			}
			
			for (int x = 0; x <= N - M; x++) {
				for (int y = 0; y <= N - M; y++) {
					int sum = 0;
					for (int a = x; a < x + M; a++) {
						for (int b = y; b < y + M; b++) {
							sum += nums[a][b];
						}
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			System.out.println("#" + i + " " + max);
		}
	}

}
