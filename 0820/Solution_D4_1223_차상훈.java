package com.ssafy.Algorithm_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_1223_차상훈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
		public static void main(String[] args) throws NumberFormatException, IOException {
			input = new BufferedReader(new StringReader(src));
	        for (int t = 1; t <= 10; t++) {
	            int len = Integer.parseInt(input.readLine());
	            tokens = new StringTokenizer(input.readLine()," ");
	            String temp = tokens.nextToken();
	            Stack<Integer> sta = new Stack<Integer>();
	            sta.push(Integer.parseInt(temp.charAt(0)+""));
	            for (int i = 1; i < len-1; i += 2) {
	                if (temp.charAt(i) == '+')
	                	sta.push(Integer.parseInt(temp.charAt(i + 1)+""));
	                else
	                	sta.push(sta.pop() * Integer.parseInt(temp.charAt(i + 1)+""));
	            }
	            int result = 0;
	            while (!sta.isEmpty())
	                result += sta.pop();
	            System.out.println("#" + t+" " + result);
	        }
	    }
		private static String src =
				"101\r\n" + 
				"9+5*2+1+3*3*7*6*9*1*7+1+8*6+6*1*1*5*2*4*7+4*3*8*2*6+7*8*4*5+3+7+2+6+5+1+7+6+7*3*6+2+6+6*2+4+2*2+4*9*3\r\n" + 
				"79\r\n" + 
				"4+4*3*4*9+2+7*4*7+7*7*9*5*2+8*8+2*6*7*3*7*9*3*4+8+8*9+3+9+6+9+4*1+6*3+5+1+7+5*1\r\n" + 
				"113\r\n" + 
				"2+3+9*9+8+2*1+3*2*3*1+3*3+1+2+3*6*2*7*4+9+1+4+6+9*9*5+7+8+6+3+9*2+1+7+4+3+9*3*1+4*4+4*3*1+9*3+9*5*1*7*8+2+8+8*7+9\r\n" + 
				"89\r\n" + 
				"4*9+1+1*8+8*9*7+1*4*5*2*5+8*3*5+5+2*4+2+8+6*2*2+9+3*1*2+2*5+9*2*3*9+6+7*9+9*4+7+6+6*6+3+8\r\n" + 
				"77\r\n" + 
				"5+4+9+9*9*2+6*6*5+9+3*5+5*7*8*3*7*1*9*9+8+3+8*9*6+2*9*3+6*5+6*7*2+5+5*3+4*6+7\r\n" + 
				"119\r\n" + 
				"5+7+1+6+3+6*7+7+5*5*3*5*6*9+5*9*5*9+8+8+5*1*6*2+3+2+8+6+2+2*3*4+5*8*3*6*2*9+1*7*7*4*2+2*5+6+7+2*7*4+9*6*4*3*1*3*5+3*7+8\r\n" + 
				"115\r\n" + 
				"8*6+3*9*8*7*6*3+5*7*6*6+3*5+2*4*9*3+5+2+1*4*1*7+6*8+9+3+2+8*3+8*2+6*9+2*2*7+8*1*2+9*3+1+5*5*8+4*1*2*4*2*6*3*8*8+4+1\r\n" + 
				"91\r\n" + 
				"5*8*4+5*7+9*2+6+5*7+1*7*9+8+6*1*2+7+5*9*6*3+4*8*9*6*1*3+7*1+2+5+1*4*9+6*4+7*1*2*4*2+3+3*4+9\r\n" + 
				"107\r\n" + 
				"7*1+7+5+3*7*1*7+8*3*8+7+3*2*6*2+3+6*4+3+8+9*4+1+5*7*8+9+1+2+5+6*7+4*5*2+4+8*4+7+9*1*3*1+1*2*8+3+2+9*1*5*9+7\r\n" + 
				"109\r\n" + 
				"1+1+7+3*2+1+3*7*8+9*6+1+8*3*7+8*5*7*7+4*3*7*4+7+3+2*2+7+8*8*6+6*6*7+7*1*5*7+3+1*5+1*8*4+9+6+7*5+3+1*8*8*9+4+7";
	}


