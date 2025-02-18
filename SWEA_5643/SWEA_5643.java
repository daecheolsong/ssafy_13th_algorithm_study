import java.io.*;
import java.util.*;
public class SWEA_5643
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for(int tc = 1; tc <= t; tc ++) {
			sb.append("#").append(tc).append(" ");
			int answer = 0;
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int [][] g = new int[n + 1][n + 1];
			
			for(int i = 0; i < m; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				g[from][to] = 1;
			}
			for(int i = 1; i <= n; i ++) {
				Queue<Integer> q = new LinkedList<>();
				int [] v = new int[n + 1];
				
				int count = 0;
				for(int j = 1; j <= n; j ++) {
					if(g[i][j] == 1) {
						q.add(j);
						v[j] = 1;
						count ++;
					}
				}
                // 부모노드 찾기
				while(!q.isEmpty()) {
					int next = q.poll();
					for(int j = 1; j <= n; j ++) {
						if(v[j] == 0 && g[next][j] == 1) {
							q.add(j);
							v[j] = 1;
							count ++;
						}
					}
				}

				Arrays.fill(v, 0);
				// 자식 노드찾기
				for(int j = 1; j <= n; j ++) {
					if(g[j][i] == 1) {
						q.add(j);
						v[j] = 1;
						count++;
					}
				}
				
				while(!q.isEmpty()) {
					int next = q.poll();
					for(int j = 1; j <=n; j ++) {
						if(v[j] == 0 && g[j][next] == 1) {
							q.add(j);
							v[j] = 1;
							count ++;
						}
					}
				}
                // 부모노드 + 자식노드 합이 n - 1 이면 자신의 위치를 알수 있음.
				if(count == n - 1) {
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}