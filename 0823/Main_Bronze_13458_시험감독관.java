package com.ssafy.bronze_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Bronze_13458_시험감독관 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws Exception, IOException {
		input = new BufferedReader(new StringReader(src));
		int t = Integer.parseInt(input.readLine());
		int arr[] = new int[t];

		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}

		tokens = new StringTokenizer(input.readLine());
		int a = Integer.parseInt(tokens.nextToken());			// 총감독관
		int b = Integer.parseInt(tokens.nextToken());			// 부감독관

		int count = 0;
		for (int i = 0; i < t; i++) {							// 시험장별 인원에 대한 해결
			if (arr[i] <= a) {									// 총감독관의 개인 역량으로 가능 시 종료
				count++;
				continue;
			} else {
				arr[i] -= a;									// 총감독관 관리 인원 마이너스
				count++;										// 총감독관 카운트

				if (arr[i] % b == 0)							// 부감독 관리(위와 동일)
					count += arr[i] / b;
				else if (arr[i] % b != 0)
					count += arr[i] / b + 1;
			}
		}
		System.out.println(count);
	}

	private static String src = "5\r\n" + 
			"10 9 10 9 10\r\n" + 
			"7 2";
}