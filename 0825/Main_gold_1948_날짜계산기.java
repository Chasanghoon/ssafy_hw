package com.ssafy.bronze_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_gold_1948_날짜계산기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, month[];
	static int month1, month2, day1, day2;
	
	public static void main(String[] args) throws Exception, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		int day_cal[] = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		for (int i = 1; i <= T; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			month1 = Integer.parseInt(tokens.nextToken())-1;
			day1 = Integer.parseInt(tokens.nextToken());
			month2 = Integer.parseInt(tokens.nextToken())-1;
			day2 = Integer.parseInt(tokens.nextToken());
			
			int monthsum1=0, monthsum2=0;
			
			for(int j=0; j<month1; j++) {
				monthsum1 += day_cal[j];
			}
			monthsum1 = monthsum1 + day1;
			
			for(int k=0; k<month2; k++) {
				monthsum2 += day_cal[k];
			}
			monthsum2 = monthsum2 + day2;
			
			int monthsumtotal = monthsum2-monthsum1+1;
			
			System.out.println("#"+i +" "+(monthsumtotal));
		}
	}
	
	private static String src =
			"10\r\n" + 
			"3 1 3 31\r\n" + 
			"5 5 8 15\r\n" + 
			"7 17 12 24\r\n" + 
			"3 22 5 10\r\n" + 
			"2 13 6 12\r\n" + 
			"4 30 11 9\r\n" + 
			"7 10 9 28\r\n" + 
			"6 30 9 20\r\n" + 
			"4 19 12 12\r\n" + 
			"1 1 12 31\r\n" + 
			"5 23 9 12\r\n" + 
			"2 12 9 4";
}
