package com.ssafy.Algorithm_21;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D7_1263_차상훈2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, max, min, totalCnt, map[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static ArrayList<int[]> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int tc = Integer.parseInt(input.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(input.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if ((i == 0 || i == N - 1 || j == 0 || j == N - 1) && map[i][j] == 1)
						continue; // 가장자리 코어는 패스
					// 코어 위치 리스트에 추가
					if (map[i][j] == 1) {
						list.add(new int[] { i, j });
						totalCnt++;
					}
				}
			}

			dfs(0, 0);
		}

	}

	private static void dfs(int index, int cCnt) {
		if (totalCnt - index + cCnt < max)
			return; // 남은 코어수 (totalCnt-index)

		if (index == totalCnt) {
			int res = getLength();
			if (max < cCnt) {
				max = cCnt;
				min = res;
			} else if (max == cCnt) {
				if (min > res)
					min = res;
			}
			return;
		}
		int[] cur = list.get(index);
		int x = cur[0];
		int y = cur[1];
		// 포함
		for (int d = 0; d < 4; d++) {
			// 현 방향으로 전선을 놓는 것이 가능한지 체크
			if (isAvailable(x, y, d)) {
				// 가능하다면 현 방향으로 전선 놓기(2)
				setStatus(x, y, d, 2);
				// 다음 코어로 넘어감
				go(index + 1, cCnt + 1);
				// 현방향으로 전선 놓았던거 되돌리기(0)
				setStatus(x, y, d, 0);
			}
		}
		// 비포함
	}

	public static String src = "3\r\n" + "7\r\n" + "0 0 1 0 0 0 0\r\n" + "0 0 1 0 0 0 0\r\n" + "0 0 0 0 0 1 0\r\n"
			+ "0 0 0 0 0 0 0\r\n" + "1 1 0 1 0 0 0\r\n" + "0 1 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n" + "9\r\n"
			+ "0 0 0 0 0 0 0 0 0\r\n" + "0 0 1 0 0 0 0 0 1\r\n" + "1 0 0 0 0 0 0 0 0\r\n" + "0 0 0 1 0 0 0 0 0\r\n"
			+ "0 1 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 1 0 0\r\n" + "0 0 0 1 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 1 0\r\n"
			+ "0 0 0 0 0 0 0 0 1\r\n" + "11\r\n" + "0 0 1 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0 0 1\r\n" + "0 0 0 1 0 0 0 0 1 0 0\r\n" + "0 1 0 1 1 0 0 0 1 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 1 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 1 0 0\r\n" + "0 0 0 0 0 0 1 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0\r\n";

}