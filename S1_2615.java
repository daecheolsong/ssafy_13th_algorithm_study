import java.util.Scanner;

public class S1_2615 {
	

	static int[][] grid = new int[19][19];
	static int[] dx = {-1,0,1,1};
	static int[] dy = {1,1,1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		int resultStone = 0;
        int resultX = -1, resultY = -1;
        
        
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
					if(grid[i][j] != 0) {
						int stone = grid[i][j];
						for(int k = 0; k < 4; k++) {
							if (checkline(i,j,k,stone)) {
								System.out.println(stone);
								System.out.print((i+1) + " " + (j+1));
								return;
							}
						}
					}
				}
			}
		System.out.println(0);
	}
	
	public static boolean checkline(int x, int y, int k, int stone) {
		int count = 1;
		for (int i = 1; i < 5; i++) {
			int nx = x + dx[k] * i;
			int ny = y + dy[k] * i;
			
			if (isInBounds(nx,ny) && grid[nx][ny] == stone) {
				count ++;
			}
			else break;
		}
		
		if (count != 5) return false;
		
		int nx2 = x + dx[k] * 5;
		int ny2 = y + dy[k] * 5;
		
		if(isInBounds(nx2, ny2) && grid[nx2][ny2] == stone) {
			return false;
		}
		
		int px = x - dx[k];
		int py = y - dy[k];
		
		if(isInBounds(px, py) && grid[px][py] == stone) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean isInBounds(int x, int y) {
		return x >= 0 && x < 19 && y >= 0 && y < 19;
	}

}
