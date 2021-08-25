package com.ssafy.RCcar;

import java.io.*;
import java.util.*;

public class Solution_D2_1940_RC카 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		int test_case=Integer.parseInt(input.readLine());
		for (int i = 1; i <=test_case ; i++) {
			int sum=0;
			int V = 0;
			int n = Integer.parseInt(input.readLine());
			for (int j = 1; j <= n; j++) {
				tokens = new StringTokenizer(input.readLine());
				int mode=Integer.parseInt(tokens.nextToken());
				switch (mode) {
				case 0:
					break;
				case 1:
					V+=Integer.parseInt(tokens.nextToken());
					break;
				case 2:
					V-=Integer.parseInt(tokens.nextToken());
					break;
				}
				if(V<0) V=0;
				sum+=V;
			}
			System.out.println("#"+i+" "+sum);
		}
	}
	
	public static String src=
			"10\r\n" + 
			"2\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"3\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"5\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"8\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"10\r\n" + 
			"1 2\r\n" + 
			"1 1\r\n" + 
			"2 2\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"12\r\n" + 
			"1 2\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"1 1\r\n" + 
			"2 2\r\n" + 
			"2 2\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"15\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"20\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"2 1\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"2 1\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"2 2\r\n" + 
			"2 2\r\n" + 
			"25\r\n" + 
			"2 1\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"2 2\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"1 1\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"2 2\r\n" + 
			"0\r\n" + 
			"2 2\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"30\r\n" + 
			"2 1\r\n" + 
			"2 2\r\n" + 
			"2 2\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"2 2\r\n" + 
			"2 1\r\n" + 
			"1 2\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"2 2\r\n" + 
			"1 2\r\n" + 
			"2 2\r\n" + 
			"0\r\n" + 
			"1 2\r\n" + 
			"2 1\r\n" + 
			"2 2\r\n" + 
			"0\r\n" + 
			"1 1\r\n" + 
			"2 2\r\n" + 
			"";
}
