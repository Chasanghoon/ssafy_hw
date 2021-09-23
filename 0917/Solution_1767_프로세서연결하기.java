package com.ssafy.Algorithm_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1767_프로세서연결하기{
	// static boolean visited[][];
	static int g[][];
	static int n;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<Core> ar;
	static int maxCore = Integer.MIN_VALUE>>2;
	static int minLine = Integer.MAX_VALUE>>2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
        
		for (int i = 0; i < testCase; i++) {
			n = Integer.parseInt(br.readLine().trim());
			g = new int[n][n];
            ar = new ArrayList<Core>();
			String[] str;
			for (int j = 0; j < n; j++) {
				str = br.readLine().split(" ");
				for (int k = 0; k < n; k++) {
					g[j][k] = Integer.parseInt(str[k]);
					if (g[j][k] == 1) {
						ar.add(new Core(j, k));
					}
				}
			}
            
			dfs(0, 0, 0);
			System.out.println("#" + (i + 1) + " " + minLine);
			ar.clear();
			maxCore = Integer.MIN_VALUE;
			minLine = Integer.MAX_VALUE;
		}
	}

	public static void dfs(int idx, int coreCnt, int lineLen) {

		if (idx == ar.size()) {
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				minLine = lineLen;

			} else if (coreCnt == maxCore) {
				if (minLine > lineLen) {
					minLine = lineLen;
				}
			}
			
			return;
		}
		Core c = ar.get(idx);

		for (int i = 0; i < 4; i++) {
        
			if (c.x == 0 || c.x == n - 1 || c.y == 0 || c.y == n - 1) {
				dfs(idx + 1, coreCnt + 1, lineLen);
				break;

			}
			int check = checkLine(i, c);
			int sx = c.x;
			int sy = c.y;
			if (check != -1) {
				dfs(idx + 1, coreCnt + 1, lineLen + check);
				for (int j = 0; j < check; j++) {
					sx += dx[i];
					sy += dy[i];
					g[sx][sy] = 0;

				}
			}

		}
		dfs(idx + 1, coreCnt, lineLen);
	}

	public static int checkLine(int i, Core c) {
		int line = 0;
		int sx = c.x + dx[i];
		int sy = c.y + dy[i];
		boolean check = false;
		while (true) {
			line++;
				if ((sx == 0 || sx == n - 1 || sy == 0 || sy == n - 1) && g[sx][sy] == 0) {
					check = true;
					break;
				}
				if (g[sx][sy] != 0) {
					check = false;
					break;
				}
			sx += dx[i];
			sy += dy[i];

		}
		sx = c.x;
		sy = c.y;
		
		if (check) {
			for (int idx = 0; idx < line; idx++) {
				sx += dx[i];
				sy += dy[i];
				g[sx][sy] = 2;

			}
			return line;
		}
		return -1;
	}
}
class Core {
	int x;
	int y;

	Core(int x, int y) {
		this.x = x;
		this.y = y;
	}
}