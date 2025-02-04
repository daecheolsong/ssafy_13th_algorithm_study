import java.io.*;
import java.util.*;

public class G3_1022 {

	// r l u d
	static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		int [][]map = new int[r2 - r1 + 1][c2 - c1 + 1];
		
		int r = 0, c = 0, dir = 0;
		
		
		// dnum 은 현재 방향의 그려야 할 개수
		int num = 1, dnum = 1, cnt = 0;
		
		while(!isFinished(map, r1, r2, c1, c2)) {
			if(isIn(r, c, r1, r2, c1, c2)) {
				map[r - r1][c - c1] = num;
			}
			
			num++;
			cnt++;
			
			r = r + dr[dir];
			c = c + dc[dir];
			// 현재 방향에서 그려야 할 개수에 도달했으면
			if(cnt == dnum) {
				cnt = 0; // 개수 초기화
                // 위쪽이나 아래쪽에서 다음 방향으로 이동할때, 그 방향에서 그려야할 개수 1개 증가
				if(dir == 1 || dir == 3) dnum ++;
				dir =  (dir + 1) % 4;
			}
		}
		
		int maxNum = num - 1; // 마지막 그린숫자
		int maxDigitLen = (int)Math.log10(maxNum); // 마지막 그린 개수의 자릿수
		
		int len = maxDigitLen;
		
		
		for(int i = 0; i < map.length ; i ++) {
			for(int j = 0 ; j < map[0].length; j ++) {
				len = maxDigitLen - (int) Math.log10(map[i][j]); // 현재 숫자의 자릿수와 마지막 그린 개수의 자릿수의 차이
				for(int k = 0; k < len; k ++) {
					System.out.print(" ");
				}
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static boolean isIn(int r, int c , int r1, int r2, int c1, int c2) {
		return r >= r1 && r <= r2 && c >= c1 && c <= c2;
	}
	
	private static boolean isFinished(int [][] map, int r1, int r2, int c1, int c2) {
		return map[0][0] != 0 && map[r2-r1][0] != 0 && map[0][c2-c1] != 0 && map[r2-r1][c2-c1] != 0;
	}

}

