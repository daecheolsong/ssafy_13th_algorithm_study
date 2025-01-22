import java.util.Scanner;

public class S2_1012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int count = 0;
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] grid = new int[M][N]; // grid 생성
			
			for (int j=0;j<K;j++) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				grid[m][n] = 1;
			} // 배추 위치 1로 지정
			
			for (int x = 0; x < M; x++) {
				for (int y = 0; y < N; y++) {
					if (grid[x][y] == 1) {
						dfs(x,y,grid,M,N); //dfs 함수 호출
						count++; // 배추 묶음 제거 후 count
					}
				}
			}
			System.out.println(count);
		}

	}
	static void dfs(int x, int y, int[][] grid,int M,int N) {
		grid[x][y] = 0; //이미 확인한 배추 0
		if ((x-1 >= 0) && (grid[x-1][y]==1)) { //위에 배추가 있다면 다시 dfs
			dfs(x-1,y,grid,M,N);
		}
		if ((y-1 >= 0) && (grid[x][y-1]==1)) { //왼쪽에 배추가 있다면 다시 dfs
			dfs(x,y-1,grid,M,N);
		}
		if ((x+1 < M) && (grid[x+1][y]==1)) { //아래에 배추가 있다면 다시 dfs
			dfs(x+1,y,grid,M,N);
		}
		if ((y+1 < N) && (grid[x][y+1]==1)) { //오른쪽에 배추가 있다면 다시 dfs
			dfs(x,y+1,grid,M,N);
		}
 //사방으로 인접한 배추 그룹 모두 0으로 변경 후 끝남
	}

}
