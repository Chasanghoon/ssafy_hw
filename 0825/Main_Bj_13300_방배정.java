package com.ssafy.IMTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_Bj_13300_방배정 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int TotalMember = Integer.parseInt(tokens.nextToken());
		int MaxRoom = Integer.parseInt(tokens.nextToken());
		int[][] RoomCheck = new int[7][2];

		int total = 0;

		for (int i = 1; i <= TotalMember; i++) {
			tokens = new StringTokenizer(input.readLine());
			long S = Integer.parseInt(tokens.nextToken());
			int G = Integer.parseInt(tokens.nextToken());
			if (S % 2 == 0)
				RoomCheck[G][0]++;
			else
				RoomCheck[G][1]++;
		}

		for (int k = 0; k < 2; k++) {
			for (int i = 1; i <= 6; i++) {
				if (RoomCheck[i][k] > 0 && RoomCheck[i][k] <= MaxRoom) {
					total++;
				}
				if (RoomCheck[i][k] > MaxRoom) {
					if (RoomCheck[i][k] % MaxRoom == 0) {
						total += RoomCheck[i][k] / MaxRoom;
					} else {
						total += RoomCheck[i][k] / MaxRoom + 1;
					}

				}
			}
		}
		System.out.println(total);
	}

	public static String src = "3 3\r\n" + 
			"0 3\r\n" + 
			"1 5\r\n" + 
			"0 6";
}
