import java.util.*;
import java.io.*;

public class CT_medusa {
	
	static int N, M;
	static int[][] grid;
	static int[][] temp;
	static int sx, sy;
	static int ex, ey;
	static List<int[]> warrior = new ArrayList<>();
	static boolean[][] see;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int[] dx2 = {0, 0, -1, 1}; // 좌우상하
	static int[] dy2 = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][N];
		temp = new int[N][N];
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			warrior.add(new int[] {x, y});
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = grid[i][j];
			}
		}
		
		move();
	}
	
	static class Route {
		int x;
		int y;
		List<int[]> route;
		
		public Route(int x, int y, List<int[]> route) {
			this.x = x;
			this.y = y;
			this.route = route;
		}
	}
	
	static void move() {
		Queue<Route> queue = new LinkedList<>();
		queue.add(new Route(sx, sy, new ArrayList<>()));
		visited = new boolean[N][N];
		while(!queue.isEmpty()) {
			Route curr  = queue.poll();
			if (curr.x == ex && curr.y == ey) {
//				for (int[] r: curr.route) {
//					System.out.println("루트" + r[0] + " " + r[1]);
//				}
				go(curr.route);
				return;
			}
			for (int d = 0; d < 4 ; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];
				List<int[]> newRoute = new ArrayList<>();
				for (int[] r : curr.route) {
				    newRoute.add(r.clone()); // 깊은 복사
				}
				if (valid(nx, ny) && !visited[nx][ny]) {
					if(grid[nx][ny] == 0) {
						newRoute.add(new int[] {nx, ny});
						queue.add(new Route(nx, ny, newRoute));
						visited[nx][ny] = true;
					}
				}
			}
		}
		
		System.out.println(-1);
		return;
	}
	
	static void go(List<int[]> route) {
		for (int[] pos: route) {

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = temp[i][j];
				}
			}
			
			for(int idx = warrior.size()-1; idx >= 0; idx--) {
				if(warrior.get(idx)[0] == pos[0] && warrior.get(idx)[1] == pos[1]) {
					warrior.remove(idx);
				}
				else grid[warrior.get(idx)[0]][warrior.get(idx)[1]] = 2;
			}
			
			if (pos[0] == ex && pos[1] == ey) {
				System.out.println(0);
				return;
			}
			int stone = see(pos[0], pos[1]);
			int[] info = warrior_move1(pos[0], pos[1]);
			int[] info2 = warrior_move2(pos[0], pos[1]);
			int move_sum = info[0] + info2[0];
			int attack_sum = info[1] + info2[1];
			System.out.println(move_sum + " " + stone + " " + attack_sum);
			
		}
	}
	
	static int see(int x, int y) {
		int max_d = 0;
		int max = 0;
		for (int d = 0; d < 4; d++) {
			see = new boolean[N][N];
			if(d == 0) { //상
				for (int i = 1; i <= x; i++) {
					for (int j = -i; j <= i; j++) {
						if (y+j < 0 || y+j >= N) continue;
						see[x-i][y+j] = true;
					}
				}
			}
			
			else if(d == 1) { //하
				for (int i = 1; i < N - x; i++) {
					for (int j = -i; j <= i; j++) {
						if (y+j < 0 || y+j >= N) continue;
						see[x+i][y+j] = true;
					}
				}
			}
			
			else if(d == 2) { //좌
				for (int i = 1; i <= y; i++) {
					for (int j = -i; j <= i; j++) {
						if (x+j < 0 || x+j >= N) continue;
						see[x+j][y-i] = true;
					}
				}
			}
			
			else if(d == 3) { //우
				for (int i = 1; i < N - y; i++) {
					for (int j = -i; j <= i; j++) {
						if (x+j < 0 || x+j >= N) continue;
						see[x+j][y+i] = true;
					}
				}
			}
			
			warrior(x, y, d);
			
			int w = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (see[i][j] == true && grid[i][j] == 2) {
						w++;
					}
				}
			}
			if (w > max) {
				max = w;
				max_d = d;
			}
		}
		
		see = new boolean[N][N];
		if(max_d == 0) { //상
			for (int i = 1; i <= x; i++) {
				for (int j = -i; j <= i; j++) {
					if (y+j < 0 || y+j >= N) continue;
					see[x-i][y+j] = true;
				}
			}
		}
		
		else if(max_d == 1) { //하
			for (int i = 1; i < N - x; i++) {
				for (int j = -i; j <= i; j++) {
					if (y+j < 0 || y+j >= N) continue;
					see[x+i][y+j] = true;
				}
			}
		}
		
		else if(max_d == 2) { //좌
			for (int i = 1; i <= y; i++) {
				for (int j = -i; j <= i; j++) {
					if (x+j < 0 || x+j >= N) continue;
					see[x+j][y-i] = true;
				}
			}
		}
		
		else if(max_d == 3) { //우
			for (int i = 1; i < N - y; i++) {
				for (int j = -i; j <= i; j++) {
					if (x+j < 0 || x+j >= N) continue;
					see[x+j][y+i] = true;
				}
			}
		}
		
		warrior(x, y, max_d);
		
		return max;
		
	}
	
	static void warrior(int mx, int my, int d) {
		if (d == 0) { //상
			for (int x = N-1; x >= 0; x--) {
				for (int y = 0; y < N; y++) {
					if (see[x][y] && grid[x][y] == 2) {
						if (y > my) {
							for (int i = 1; i <= x; i++) {
								for (int j = 0; j <= i; j++) {
									if (y+j < 0 || y+j >= N) continue;
									see[x-i][y+j] = false;
								}
							}
						}
						
						if (y == my) {
							for (int i = 1; i <= x; i++) {
								for (int j = 0; j <= 0; j++) {
									if (y+j < 0 || y+j >= N) continue;
									see[x-i][y+j] = false;
								}
							}
						}
						
						if (y < my) {
							for (int i = 1; i <= x; i++) {
								for (int j = -i; j <= 0; j++) {
									if (y+j < 0 || y+j >= N) continue;
									see[x-i][y+j] = false;
								}
							}
						}
					}
				}
			}
		}
		
		if (d == 1) { //하
			for (int x = 0; x <= N-1; x++) {
				for (int y = 0; y < N; y++) {
					if (see[x][y] && grid[x][y] == 2) {
						if (y > my) {
							for (int i = 1; i < N - x; i++) {
								for (int j = 0; j <= i; j++) {
									if (y+j < 0 || y+j >= N) continue;
									see[x+i][y+j] = false;
								}
							}
						}
						
						if (y == my) {
							for (int i = 1; i < N - x; i++) {
								for (int j = 0; j <= 0; j++) {
									if (y+j < 0 || y+j >= N) continue;
									see[x+i][y+j] = false;
								}
							}
						}
						
						if (y < my) {
							for (int i = 1; i < N - x; i++) {
								for (int j = -i; j <= 0; j++) {
									if (y+j < 0 || y+j >= N) continue;
									see[x+i][y+j] = false;
								}
							}
						}
					}
				}
			}
		}
		
		if (d == 2) { //좌
			for (int x = 0; x <= N-1; x++) {
				for (int y = N-1; y >= 0; y--) {
					if (see[x][y] && grid[x][y] == 2) {
						if (x > mx) {
							for (int i = 1; i <= y; i++) {
								for (int j = 0; j <= i; j++) {
									if (x+j < 0 || x+j >= N) continue;
									see[x+j][y-i] = false;
								}
							}
						}
						
						if (x == mx) {
							for (int i = 1; i <= y; i++) {
								for (int j = 0; j <= 0; j++) {
									if (x+j < 0 || x+j >= N) continue;
									see[x+j][y-i] = false;
								}
							}
						}
						
						if (x < mx) {
							for (int i = 1; i <= y; i++) {
								for (int j = -i; j <= 0; j++) {
									if (x+j < 0 || x+j >= N) continue;
									see[x+j][y-i] = false;
								}
							}
						}
					}
				}
			}
		}
		
		if (d == 3) { //우
			for (int x = 0; x <= N-1; x++) {
				for (int y = 0; y <= N-1; y++) {
					if (see[x][y] && grid[x][y] == 2) {
						if (x > mx) {
							for (int i = 1; i < N - y; i++) {
								for (int j = 0; j <= i; j++) {
									if (x+j < 0 || x+j >= N) continue;
									see[x+j][y+i] = false;
								}
							}
						}
						
						if (x == mx) {
							for (int i = 1; i < N - y; i++) {
								for (int j = 0; j <= 0; j++) {
									if (x+j < 0 || x+j >= N) continue;
									see[x+j][y+i] = false;
								}
							}
						}
						
						if (x < mx) {
							for (int i = 1; i < N - y; i++) {
								for (int j = -i; j <= 0; j++) {
									if (x+j < 0 || x+j >= N) continue;
									see[x+j][y+i] = false;
								}
							}
						}
					}
				}
			}
		}
	}
	
	static int[] warrior_move1(int x, int y) {
		int sum_move = 0;
		int sum_warrior = 0;
		
		for(int idx = warrior.size()-1; idx >= 0; idx--) {
			int[] curr = warrior.get(idx);
			if (see[curr[0]][curr[1]]) continue;
			double dis = Math.sqrt(Math.pow(x - curr[0], 2) + Math.pow(y - curr[1], 2));
			for (int d = 0; d < 4; d++) {
				int nx = curr[0] + dx[d];
				int ny = curr[1] + dy[d];
				if (!valid(nx, ny) || see[nx][ny]) continue;
				if (nx == x && ny == y) {
					sum_warrior++;
					sum_move++;
					warrior.remove(idx);
					break;
				}
				double n_dis = Math.sqrt(Math.pow(x - nx, 2) + Math.pow(y - ny, 2));
				if (dis > n_dis) {
					sum_move++;
					warrior.set(idx, new int[] {nx, ny});
					break;
				}
			}
		}
		
		return new int[] {sum_move, sum_warrior};
	}
	
	static int[] warrior_move2(int x, int y) {
		int sum_move = 0;
		int sum_warrior = 0;
		
		for(int idx = warrior.size()-1; idx >= 0; idx--) {
			int[] curr = warrior.get(idx);
			if (see[curr[0]][curr[1]]) continue;
			double dis = Math.sqrt(Math.pow(x - curr[0], 2) + Math.pow(y - curr[1], 2));
			for (int d = 0; d < 4; d++) {
				int nx = curr[0] + dx2[d];
				int ny = curr[1] + dy2[d];
				if (!valid(nx, ny) || see[nx][ny]) continue;
				if (nx == x && ny == y) {
					sum_warrior++;
					sum_move++;
					warrior.remove(idx);
					break;
				}
				double n_dis = Math.sqrt(Math.pow(x - nx, 2) + Math.pow(y - ny, 2));
				if (dis > n_dis) {
					sum_move++;
					warrior.set(idx, new int[] {nx, ny});
					break;
				}
			}
		}
		
		return new int[] {sum_move, sum_warrior};

	}
	
	static boolean valid(int x, int y) {
		return (x >= 0) && (x < N) && (y >= 0) && (y < N);
	}

}

