import java.util.*;
import java.io.*;

public class G5_13549 {
	static int N;
	static int K;
	static boolean[] visited;
	static int result = 0;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		
		bfs();
		
		System.out.println(result);
	}
	
	static void bfs() {
		Queue<State> queue = new LinkedList<>();
		queue.add(new State(N, 0));
		
		while(!queue.isEmpty()) {
			State cur = queue.poll();
			if (cur.x == K) {
				result = cur.count;
				return;
			}

			int nx3 = cur.x*2;
			if (nx3 >= 0 && nx3 <= 100000 && !visited[nx3]) {
				visited[nx3] = true;
				queue.add(new State(nx3, cur.count));
			} 
			
			int nx = cur.x - 1;
			if (nx >= 0 && nx <= 100000 && !visited[nx]) {
				visited[nx] = true;
				queue.add(new State(nx, cur.count+1));
			} 
			
			int nx2 = cur.x + 1;
			if ( nx2 >= 0 && nx2 <= 100000 && !visited[nx2]) {
				visited[nx2] = true;
				queue.add(new State(nx2, cur.count+1));
			} 
		}
	}
	

}

class State {
	public int x;
	public int count;
	
	public State(int x, int count) {
		this.x = x;
		this.count = count;
	}
}
