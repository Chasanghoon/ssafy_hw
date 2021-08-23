package com.ssafy.test;

import java.io.*;
import java.util.*;

public class Solution_D2_2005_파스칼의삼각형3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		int test_case=Integer.parseInt(input.readLine());
		for (int i = 0; i < test_case; i++) {
			int t= Integer.parseInt(input.readLine());
			int arr[][] = new int[t][t];
			for (int j = 0; j < t; j++) {
				for (int j2 = 0; j2 <= j; j2++) {
					if(j==j2) {
						arr[j][j2]=1;
					}else if(j2==0) {
						arr[j][j2]=1;
					}else {
						arr[j][j2]=arr[j-1][j2]+arr[j-1][j2-1];
					}
				}
			}
			System.out.println("#" + t);
			for(int n=0; n<t; n++) {
				for(int m=0; m<=n; m++) {
					System.out.print(arr[n][m]+" ");
				}
				System.out.println();
			}
		}
	}
	
	public static String src=
			"10\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"5\r\n" + 
			"6\r\n" + 
			"7\r\n" + 
			"8\r\n" + 
			"9\r\n" + 
			"10";
}
