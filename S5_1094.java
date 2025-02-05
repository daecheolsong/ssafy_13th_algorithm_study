package algo;

import java.util.Scanner;

public class S5_1094 {
	static int stick = 64;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int count = 0;
		
		while (X > 0) {
			if (X / 64 == 1) {
				count++;
				X = X % 64;
			}
			if (X / 32 == 1) {
				count++;
				X = X % 32;
			}
			if (X / 16 == 1) {
				count++;
				X = X % 16;
			}
			if (X / 8 == 1) {
				count++;
				X = X % 8;
			}
			if (X / 4 == 1) {
				count++;
				X = X % 4;
			}
			if (X / 2 == 1) {
				count++;
				X = X % 2;
			}
			if (X / 1 == 1) {
				count++;
				X = X % 1;
			}
		}
		System.out.println(count);
		sc.close();
	}

}
