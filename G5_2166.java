import java.util.*;
import java.io.*;

public class G5_2166 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] list = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (double) list[i][0] * list[(i+1) % N][1];
			sum -= (double) list[i][1] * list[(i+1) % N][0];
		}
		
		System.out.printf("%.1f", Math.abs(sum / 2));

	}

}
