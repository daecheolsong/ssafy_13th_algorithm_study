simport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N,res, arr[], LIS[];


	public static void main(String[] args) throws IOException {
		
			init();
			lis();
			sb.append(res).append("\n");
		
		System.out.println(sb);
		
	}


	private static void lis() {
		LIS = new int[N + 1];
		for(int i= 0; i < N; i++) {
			LIS[arr[i]] = LIS[arr[i] - 1] + 1;
			res = Math.max(res, LIS[arr[i]]);
		}
		
		res = N - res;
	}


	private static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		res = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
	}
}
