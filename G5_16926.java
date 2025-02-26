import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_16926 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 
		int r = Integer.parseInt(st.nextToken()); 
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		int minX = 0, maxX = n - 1;
		int minY = 0, maxY = m - 1;
			
		while (minX < maxX && minY < maxY) {
			Queue<Integer> q = new LinkedList<>();
			int d = 0;
			int x = minX, y = minY;
			q.add(arr[x][y]);
			
			while (d < 4) {

				int cx = x + dx[d];
				int cy = y + dy[d];
				
				if (cx == minX && cy == minY) {
					break;
				}
				
				if (cx < minX || cx > maxX || cy < minY || cy > maxY) {
					d++;
					
					cx = x + dx[d];
					cy = y + dy[d];
					
					if (cx == minX && cy == minY) {
						break;
					}
				}
				
				if (d == 4) {
					break;
				}
				
				x += dx[d];
				y += dy[d];
				
				q.add(arr[x][y]);
			}
								
			for (int i = 0; i < r; i++) {
				q.add(q.poll());
			}
			
			x = minX;
			y = minY;
			arr[x][y] = q.poll();
			d = 0;
			
			while (d < 4) {
				int cx = x + dx[d];
				int cy = y + dy[d];
				
				if (cx == minX && cy == minY) {
					break;
				}
				
				if (cx < minX || cx > maxX || cy < minY || cy > maxY) {
					d++;
					
					cx = x + dx[d];
					cy = y + dy[d];
					
					if (cx == minX && cy == minY) {
						break;
					}
				}
				
				if (d == 4) {
					break;
				}
				
				x += dx[d];
				y += dy[d];
				
				arr[x][y] = q.poll();
			}
						
			minX++;
			minY++;
			maxX--;
			maxY--;
		}		
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
