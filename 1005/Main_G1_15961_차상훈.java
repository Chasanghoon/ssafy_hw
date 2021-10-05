package com.ssafy.Algorithm_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G1_15961_차상훈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens; 
	static int n, d, k, c;
	static int[] arr, visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());		// 회전 초밥 벨트에 놓인 접시의 수
		d = Integer.parseInt(tokens.nextToken());		// 초밥의 가짓수
		k = Integer.parseInt(tokens.nextToken());		// 연속해서 먹는 접시의 수
		c = Integer.parseInt(tokens.nextToken());		// 쿠폰번호
		arr = new int[n];		
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}
		
		visited = new int[d+1];		// 먹은 스시 갯수를 저장할 배열
		
		System.out.println(slide());
	}

	static int slide() {
		
		int inSlide = 0, chance;
		
		for (int i = 0; i < k; i++) {
			if(visited[arr[i]]==0) {		//k개의 슬라이드에 담기
				inSlide++;
			}
			visited[arr[i]]++;
		}
		chance = inSlide;
		for (int i = 1; i < n; i++) {
            if (chance <= inSlide) {
                if (visited[c] == 0) {
                    chance = inSlide + 1;
                } else {
                    chance = inSlide;
                }
            }
            
            //슬라이드 이동 1
            visited[arr[i - 1]]--;
            if (visited[arr[i - 1]] == 0) {
                inSlide--;
            }
            
            //슬라이드 이동2
            if (visited[arr[(i + k - 1) % n]] == 0) {
                inSlide++;
            }
            visited[arr[(i + k - 1) % n]]++;
        }
        return chance;
	
	}

	public static String src =
			"8 50 4 7\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"25\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"7\r\n" + 
			"30";
}