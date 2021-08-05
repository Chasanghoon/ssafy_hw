package com.ssafy.Algorithm_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_gold5_2493_차상훈 {

	public static void main(String[] args) throws Exception, IOException {
		Stack<int[]> st = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stt = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(stt.nextToken());
			while (!st.isEmpty()) {
				if (st.peek()[1] >= num) {
					System.out.print(st.peek()[0] + " ");
					break;
				}
				st.pop();
			}
			if (st.isEmpty()) {
				System.out.print("0 ");
			}
			st.push(new int[] { i, num });
		}
	}
}
