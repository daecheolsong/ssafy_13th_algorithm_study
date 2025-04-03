import java.util.*;
import java.io.*;

public class G5_2467 {
	static int N;
	static int[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = 0;
		int max = N-1;
		int num = Integer.MAX_VALUE;
		int num1 = 0;
		int num2 = 0;
		
		while (min < max) {
			int sum = list[min] + list[max];
			if (Math.abs(sum) < num) {
				num = Math.abs(sum);
				num1 = list[min];
				num2 = list[max];
				
			}
			if (sum > 0) {
				max--;
			}
			else min++;
		}
		
		System.out.println(num1 + " " + num2);

	}

}
