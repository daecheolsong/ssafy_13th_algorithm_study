import java.util.*;
import java.io.*;
public class G3_15685 {

	
	static int x;
	static int y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] map = new int[101][101];
		
		for(int i = 0; i < n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			
			// 0 단계 먼저 그리기
			map[y][x] = 1;
			List<Integer> directions = new ArrayList<>();
			directions.add(d);
			draw(d, map);
		
			// D(n) = [E(1), E(2), ..., E(2^(n+1))] -- Direction
			// T(i) = (E(2^(n+1) - i) + 1) % 4, i >=0 -- nextDirection
			// D(n+1) = [D(n), T(0), T(1), ... T(2^(n+1) - 1)]
			for(int j = 0; j < g; j ++) {
				int last = directions.size();
				
				List<Integer> nextDirections = new ArrayList<>();
				for(int k = last - 1; k >= 0; k --) {
					int curD = directions.get(k);
					int nextD = (curD + 1) % 4;
					draw(nextD, map);
					nextDirections.add(nextD);
				}
				
				directions.addAll(nextDirections);
			}	
		}
		
		int cnt = 0;
		
		
		for(int j = 0; j < 100; j ++) {
			for(int k = 0; k < 100; k ++) {
				if(map[j][k] == 1 && map[j + 1][k] == 1 && map[j][k + 1] == 1 && map[j + 1][k + 1] == 1) {
					cnt++;
				}
			}
			
		}
		System.out.println(cnt);
	}
	
	public static void draw(int d, int [][] map) {
		if(d == 0) {
			map[y][++x] = 1;
		}
		if(d == 1) {
			map[--y][x] = 1;
		}
		if(d == 2) {
			map[y][--x] = 1;
		}
		if(d == 3) {
			map[++y][x] = 1;
		}
	}
}
