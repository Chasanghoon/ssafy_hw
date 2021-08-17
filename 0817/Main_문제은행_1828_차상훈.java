package com.ssafy.Algorithm_11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.org.apache.regexp.internal.RE;

public class Main_문제은행_1828_차상훈 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static class Ref implements Comparable<Ref> {
		int min, max;

		public Ref(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(Ref o) {
			int gap = this.max - o.max;
			if (gap == 0) {
				gap = this.min - o.min;
			}
			return gap;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		int ref = T;
		Ref[] re = new Ref[T];

		for (int t = 0; t < T; t++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
			re[t] = new Ref(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
		}
		Arrays.sort(re);

		int ed1 = re[0].max;
		for (int i = 0; i < T - 1; i++) {
			if (ed1 >= re[i + 1].min) {
				ed1 = re[i].max;
				ref--;
			} else {
				ed1 = re[i + 1].max;
			}
		}

		System.out.println(ref);
	}

	private static String src = "4\r\n" + "-15 5\r\n" + "-10 36\r\n" + "10 73\r\n" + "27 44";

}
