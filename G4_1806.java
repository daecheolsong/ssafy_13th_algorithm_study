import java.util.*;
import java.io.*;

public class G4_1806 {
	static int N,S;
	static int[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		list = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int len = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = list[i];
			for (int j = i+1; j < N; j++) {
				if(j-i > len) break;
				if(sum > S) {
					len = j-i;
					break;
				}
				else {
					sum += list[j];
				}
			}
		}
		
		System.out.println(len);
		
	}

}
