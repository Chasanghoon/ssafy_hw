package com.ssafy.Algorithm_23;

import java.io.*;
import java.util.*;

public class Solution_5607_조합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int n, r;
	static long MOD = 1234567891;
	static long up, down;
	static long factorial[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int tc = Integer.parseInt(input.readLine());

		// 팩토리얼 초기화
		factorial = new long[1000001];
		factorial[0] = 1;
		for (int i = 1; i < 1000001; i++) {
			factorial[i] = (factorial[i - 1] * i) % MOD;
		}

		for (int t = 1; t <= tc; t++) {
			tokens = new StringTokenizer(input.readLine());
			n = Integer.parseInt(tokens.nextToken());
			r = Integer.parseInt(tokens.nextToken());
			
			// 분수로 되어있는 식					페르마의 소정리를 이용해 변경된 공식
			// nCr = (n!/(n-r)!*r!))%MOD = (n!*((n-r)!*r!)^(MOD-2))%MOD
			up = factorial[n] % MOD;
			down = ((factorial[r] % MOD) * (factorial[n - r] % MOD)) % MOD;

			// 중요: 100 ^ 1234567891-2
			System.out.println("#" + t + " " + ((up * pow(down, MOD - 2)) % MOD));
		}
	}

	private static long pow(long a, long b) {
		// 1일 경우 a를 그대로 출력
		if (b == 1) {
			return a;
		}
		// 분할정복(반씩 구하기)
		long half = pow(a, b / 2);
		
		//나머지면 반씩
		if (b % 2 == 0) {
			return (half * half) % MOD;
		//안나눠지면 a가 하나 남으니깐 한번 더 곱하기
		} else {
			// 나머지 연산의 분배법칙
			
			//return (half * half * a)%MOD; <- 숫자의 범위가 넘어가므로 한번더
			return ((half * half) % MOD * (a) % MOD) % MOD;
		}
	}

	public static String src = "1\r\n" + "10 2";
}
