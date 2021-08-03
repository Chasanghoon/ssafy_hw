package BOJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Solution_Silver4_1244_차상훈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//스위치의 개수
		int total = Integer.parseInt(br.readLine());
		int[] switches = new int[total];
		
		//스위치 string 받음
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<total; i++)
			switches[i] = Integer.parseInt(st.nextToken());
		
		//학생의 수
		int stuCnt = Integer.parseInt(br.readLine());
		for(int i=0; i<stuCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			//남학생
			if(gender == 1) {
				//뽑은 수의 배수 위치에 있는 스위치의 상태 변경
				for(int j=0; j<total; j++)
					if((j+1) % number == 0)
						switches[j] = switches[j] == 0? 1: 0;
			}
			//여학생
			else {
				//뽑은 수를 중심으로 좌우가 대칭이면 상태 변경
				switches[number - 1] = switches[number - 1] == 0 ? 1 : 0;
				for(int j=1; j<total/2; j++) {
					if(number - 1 + j >= total || number - 1 - j < 0)
						break;
					if(switches[number - 1 - j] == switches[number - 1 + j]) {
						switches[number - 1 - j] = switches[number - 1 - j] == 0 ? 1 : 0;
						switches[number - 1 + j] = switches[number - 1 + j] == 0 ? 1 : 0;
					}
					//대칭 아닌것이 나오면 종료
					else break; 
				}
			}
		}
		
		//한 줄에 20개씩 출력
		for(int i=0; i<total; i++) {
			System.out.print(switches[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
	}
}
