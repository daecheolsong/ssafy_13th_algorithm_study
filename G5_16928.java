import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_16928 {
	
	static int n;
	static int[][] arr;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		bfs();
		
		System.out.println(answer);
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] {1, 0});
		boolean[] visit = new boolean[101];
		boolean[] snake = new boolean[n];
		
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int depth = q.peek()[1];
			q.poll();
			
			if (x == 100) {
				answer = depth;
				break;
			}
			
			for (int i = 6; i >= 1; i--) {
				int temp = x + i;
				
				if (temp == 100) {
					answer = depth + 1;
					return;
				}
				
				if (temp > 100 || visit[temp]) {
					continue;
				}
				
				visit[temp] = true;
				
				for (int j = 0; j < n; j++) {
					if (temp == arr[j][0] && !snake[j]) {
						snake[j] = true;
						visit[arr[j][1]] = true;
						temp = arr[j][1];
						break; 
					}
				}
				
				if (temp <= 100) {
					q.add(new int[] {temp, depth + 1});
				}
			}	
		}
	}
}
