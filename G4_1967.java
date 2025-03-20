import java.util.*;
import java.io.*;

public class G4_1967 {
	static int N;
	static List<List<int[]>> list;
	static int result = 0;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		
		for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(x).add(new int[] {y, w});
			list.get(y).add(new int[] {x, w});
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			calc(i, 0);
		}
		
		System.out.println(result);
	}
	
	static void calc(int idx, int sum) {
		visited[idx] = true;
		result = Math.max(sum, result);
		
		
		for(int[] next:list.get(idx)) {
			if (visited[next[0]] == false) {
				calc(next[0], sum+next[1]);	
			}
		} 
	}

}
