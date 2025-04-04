import java.util.*;
import java.io.*;

public class G4_11054 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] inc = new int[N];
		int[] dec = new int[N];
		int[] sum = new int[N];
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			inc[i] = 1;
			dec[i] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (list[j] < list[i]) {
					inc[i] = Math.max(inc[i], inc[j]+1);
				}
			}
		}
		
		for (int i = N-1; i >= 0; i--) {
			for (int j = N-1; j > i; j--) {
				if (list[j] < list[i]) {
					dec[i] = Math.max(dec[i], dec[j]+1);
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.print(inc[i]);
//		}
//		
//		System.out.println();
//		
//		for (int i = 0; i < N; i++) {
//			System.out.print(dec[i]);
//		}
//		
//		System.out.println();
		
		for (int i = 0; i < N; i++) {
			sum[i] = inc[i]+dec[i] -1;
			result = Math.max(result, sum[i]);
		}
		
		System.out.println(result);

	}

}
