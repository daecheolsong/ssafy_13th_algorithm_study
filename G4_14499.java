import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_14499 {

	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	static List<Integer> diceA = new ArrayList<>();
	static List<Integer> diceB = new ArrayList<>();
	
	static int n, m, x, y, k;
	static int[][] arr;
	static int[] command;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		command = new int[k];
		
		diceA.add(0);
		diceA.add(0);
		diceA.add(0);
		diceA.add(0);
		
		diceB.add(0);
		diceB.add(0);
		diceB.add(0);
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			command[i] = Integer.parseInt(st.nextToken()); 
		}
		
		move();
		
		System.out.println(sb);
	}
	
	static void move() {
		for (int c = 0; c < k; c++) {
			int cmd = command[c];
			
			int cx = x + dx[cmd];
			int cy = y + dy[cmd];
			
			if (cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
			
			// 동쪽
			if (cmd == 1) {
				int temp = diceA.remove(3);
				diceB.add(0, temp);
				temp = diceB.remove(3);
				diceA.add(temp);
				
				diceA.set(1, diceB.get(1));
			} 
			// 서쪽
			else if (cmd == 2) {
				int temp = diceA.remove(3);
				diceB.add(temp);
				temp = diceB.remove(0);
				diceA.add(temp);
				
				diceA.set(1, diceB.get(1));
			} 
			// 북쪽
			else if (cmd == 3) {
				diceA.add(diceA.remove(0));
				diceB.set(1, diceA.get(1));
			} 
			// 남쪽
			else if (cmd == 4) {
				diceA.add(0, diceA.remove(3));
				diceB.set(1, diceA.get(1));
			}
			
			x = cx;
			y = cy;
			
			// 이동한 칸의 수 출력
			if (arr[x][y] == 0) {
				arr[x][y] = diceA.get(3);
			} else {
				diceA.set(3, arr[x][y]);
				arr[x][y] = 0;
			}
			sb.append(diceA.get(1)).append("\n");
		}
	}
}
