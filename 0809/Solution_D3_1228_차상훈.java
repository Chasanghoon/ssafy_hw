package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_1228_차상훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case=1; test_case<=10; test_case++) {
			List<String> list = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				list.add(st.nextToken());
			}
			int cmd = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<cmd; i++) {
				String get = st.nextToken();
				int idx=0;
				int cnt=0;
				if(get.charAt(0) =='I') {
					idx = Integer.parseInt(st.nextToken());
					cnt = Integer.parseInt(st.nextToken());
				}
				for(int j=0; j<cnt; j++) {
					list.add(idx+j, st.nextToken());
				}
			}
			System.out.println();
			System.out.printf("#%d ", test_case);
			for(int i=0; i<10; i++) {
				System.out.print(list.get(i) + " ");
			}
		}
	}
}