package com.ssafy.Algorithm_25;

import java.io.*;
import java.util.*;

public class Solution_2105_차상훈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int[][] map;
	static boolean[][] visited;
	static int tc, n, m, start_i, start_j, next_i, next_j, time, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tc = Integer.parseInt(input.readLine());
		for (int t = 1; t <= tc; t++) {
			tokens = new StringTokenizer(input.readLine());
			n = Integer.parseInt(tokens.nextToken());
			m = Integer.parseInt(tokens.nextToken());
			start_i = Integer.parseInt(tokens.nextToken());
			start_j = Integer.parseInt(tokens.nextToken());
			time = Integer.parseInt(tokens.nextToken());
			
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				tokens = new StringTokenizer(input.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			ans = 1;
			bfs(new Pair(start_i, start_j, time-1));
			System.out.println("#"+t + " "+ans);
		}
	}
	
	static void bfs(Pair p) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(p);
		visited = new boolean[n][m];
		visited[p.i][p.j]=true;
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int check = map[pair.i][pair.j];
			
			if(check == 1) {
				for (int k = 0; k < 4; k++) {
					next_i = pair.i+dr[k];
					next_j = pair.j+dc[k];
					
					if (next_i<0 || next_j<0 || next_i>=n || next_j>=m) continue;
					
					if(k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if(k == 1 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if( k == 2 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if( k == 3 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;
					
					if (!visited[next_i][next_j] && pair.distance > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Pair(next_i, next_j, pair.distance - 1));
						ans++;
					}
				}
			}else if(check==2) {
				for (int k = 1; k < 4; k+=2) {
					next_i = pair.i+dr[k];
					next_j = pair.j+dc[k];
					
					if (next_i<0 || next_j<0 || next_i>=n || next_j>=m) continue;
					
					if(k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if(k == 1 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if( k == 2 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if( k == 3 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;
					
					if (!visited[next_i][next_j] && pair.distance > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Pair(next_i, next_j, pair.distance - 1));
						ans++;
					}
				}
			}else if(check==3) {
				for (int k = 0; k < 4; k+=2) {
					next_i = pair.i+dr[k];
					next_j = pair.j+dc[k];
					
					if (next_i<0 || next_j<0 || next_i>=n || next_j>=m) continue;
					
					if(k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if(k == 1 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if( k == 2 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if( k == 3 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;
					
					if (!visited[next_i][next_j] && pair.distance > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Pair(next_i, next_j, pair.distance - 1));
						ans++;
					}
				}
			}else if(check==4) {
				for (int k = 0; k < 4; k+=3) {
					next_i = pair.i+dr[k];
					next_j = pair.j+dc[k];
					
					if (next_i<0 || next_j<0 || next_i>=n || next_j>=m) continue;
					
					if(k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if(k == 1 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if( k == 2 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if( k == 3 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;
					
					if (!visited[next_i][next_j] && pair.distance > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Pair(next_i, next_j, pair.distance - 1));
						ans++;
					}
				}
			}else if(check==5) {
				for (int k = 0; k < 2; k++) {
					next_i = pair.i+dr[k];
					next_j = pair.j+dc[k];
					
					if (next_i<0 || next_j<0 || next_i>=n || next_j>=m) continue;
					
					if(k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if(k == 1 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if( k == 2 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if( k == 3 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;
					
					if (!visited[next_i][next_j] && pair.distance > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Pair(next_i, next_j, pair.distance - 1));
						ans++;
					}
				}
			}else if(check==6) {
				for (int k = 1; k < 3; k++) {
					next_i = pair.i+dr[k];
					next_j = pair.j+dc[k];
					
					if (next_i<0 || next_j<0 || next_i>=n || next_j>=m) continue;
					
					if(k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if(k == 1 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if( k == 2 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if( k == 3 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;
					
					if (!visited[next_i][next_j] && pair.distance > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Pair(next_i, next_j, pair.distance - 1));
						ans++;
					}
				}
			} else if(check==7) {
				for (int k = 2; k < 4; k++) {
					next_i = pair.i+dr[k];
					next_j = pair.j+dc[k];
					
					if (next_i<0 || next_j<0 || next_i>=n || next_j>=m) continue;
					
					if(k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if(k == 1 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if( k == 2 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if( k == 3 && (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;
					
					if (!visited[next_i][next_j] && pair.distance > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Pair(next_i, next_j, pair.distance - 1));
						ans++;
					}
				}
			}
		}
	}
	static class Pair{
		int i, j, distance;
		
		public Pair(int i, int j, int distance) {
			this.i=i;
			this.j=j;
			this.distance = distance;
		}
	}
	
	public static String src = 
			"5\r\n" + 
			"5 6 2 1 3\r\n" + 
			"0 0 5 3 6 0\r\n" + 
			"0 0 2 0 2 0\r\n" + 
			"3 3 1 3 7 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"5 6 2 2 6\r\n" + 
			"3 0 0 0 0 3\r\n" + 
			"2 0 0 0 0 6\r\n" + 
			"1 3 1 1 3 1\r\n" + 
			"2 0 2 0 0 2\r\n" + 
			"0 0 4 3 1 1\r\n" + 
			"10 10 4 3 9\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 7 5 0 5 0 0 0\r\n" + 
			"0 0 3 2 2 6 0 0 0 0\r\n" + 
			"0 4 7 2 2 2 7 0 0 4\r\n" + 
			"0 3 0 1 1 2 2 0 0 5\r\n" + 
			"0 5 6 1 1 1 1 6 2 5\r\n" + 
			"7 4 1 2 0 0 4 6 0 0\r\n" + 
			"5 3 1 7 0 2 2 6 5 7\r\n" + 
			"7 3 2 1 1 7 1 0 2 7\r\n" + 
			"3 4 0 0 4 0 5 1 0 1\r\n" + 
			"20 20 13 11 13\r\n" + 
			"0 0 0 1 4 4 4 0 0 0 0 0 0 0 0 1 2 3 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 4 2 7 7 2 0 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 6 2 4 4 2 0 4 7 0 6 0\r\n" + 
			"0 0 0 7 5 5 3 0 0 7 5 0 5 6 4 2 6 3 1 5\r\n" + 
			"0 0 0 1 2 6 3 3 7 0 3 6 2 4 5 6 7 7 5 7\r\n" + 
			"0 0 0 3 7 6 1 5 3 3 4 5 7 6 0 4 3 3 1 1\r\n" + 
			"0 1 2 1 5 6 1 6 1 6 5 1 6 0 0 3 4 1 7 6\r\n" + 
			"0 2 3 2 2 7 3 0 0 3 2 5 2 1 0 6 5 1 6 5\r\n" + 
			"0 2 5 7 0 7 1 3 3 4 1 3 3 0 2 3 3 2 4 1\r\n" + 
			"4 0 0 7 2 4 2 2 1 3 1 6 5 5 6 2 5 1 1 6\r\n" + 
			"5 6 4 0 3 6 5 2 2 6 1 2 0 1 7 5 7 2 2 2\r\n" + 
			"1 6 3 1 4 4 1 0 3 0 4 2 7 2 0 2 3 6 2 5\r\n" + 
			"1 5 7 2 1 1 4 4 2 1 0 2 7 1 6 2 6 6 2 2\r\n" + 
			"3 7 0 6 5 0 4 0 6 6 7 1 3 1 1 1 5 1 6 6\r\n" + 
			"0 4 0 1 6 2 1 0 7 0 4 2 5 2 7 0 2 7 1 6\r\n" + 
			"0 7 3 0 1 7 6 2 0 0 4 2 4 1 3 3 7 0 1 3\r\n" + 
			"0 1 1 4 3 7 4 5 2 2 4 7 4 7 7 4 6 0 1 6\r\n" + 
			"0 5 2 2 1 4 6 3 7 0 6 3 5 0 0 6 4 4 2 1\r\n" + 
			"0 1 2 4 5 6 0 2 0 0 5 6 2 4 6 4 7 6 3 7\r\n" + 
			"7 7 4 2 3 0 0 4 0 0 7 2 7 5 6 1 4 5 5 4\r\n" + 
			"50 50 20 12 18\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 4 5 0 0 0 0 0 4 2 0 5 2 1 5 3 3 0 0 4 0 5 1 7 2 6 0 7 0 0 0 2 0 0 0 0 0 0 0\r\n" + 
			"6 7 0 0 0 0 0 0 0 0 0 0 4 5 5 3 6 3 0 2 3 3 0 0 5 6 1 5 3 4 7 6 2 2 1 1 6 5 6 4 6 2 0 0 0 0 2 3 1 0\r\n" + 
			"0 2 6 5 7 6 0 0 0 0 0 0 6 2 0 5 6 2 0 4 1 5 0 0 2 0 7 7 0 6 0 6 2 2 4 1 2 2 1 6 6 6 0 2 2 5 0 6 5 0\r\n" + 
			"0 0 0 4 7 2 7 3 7 0 0 0 0 6 7 6 5 1 1 1 2 2 1 3 1 2 7 6 1 2 1 2 4 1 6 1 1 7 3 1 6 6 6 1 1 1 7 0 0 0\r\n" + 
			"0 0 0 5 4 0 6 3 3 7 0 0 0 6 4 3 2 5 3 1 6 1 0 4 1 0 5 7 6 3 1 1 3 6 1 1 6 3 6 7 3 3 6 5 0 7 2 2 4 6\r\n" + 
			"0 6 0 7 6 0 7 4 0 5 3 0 4 3 2 0 5 7 3 0 1 3 6 7 7 5 1 7 5 2 0 5 3 1 3 7 1 1 1 5 2 5 1 3 6 7 7 6 4 3\r\n" + 
			"5 2 0 2 6 5 0 5 6 1 6 5 5 1 7 1 2 3 6 5 1 6 7 7 6 4 1 7 5 2 0 1 3 4 6 4 5 7 2 6 5 6 2 5 6 5 6 5 1 6\r\n" + 
			"1 2 0 7 0 5 5 0 7 6 2 2 1 3 5 5 3 6 3 7 6 4 1 3 1 3 7 0 3 7 0 2 5 6 1 3 4 1 5 1 7 4 1 7 7 0 4 7 5 5\r\n" + 
			"7 6 0 3 5 1 4 0 5 2 5 0 1 3 5 5 4 4 6 1 6 5 7 6 2 1 6 5 5 3 0 5 7 1 1 3 6 2 2 2 4 5 7 4 5 1 1 0 7 3\r\n" + 
			"2 5 4 0 3 1 4 5 6 3 7 0 4 5 3 6 4 5 1 7 4 7 3 1 1 7 7 1 1 5 6 4 7 1 2 6 4 1 7 2 7 1 6 0 5 0 0 0 1 0\r\n" + 
			"3 0 2 5 1 7 1 1 1 6 5 1 3 1 3 1 1 7 1 3 6 5 5 3 1 3 1 6 2 3 2 6 6 1 1 7 5 7 5 7 1 6 0 3 5 1 5 3 0 0\r\n" + 
			"0 0 3 2 0 1 4 1 4 1 0 7 3 2 2 4 2 4 4 6 1 1 1 7 2 4 7 4 3 6 3 5 1 6 1 3 7 7 2 6 3 2 1 0 4 6 2 6 3 0\r\n" + 
			"0 0 5 4 7 2 4 6 4 1 6 7 2 2 1 6 2 1 5 4 7 2 2 1 0 7 6 1 7 2 5 7 0 4 1 6 4 0 3 0 0 5 5 0 7 7 0 3 0 0\r\n" + 
			"0 0 6 4 3 1 3 1 4 7 2 1 2 4 3 4 1 6 2 1 5 1 1 6 0 7 2 7 2 4 7 4 0 3 7 7 3 3 5 2 0 4 3 0 4 2 0 1 3 5\r\n" + 
			"0 1 0 5 6 4 4 6 5 7 0 6 1 4 5 6 2 1 2 4 4 1 1 2 6 1 6 2 0 3 7 3 0 0 5 1 7 6 6 6 1 3 4 2 1 0 7 0 5 5\r\n" + 
			"0 7 2 1 4 2 7 3 0 2 1 4 3 5 1 1 1 1 7 1 4 4 1 7 6 0 1 2 0 5 2 0 0 0 5 4 0 3 7 5 3 1 4 1 2 7 2 6 6 4\r\n" + 
			"0 1 3 0 3 4 6 3 4 2 4 0 7 5 1 1 2 7 1 6 4 2 2 0 5 6 3 3 1 1 0 0 0 3 0 4 5 4 3 1 1 6 1 6 2 0 1 4 7 7\r\n" + 
			"0 3 0 0 2 6 1 4 7 5 1 4 3 2 5 1 4 3 6 3 0 2 4 5 7 5 6 2 0 5 6 3 6 4 6 2 0 0 6 0 7 2 2 6 0 0 0 0 0 0\r\n" + 
			"0 6 7 1 6 4 3 6 0 2 6 7 6 2 1 6 6 6 2 0 0 7 3 0 1 1 2 0 0 0 3 1 6 7 5 6 4 1 7 5 2 0 2 6 0 0 0 0 4 0\r\n" + 
			"0 6 7 7 3 3 0 2 0 1 6 4 1 1 1 6 2 3 3 4 2 3 5 0 5 7 7 6 2 7 2 7 3 1 0 5 6 7 1 6 4 1 5 0 0 0 0 0 0 0\r\n" + 
			"0 7 3 0 4 3 0 0 6 6 0 5 1 1 1 1 1 6 0 0 7 0 0 0 2 4 3 2 3 3 6 0 0 1 0 2 6 7 3 4 0 3 2 4 0 0 0 0 0 7\r\n" + 
			"0 0 4 7 2 0 0 0 1 4 2 4 7 7 2 4 2 4 0 5 6 0 0 0 7 0 2 7 4 4 1 6 1 4 2 3 6 2 0 6 5 3 5 0 3 5 6 0 0 1\r\n" + 
			"0 0 7 4 7 0 3 0 4 4 6 2 4 7 0 5 7 1 3 6 5 6 6 7 3 3 6 6 4 2 0 0 3 0 4 7 2 6 4 0 6 2 4 6 7 1 7 2 7 1\r\n" + 
			"0 0 2 6 0 0 6 5 0 4 1 2 2 2 2 7 2 1 0 4 6 4 1 0 1 1 2 2 0 4 4 2 0 0 3 0 3 6 2 2 7 6 6 0 4 6 0 2 2 2\r\n" + 
			"0 0 4 4 7 1 1 1 7 3 7 6 2 3 3 0 5 0 0 6 1 2 6 3 1 7 0 4 7 4 3 6 1 5 1 0 3 7 4 0 3 0 5 6 2 0 0 3 0 5\r\n" + 
			"0 0 7 3 0 5 4 0 7 4 0 0 4 5 7 1 3 2 3 3 5 3 5 3 5 5 5 5 4 2 3 6 0 3 1 7 2 4 5 3 0 0 5 3 6 0 0 7 3 6\r\n" + 
			"0 0 3 5 0 0 1 1 1 0 0 0 5 3 5 5 1 2 7 0 4 3 1 6 7 1 5 7 4 4 5 7 0 3 6 3 3 7 7 4 1 3 5 2 0 0 0 7 7 4\r\n" + 
			"0 0 7 6 3 5 0 7 2 7 7 5 4 0 0 7 0 4 0 0 3 2 3 1 5 7 4 6 0 3 5 5 2 0 6 0 0 0 2 1 1 4 3 6 2 0 5 1 1 6\r\n" + 
			"0 0 1 0 4 1 0 2 5 0 0 0 6 7 3 7 0 0 0 0 4 3 3 3 0 1 0 0 0 1 5 1 5 4 5 1 7 0 0 5 0 5 6 0 3 2 5 0 3 4\r\n" + 
			"0 0 0 0 0 4 0 2 3 1 6 6 6 3 5 3 6 0 0 0 4 7 0 6 1 7 1 0 0 5 5 2 5 1 0 1 1 3 3 4 1 4 2 0 6 3 0 0 6 4\r\n" + 
			"6 4 2 2 0 0 0 3 3 0 0 1 4 0 5 0 2 0 7 0 1 7 7 1 5 7 0 0 0 3 1 5 5 6 0 6 2 6 4 0 7 6 5 1 3 3 7 0 2 5\r\n" + 
			"0 0 0 7 7 0 0 4 4 3 1 6 1 0 1 3 3 1 4 5 7 3 7 0 0 4 0 0 0 7 3 7 2 2 0 1 5 0 7 5 5 2 5 1 0 2 0 0 3 2\r\n" + 
			"0 0 0 3 0 0 0 0 1 2 6 7 1 6 7 0 3 5 2 7 3 0 4 5 2 0 0 0 0 2 5 7 3 7 5 6 0 0 2 2 5 4 7 6 4 5 1 4 4 6\r\n" + 
			"0 4 3 0 0 0 0 3 5 6 3 2 0 3 6 0 6 0 0 1 4 3 6 2 4 7 4 7 1 5 0 4 0 0 2 0 0 0 3 7 6 1 2 5 3 5 2 3 3 3\r\n" + 
			"0 0 0 1 4 0 0 2 1 0 2 0 0 1 7 3 4 3 3 4 7 0 6 7 4 7 3 1 6 1 7 3 4 4 7 5 2 1 3 7 2 5 2 3 3 2 3 0 1 2\r\n" + 
			"0 0 0 0 1 1 0 0 5 7 3 6 6 0 0 6 5 4 2 7 0 0 4 5 5 0 5 7 3 3 0 3 5 5 3 6 0 0 3 5 4 0 0 7 5 1 6 0 0 7\r\n" + 
			"0 0 0 0 5 6 3 1 5 2 0 7 7 7 0 0 1 0 3 6 4 1 6 7 2 1 6 5 2 0 0 7 4 5 0 0 0 0 0 6 6 0 0 5 6 0 2 3 4 5\r\n" + 
			"0 0 7 1 0 1 6 5 6 0 0 5 4 5 7 1 1 6 5 2 2 0 3 7 4 5 2 6 4 0 0 3 4 0 0 0 0 0 0 7 7 7 7 6 4 3 4 4 0 0\r\n" + 
			"0 0 0 1 3 0 0 3 7 1 1 0 4 1 4 4 2 6 1 6 2 2 7 4 2 4 1 7 1 6 4 3 3 1 3 4 0 0 3 2 0 2 0 1 3 3 4 7 1 5\r\n" + 
			"0 0 0 3 4 0 0 2 0 5 5 0 0 1 4 4 0 4 0 1 6 6 4 2 1 0 0 3 7 0 4 3 3 2 3 5 3 5 0 4 0 5 0 3 0 7 7 3 5 6\r\n" + 
			"0 0 0 7 2 0 0 4 2 2 6 2 2 5 0 5 0 3 4 3 5 5 2 0 4 0 0 5 0 0 4 1 6 4 4 3 4 0 0 5 0 1 1 2 0 7 3 4 0 4\r\n" + 
			"0 0 1 1 4 4 1 0 0 0 3 5 4 5 4 2 7 4 6 1 6 7 0 3 0 7 1 7 6 6 3 0 5 7 6 6 4 7 3 4 5 0 0 0 0 6 1 1 5 3\r\n" + 
			"0 0 4 2 5 7 4 4 2 1 2 1 3 4 7 2 7 2 1 6 3 3 0 7 5 6 6 4 5 5 3 3 2 7 5 3 1 4 7 0 0 0 0 0 0 3 1 5 6 5\r\n" + 
			"0 0 0 4 4 1 0 0 6 0 0 7 5 7 5 1 7 3 6 0 2 4 3 4 7 7 3 0 0 0 1 5 5 0 6 7 7 7 4 4 3 6 3 7 5 0 1 1 0 2\r\n" + 
			"0 0 0 1 3 4 7 2 5 0 0 4 4 0 5 2 2 0 1 7 0 1 1 3 6 5 2 6 2 7 7 3 6 7 1 3 4 6 7 5 3 7 4 6 0 0 0 4 3 1\r\n" + 
			"0 0 0 2 1 6 3 5 4 0 0 6 0 0 6 7 0 0 5 2 0 7 7 0 7 0 0 7 7 6 0 0 1 1 0 1 0 1 3 1 0 0 4 7 7 0 0 0 2 6\r\n" + 
			"0 0 0 2 4 0 6 7 2 4 1 5 6 3 0 0 0 0 4 2 7 1 1 5 2 0 0 7 2 2 3 1 3 5 5 7 7 4 0 3 4 2 3 0 0 4 6 6 0 1\r\n" + 
			"0 0 0 4 6 1 0 3 6 4 7 3 5 0 0 0 0 0 0 7 0 0 3 6 2 1 0 2 3 4 6 7 5 0 7 0 5 4 5 1 5 0 0 0 0 4 5 3 1 0\r\n" + 
			"1 3 6 5 5 2 3 7 6 1 0 6 7 3 2 5 6 7 6 6 0 0 7 1 0 5 5 0 3 0 2 0 7 4 5 3 2 5 1 5 3 0 0 0 1 2 0 1 0 0\r\n" + 
			"1 7 3 0 2 0 7 0 4 6 1 1 5 0 7 0 5 7 7 2 6 0 0 1 0 2 3 3 4 2 7 5 3 7 0 0 4 6 6 6 3 0 0 0 7 7 7 5 7 2\r\n";
}