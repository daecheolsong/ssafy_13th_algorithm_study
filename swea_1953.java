public class swea_1953 {

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int[][] tunnel = {
			{-1},		// 0
			{0,1,2,3},	// 1
			{0,1},		// 2
			{2,3},		// 3
			{1,2},		// 4
			{0,2},		// 5
			{0,3},		// 6
			{1,3}		// 7
	};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());	//세로
			int M = Integer.parseInt(st.nextToken());	//가로
			int R = Integer.parseInt(st.nextToken());	//맨홀R
			int C = Integer.parseInt(st.nextToken());	//맨홀C
			int L = Integer.parseInt(st.nextToken());	//소요시간
			
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//input
			
			int result = 0;
			boolean[][] visited = new boolean[N][M];
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] {R,C, 1});	// r, c, time
			visited[R][C]=true;
			result++;
			
			while(queue.size()>0) {
				int[] cur = queue.poll();
				int r = cur[0];
				int c = cur[1];
				int t = cur[2];
				int p = map[r][c];//현재 위치의 파이프 번호
				//소요시간이 다 됐으면 더 움직이지 않는다.
				if(t==L) continue;
				
				// 현재 위치의 파이프에서 이동할 수 있는 모든 방향을 탐색
				for (int i = 0; i < tunnel[p].length; i++) {
					int nd = tunnel[p][i];
					int nr = r + dr[nd];
					int nc = c + dc[nd];
					
					if(nr<0||nc<0||nr>=N||nc>=M||
							map[nr][nc]==0 ||
							visited[nr][nc]) continue;

					// 새 파이프가 현재 위치와 연결되어있지 않다면 패스
					if(!isConnected(r,c,nr,nc)) continue;
                    
					// 탐색한 위치로 이동
					visited[nr][nc]=true;
					queue.offer(new int[] {nr,nc, t+1});
					result++;
				}
			}//
			
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	private static boolean isConnected(int r1, int c1, int r2, int c2) {
		int p = map[r2][c2]; //새 파이프 번호
		for (int i = 0; i < tunnel[p].length; i++) {//새 파이프에서 이동할 수 있는 모든 방향
			int nd = tunnel[p][i];
			//현재 방향으로 연결되어 있다면
			if(r2+dr[nd]==r1 && c2+dc[nd]==c1) {
				return true;
			}
		}
		return false;
	}
}
