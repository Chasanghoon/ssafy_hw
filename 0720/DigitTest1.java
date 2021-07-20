package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		//입력 받기
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] data = input.split(" ");
		//배열 및 변수 선언, 변수 전달받기
		int a;
		int[] arr = new int[data.length];		
		int[] count = new int[10];

		//기존 data에 저장된 string 변수를 int 타입으로 변환
		for (int i = 0; i < data.length; i++) {
			arr[i] = Integer.parseInt(data[i]);
		}

		//arr[i] 내부 데이터가 0이 아닌 경우 10으로 나누어 a에 저장 후 count에 추가
		for (int i = 0; i < data.length; i++) {
			if (arr[i] != 0) {
				a = arr[i] / 10;
				count[a]++;
			}
		}

		//출력
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				System.out.println(i + " : " + count[i]);
			}
		}
	}
}
