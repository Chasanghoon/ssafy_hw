package com.ssafy.Algorithm_24;

import java.io.*;
import java.util.*;

public class Solution_5643_키순서 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N,M,sum1,sum2; 
	static ArrayList<Integer> arr1[],arr2[]; 
	static boolean visit[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " "); 
		int T = Integer.valueOf(tokens.nextToken()); 
		for (int tc = 1; tc <= T; tc++) { 
			N = Integer.valueOf(input.readLine()); 
			M = Integer.valueOf(input.readLine()); 
			arr1 = new ArrayList[N+1]; 
			arr2 = new ArrayList[N+1]; 
				for(int i=0;i<=N;i++) { 
					arr1[i]= new ArrayList<>(); 
					arr2[i] = new ArrayList<>(); 
				} 
				for (int i = 0; i < M; i++) { 
					tokens = new StringTokenizer(input.readLine(), " "); 
					int a = Integer.valueOf(tokens.nextToken()); 
					int b = Integer.valueOf(tokens.nextToken()); 
					arr1[a].add(b); 
					arr2[b].add(a); 
				} 
				int ans=0; 
				for(int i=1;i<=N;i++) { 
					visit = new boolean[N+1]; 
					sum1=0; 
					findUp(i); 
					visit = new boolean[N+1]; 
					sum2=0; 
					findDown(i); 
					if(sum1+sum2==N-1) { 
						ans++; 
					} 
				} 
			System.out.println("#"+tc+" "+ans); 
			} 
		} 
	
	static void findUp(int cur) { 
		visit[cur] = true; 
		for(int next : arr1[cur]) { 
			if(visit[next]) continue; 
			sum1++; 
			findUp(next); 
		} 
	} 
	
	static void findDown(int cur) { 
		visit[cur] = true; 
		for(int next : arr2[cur]) { 
			if(visit[next]) continue; 
			sum2++; 
			findDown(next); 
		}
	}
	
	static String src =
			"1\r\n" + 
			"6\r\n" + 
			"6\r\n" + 
			"1 5\r\n" + 
			"3 4\r\n" + 
			"5 4\r\n" + 
			"4 2\r\n" + 
			"4 6\r\n" + 
			"5 2";
}
