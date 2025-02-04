import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_2638 {
	
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static int N,M;
	
	public static boolean[][] isGonggi;
	
	public static int[][] map;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
//		for(int i=0; i<N ; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		int time = 0;
		
		while(true) {
			
			if(isEnd()) {
				break;
			}
			
			isGonggi = new boolean[N][M]; // 외부 공기 여부를
			gonggiDfs(0,0); // 외부 공기를 찾아내는 메서드
			
			
			//다음 시간에 녹을 치즈 체크하는 메서드
			nextMeltCheck();
			
			
			time++;
			
			
			
			//녹이는 메서드
			melt();
			
			
		}
		
		
		System.out.println(time);

	}
	
	public static void melt() {
		for(int i=0 ; i< N ; i++) {
			for(int j = 0; j < M ;j++) {
				if(map[i][j]==2) {
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void nextMeltCheck() {
		for(int i=0 ; i< N ; i++) {
			for(int j=0; j<M ; j++) {
				if(map[i][j]==1) {
					int count =0;
					for(int k=0 ; k< 4 ; k++) {
						int next_x = j+dx[k];
						int next_y = i+dy[k];
						
						if(isGonggi[next_y][next_x]) {
							count++;
						}
					}
					if(count>=2) {
						map[i][j] = 2;
					}
				}
			}
		}
		
		
	}
	
	public static boolean isEnd() {
		for(int i=0; i< N ; i++) {
			for(int j =0 ;j<M ; j++) {
				if(map[i][j]==1){
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static void gonggiDfs(int x, int y) {
		isGonggi[y][x] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			
			if(next_x<M && next_x>=0 && next_y<N && next_y>=0 && !isGonggi[next_y][next_x] && map[next_y][next_x]==0) {
				gonggiDfs(next_x,next_y);	
			}
			
		}
		
	}
	
	

}
