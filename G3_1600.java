import java.io.*;
import java.util.*;

public class G3_1600 {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[] horseX = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] horseY = {2, 1, -1, -2, -2, -1, 1, 2};
	
	static int k;
	static int[][] arr;
	static int w, h;
	static boolean[][][] visit;
	static int count = -1;
	
	public static class Point{
		int x;
		int y;
		int value;
		int horseCnt;
		
		Point(int x, int y, int value, int horseCnt) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.horseCnt = horseCnt;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		arr = new int[h][w];
		visit = new boolean[h][w][k + 1];
		
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.println(count);
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0, k));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int value = q.peek().value;
			int horseCnt = q.peek().horseCnt;
			q.poll();
			
			if (x == h - 1 && y == w - 1) {
				count = value;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
					
				if (cx >= 0 && cx < h && cy >= 0 && cy < w && arr[cx][cy] == 0) {
					if (!visit[cx][cy][horseCnt]) {
						visit[cx][cy][horseCnt] = true;
						q.add(new Point(cx, cy, value + 1, horseCnt));
					}
				}
			}
			if (horseCnt > 0) {
				for (int i = 0; i < 8; i++) {
					int cx = x + horseX[i];
					int cy = y + horseY[i];
					
					if (cx >= 0 && cx < h && cy >= 0 && cy < w && arr[cx][cy] == 0) {
						if (!visit[cx][cy][horseCnt - 1]) {
							visit[cx][cy][horseCnt - 1] = true;
							q.add(new Point(cx, cy, value + 1, horseCnt - 1));
						}
					}
				}
			}
		}
	}
}
