import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2615 {

	static int [] mvr = {-1, 0, 1, 1};
	static int [] mvc = {1, 1 ,1, 0};
	public static void main(String[] args) throws Exception {
		
		int [][] map = new int[19][19];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 19; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 19; i ++) {
			for(int j = 0; j < 19; j ++) {
				if(map[i][j] != 0) {
					int wb = map[i][j];
					
					// 시작점
					int ssr = i + 1;
					int ssc = j + 1;
					
					
					for(int k = 0; k < 4; k ++) {
						int cnt = 1;
						int sr = i;
						int sc = j;
						while(true) {
							sr = sr + mvr[k];
							sc = sc + mvc[k];
							if(!isIn(sr, sc) || map[sr][sc] != wb) {
								break;
							}
							cnt++;
						}
						if(cnt == 5) {
							// 시작점 이전에 같은 색깔이면 6목 , 이기는 조건이 아님
							if(isIn(ssr - 1 - mvr[k], ssc - 1 - mvc[k]) && map[ssr - 1 - mvr[k]][ssc - 1 - mvc[k]] == wb) {
								continue;
							}
							System.out.println(wb);
							System.out.println(ssr + " " + ssc);
							return;
						}
					}
				}
			}
		}
		
		System.out.println("0");
		
		
		
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < 19 && c >= 0 && c < 19;
	}

}
