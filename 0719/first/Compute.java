package com.java.first;

import java.util.Scanner;

public class Compute {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        
        int mul = num1 * num2;
        int div = num1 / num2;
        System.out.println("곱=" + mul);
        System.out.println("몫=" + div);
	}
}