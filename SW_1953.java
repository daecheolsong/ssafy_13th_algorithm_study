import java.util.*;
import java.io.*;

public class SW_1953 {
	static int[][] grid;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] directions = {
	        {},                // 0번 터널 없음
	        {0, 1, 2, 3},      // 1번: 상 우 하 좌
	        {0, 2},            // 2번: 상하
	        {1, 3},            // 3번: 좌우
	        {0, 1},            // 4번: 상우
	        {1, 2},            // 5번: 하우
	        {2, 3},            // 6번: 하좌
	        {0, 3}             // 7번: 좌상
	    };
	static boolean[][] visited, mark;
	static int N,M,L;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			grid = new int[N][M];
			visited = new boolean[N][M];
			mark = new boolean[N][M];
			result = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited[R][C] = true;
			bfs(R,C,1);
			
			for (int j = 0; j <N; j++) {
                for (int k = 0; k < M; k++) {
                    if(mark[j][k]) result++;
                }
            }
			System.out.println("#" + test_case + " " + result);
		}
	}
	
	public static void bfs(int x, int y, int time) { //시간 내에 가장 깊이 갈 수 있는 곳들을 구한 후 다시 visit false 하여 백트래킹
		mark[x][y]=true; //mark에는 방문 가능한 모든 칸을 넣으므로 이미 true가 된 값을 고려할 필요 없음
		if (time == L) {
			return;
		}
		for (int d : directions[grid[x][y]]) {
	        int nx = x + dx[d], ny = y + dy[d];
	        
	        if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && grid[nx][ny] != 0) {
	        	int opposite = (d + 2) % 4;
	        	boolean isConnected = false;
	        	
	        	for (int nextD: directions[grid[nx][ny]]) {
	        		if (nextD == opposite) {
	        			isConnected = true;
	        			break;
	        		}
	        	}
	        	
	        	if (isConnected) {
	        		//System.out.println("d " + d + " next " + nx + " " + ny + "time " + time + "result " + result);
	        		visited[nx][ny] = true;
	            	bfs(nx, ny, time+1);
	            	visited[nx][ny] = false;
	        	}
	        }
	    }
	}
	

}
