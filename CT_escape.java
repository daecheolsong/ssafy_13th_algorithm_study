import java.util.*;
import java.io.*;

public class CT_escape {
	static class problem {
		int x;
		int y;
		int d;
		int t;
		public problem(int x, int y, int d, int t) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.t = t;
		}
	}
	
	static int N, M, F, sx, sy, ex, ey;
	static int[][] floor;
	static int[][] floor_virus;
	static boolean[][] floor_v;
	static int[][] time_wall;
	static boolean[][] time_wall_v;
	static int[] dx = {0, 0, 1, -1}; // 동 서 남 북
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		floor = new int[N][N];
		floor_virus = new int[N][N];
		floor_v = new boolean[N][N];
		time_wall = new int[M*3][M*3];
		time_wall_v = new boolean[M*3][M*3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				floor[i][j] = Integer.parseInt(st.nextToken());
				if (floor[i][j] == 4) {
					ex = i;
					ey = j;
				}
			}
		}
		
		for (int i = 0; i < 3*M; i++) {
			for (int j = 0; j < 3*M; j++) {
				time_wall[i][j] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				floor_virus[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 2*M; i < 3*M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 2*M-1; j >= M; j--) {
				time_wall[j][i] = Integer.parseInt(st.nextToken()); //동
			}
		}
		
		for (int i = M-1; i >= 0; i--) {
			st = new StringTokenizer(br.readLine());
			for (int j = M; j < 2*M; j++) {
				time_wall[j][i] = Integer.parseInt(st.nextToken()); //서
			}
		}
		
		for (int i = 2*M; i < 3*M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = M; j < 2*M; j++) {
				time_wall[i][j] = Integer.parseInt(st.nextToken()); //남
			}
		}
		
		for (int i = M-1; i >= 0; i--) {
			st = new StringTokenizer(br.readLine());
			for (int j = 2*M-1; j >= M; j--) {
				time_wall[i][j] = Integer.parseInt(st.nextToken()); //북
			}
		}
		
		for (int i = M; i < 2*M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = M; j < 2*M; j++) {
				time_wall[i][j] = Integer.parseInt(st.nextToken());
				if (time_wall[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}
		
//		System.out.println();
//		for (int i = 0; i < 3*M; i++) {
//			for (int j = 0; j < 3*M; j++) {
//				System.out.print(time_wall[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < F; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int n = 1;
			floor_virus[x][y] = 0;
			if (d == 0) { //동
				int nx = x + dx[d];
				int ny = y + dy[d];
				while (ny <= N-1) {
					if (floor[nx][ny] != 0) break;
					floor_virus[nx][ny] = Math.min(t*n, floor_virus[nx][ny]);
					nx = nx + dx[d];
					ny = ny + dy[d];
					n++;
				}
			}
			
			else if (d == 1) { //서
				int nx = x + dx[d];
				int ny = y + dy[d];
				while (ny >= 0) {
					if (floor[nx][ny] != 0) break;
					floor_virus[nx][ny] = Math.min(t*n, floor_virus[nx][ny]);
					nx = nx + dx[d];
					ny = ny + dy[d];
					n++;
				}
			}
			
			else if (d == 2) { //남
				int nx = x + dx[d];
				int ny = y + dy[d];
				while (nx <= N-1) {
					if (floor[nx][ny] != 0) break;
					floor_virus[nx][ny] = Math.min(t*n, floor_virus[nx][ny]);
					nx = nx + dx[d];
					ny = ny + dy[d];
					n++;
				}
			}
			
			else if (d == 3) { //북
				int nx = x + dx[d];
				int ny = y + dy[d];
				while (nx >= 0) {
					if (floor[nx][ny] != 0) break;
					floor_virus[nx][ny] = Math.min(t*n, floor_virus[nx][ny]);
					nx = nx + dx[d];
					ny = ny + dy[d];
					n++;
				}
			}
		}
		
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(floor_virus[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		bfs();
	}
	
	static class move {
		int x;
		int y;
		int d;
		int t;
		
		public move (int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	
	static class move_wall {
		int x;
		int y;
		int d;
		int t;
		
		public move_wall (int x, int y, int d, int t) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.t = t;
		}
	}
	
	static void bfs() {
		Queue<move_wall> queue = new LinkedList<>();
		queue.add(new move_wall(sx, sy, -1, 0));
		while (!queue.isEmpty()) {
			move_wall curr = queue.poll();
			
//			System.out.println("현재" + curr.x + " " + curr.y + " " + curr.d + " " + curr.t);
			
			if(curr.x >= M && curr.x < 2*M && curr.y == 3*M-1 && curr.d == 0) {
				int count = -1;
				for(int i = N-1; i >= 0; i--) {
					for (int j = 0; j < N; j++) {
						if (floor[j][i] == 3) count++;
						if (count == curr.x - M) {
							if(i+1 < N && floor[j][i+1] == 0) {
								move_floor(j, i+1, curr.d, curr.t+1);
								return;
							}
						}
					}
				}
			}
			if(curr.x >= M && curr.x < 2*M && curr.y == 0 && curr.d == 1) {
				int count = -1;
				for(int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (floor[j][i] == 3) count++;
						if (count == curr.x - M) {
							if(i-1 >= 0 && floor[j][i-1] == 0) {
								move_floor(j, i-1, curr.d, curr.t+1);
								return;
							}
						}
					}
				}
			}
			if(curr.y >= M && curr.y < 2*M && curr.x == 3*M-1 && curr.d == 2) {
				int count = -1;
				for(int i = N-1; i >= 0; i--) {
					for (int j = 0; j < N; j++) {
						if (floor[i][j] == 3) count++;
						if (count == curr.y - M) {
							if(i+1 < N && floor[i+1][j] == 0) {
								move_floor(i+1, j, curr.d, curr.t+1);
								return;
							}
						}
					}
				}
			}
			if(curr.y >= M && curr.y < 2*M && curr.x == 0 && curr.d == 3) {
				int count = -1;
				for(int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (floor[i][j] == 3) count++;
						if (count == curr.y - M) {
							if(i-1 >= 0 && floor[i-1][j] == 0) {
								move_floor(i-1, j, curr.d, curr.t+1);
								return;
							}
						}
					}
				}
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];
				if (curr.d == -1) {
					if (valid_time_wall(nx, ny) && !time_wall_v[nx][ny] && time_wall[nx][ny] == 0) {
						if (nx >= M && nx < 2*M && ny >= 2*M && ny < 3*M) {
							queue.add(new move_wall(nx, ny, 0, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
						
						else if (nx >= M && nx < 2*M && ny >= 0 && ny < M) {
							queue.add(new move_wall(nx, ny, 1, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
						
						else if (nx >= 2*M && nx < 3*M && ny >= M && ny < 2*M) {
							queue.add(new move_wall(nx, ny, 2, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
						
						else if (nx >= 0 && nx < M && ny >= M && ny < 2*M) {
							queue.add(new move_wall(nx, ny, 3, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
						
						else {
							queue.add(new move_wall(nx, ny, -1, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
					}
				}
				
				else if (curr.d == 0) {
					if (valid_time_wall(nx, ny) && !time_wall_v[nx][ny]) {
						if (nx >= 2*M) {
							if(!time_wall_v[ny][nx-1] && time_wall[ny][nx-1] == 0) {
								queue.add(new move_wall(ny, nx-1, 2, curr.t+1));
								time_wall_v[ny][nx-1] = true;
							}
						}
						
						else if (nx < M) {
							if(!time_wall_v[(3*M-1)-ny][nx+M] && time_wall[(3*M-1)-ny][nx+M] == 0) {
								queue.add(new move_wall((3*M-1)-ny, nx+M, 3, curr.t+1));
								time_wall_v[(3*M-1)-ny][nx+M] = true;
							}
						}
						
						else if(nx >= M && nx < 2*M && ny >= M && ny < 2*M && time_wall[nx][ny] == 0){
							queue.add(new move_wall(nx, ny, -1, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
						
						else if(nx >= M && nx < 2*M && ny >= 2*M && ny < 3*M && time_wall[nx][ny] == 0){
							queue.add(new move_wall(nx, ny, 0, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
					}
				}
				
				else if (curr.d == 1) {
					if (valid_time_wall(nx, ny) && !time_wall_v[nx][ny]) {
						if (nx >= 2*M) {
							if(!time_wall_v[(3*M-1)-ny][nx-M] && time_wall[(3*M-1)-ny][nx-M] == 0) {
								queue.add(new move_wall((3*M-1)-ny, nx-M, 2, curr.t+1));
								time_wall_v[(3*M-1)-ny][nx-M] = true;
							}
							
						}
						
						else if (nx < M) {
							if(!time_wall_v[ny][nx+1] && time_wall[ny][nx+1] == 0) {
								queue.add(new move_wall(ny, nx+1, 3, curr.t+1));
								time_wall_v[ny][nx+1] = true;
							}
						}
						
						else if(nx >= M && nx < 2*M && ny >= M && ny < 2*M && time_wall[nx][ny] == 0){
							queue.add(new move_wall(nx, ny, -1, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
						
						else if(nx >= M && nx < 2*M && ny >= 0 && ny < M && time_wall[nx][ny] == 0){
							queue.add(new move_wall(nx, ny, 1, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
					}
				}
				
				else if (curr.d == 2) {
					if (valid_time_wall(nx, ny) && !time_wall_v[nx][ny]) {
						if (ny >= 2*M) {
							if(!time_wall_v[ny - 1][nx] && time_wall[ny - 1][nx] == 0) {
								queue.add(new move_wall(ny - 1, nx, 0, curr.t+1));
								time_wall_v[ny - 1][nx] = true;
							}
						}
						
						else if (ny < M) {
							if(!time_wall_v[ny+M][(3*M)-1-nx] && time_wall[ny+M][(3*M)-1-nx] == 0) {
								queue.add(new move_wall(ny+M, (3*M)-1-nx, 1, curr.t+1));
								time_wall_v[ny+M][(3*M)-1-nx] = true;
							}
							
						}
						
						else if(nx >= M && nx < 2*M && ny >= M && ny < 2*M && time_wall[nx][ny] == 0){
							queue.add(new move_wall(nx, ny, -1, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
						
						else if(nx >= 2*M && nx < 3*M && ny >= M && ny < 2*M && time_wall[nx][ny] == 0){
							queue.add(new move_wall(nx, ny, 2, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
					}
				}
				
				else if (curr.d == 3) {
					if (valid_time_wall(nx, ny) && !time_wall_v[nx][ny]) {
						if (ny >= 2*M) {
							if(!time_wall_v[ny - M][(3*M)-1-nx] && time_wall[ny - M][(3*M)-1-nx] == 0) {
								queue.add(new move_wall(ny - M, (3*M)-1-nx, 0, curr.t+1));
								time_wall_v[ny - M][(3*M)-1-nx] = true;
							}
							
						}
						
						else if (ny < M ) {
							if(!time_wall_v[ny+1][nx] && time_wall[ny+1][nx] == 0) {
								queue.add(new move_wall(ny+1, nx, 1, curr.t+1));
								time_wall_v[ny+1][nx] = true;
							}
						}
						
						else if(nx >= M && nx < 2*M && ny >= M && ny < 2*M && time_wall[nx][ny] == 0){
							queue.add(new move_wall(nx, ny, -1, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
						
						else if(nx >= 0 && nx < M && ny >= M && ny < 2*M && time_wall[nx][ny] == 0) {
							queue.add(new move_wall(nx, ny, 3, curr.t+1));
							time_wall_v[nx][ny] = true;
						}
					}
				}
			}
		}
		
		System.out.println(-1);
		return;
		
	}
	
	static void move_floor(int x, int y, int D, int t) {
		Queue<move> queue = new LinkedList<>();
//		System.out.println(x + " " + y + " " + D + " "  + t);
		
		floor_v[x][y] = true;
		queue.add(new move(x, y, t));
		
		while(!queue.isEmpty()) {
			move curr = queue.poll();
//			System.out.println("현재" + curr.x +" " + curr.y + " " + curr.t + " ");
			if (curr.x == ex && curr.y == ey) {
				System.out.println(curr.t);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];
				if (valid_floor(nx, ny) && !floor_v[nx][ny] && (floor[nx][ny] == 0 || floor[nx][ny] == 4) && floor_virus[nx][ny] > curr.t+1) {
					queue.add(new move(nx, ny, curr.t+1));
					floor_v[nx][ny] = true;
				}
			}
		}
		
		System.out.println(-1);
		return;
		
		
	}
	
	static boolean valid_time_wall(int x, int y) {
		return x >= 0 && x < 3*M && y >= 0 && y < 3*M;
	}
	
	static boolean valid_floor(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
