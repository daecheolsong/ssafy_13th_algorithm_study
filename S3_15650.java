package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class S3_15650 {

	static int N, R;
	static int[] input, numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		numbers = new int[R]; // 선택된 수 저장

		combination(0, 0);
	}

	static void combination(int cnt, int start) {
		if (cnt == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			// System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}
}
