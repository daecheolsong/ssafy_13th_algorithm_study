import java.util.*;
import java.io.*;

public class S2_15663 {
	static int N, M;
	static int[] list;
	static boolean[] visited;
	static List<Integer> sequence = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N];
		visited  = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		comb(0);
		System.out.println(sb);
		

	}
	
	static void comb(int count) {
		if (count == M) {
			for (int num : sequence) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1; //직전값
		for (int i = 0; i < N; i++) {
			if (!visited[i] && prev != list[i]) {
				visited[i] = true;
				sequence.add(list[i]);
				prev = list[i];
				
				comb(count+1);
				
				visited[i] = false;
				sequence.remove(sequence.size()-1);
			}
		}
	}

}
