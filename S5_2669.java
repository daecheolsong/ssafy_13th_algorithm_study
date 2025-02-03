package com.ssafy.ws.step3;

import java.util.Scanner;

public class S5_2669 {
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		int sum = 0;
		
		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			//System.out.printf("%d, %d", x1, x2 );
			//System.out.println();
			
			for (int j = x1 + 1; j <= x2; j++) {
				for (int k = y1 + 1; k <= y2; k++) {
					map[j][k] = 1;
				}
			}
		}
			
		for (int x = 1; x <= 100; x++) {
			for(int y = 1; y <= 100; y++) {
				sum += map[x][y];
			}
		}
		System.out.println(sum);
	}
}
