import java.util.Scanner;
import java.util.Arrays;
public class Main {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		
		int antenna = arr[(N-1) / 2];
		System.out.print(antenna);
		sc.close();
		
	}
}