package com.ssafy.Algorithm_23;

import java.io.*;
import java.util.*;

public class Solution_5607_조합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output= new StringBuilder();
	static StringTokenizer tokens;
	static int cnt, n, r;
	static long MOD = 1234567891;
	static long up,down;
	static long factorial[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int tc = Integer.parseInt(input.readLine());
		
		factorial = new long[1000001];
		factorial[0] = 1;
		for(int i=1; i<1000001; i++) { 
			factorial[i] = (factorial[i-1]*i)%MOD; 
		}
		
		for (int t = 1; t <= tc; t++) {
			tokens = new StringTokenizer(input.readLine());
			n = Integer.parseInt(input.readLine());
			r = Integer.parseInt(input.readLine());
			
		}
	}
	
	private static void combi(int cnt, int start) {
	    
	  }
	
	public static String src=
			"1\r\n" + 
			"10 2";
}
