package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
		static int count = 0;
		static int[][] result;
		static int[][] map;
		static int r=0, c=0, nr, nc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int[] dx = {0, -1, 0, 1, -1, -1, 1, 1};
        int[] dy = {-1, 0, 1, 0, -1, 1, -1, 1};
        
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(map[i][j] == 0) {
        			r = i;
        			c = j;
        			break;
        		}
        	}
        }
        
        
        int M = Integer.parseInt(br.readLine());
        
        int nc = 0, nr = 0;
        
        for(int i = 0; i < M; i++) {
        	String action = br.readLine();
        	
        	if (action.equals("L")) {
        		nr = r + dx[0];
        		nc = c + dy[0];
        		move(nr, nc);
        	}else if (action.equals("U")) {
        		nr = r + dx[1];
        		nc = c + dy[1];
        		move(nr, nc);
        	}else if (action.equals("R")) {
        		nr = r + dx[2];
        		nc = c + dy[2];
        		move(nr, nc);
        	}else if (action.equals("D")) {
        		nr = r + dx[3];
        		nc = c + dy[3];
        		move(nr, nc);
        	}else {
        		for (int d = 0; d < 8; d++) {
        			nr = r + dx[d];
        			nc = c + dy[d];
        			
        			//
        			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
        				if(map[nr][nc] > 0) {
        					count++;
        					map[nr][nc] = 0; //다 부수기
        				}
        			}
        		}
        	}
        }
        sb.append("광부 위치 : ("+nr+","+nc+")").append("\n");
        sb.append("부순 암석 개수 : "+count);
        System.out.println(sb);
    }
	private static void move(int nr, int nc) {
		// TODO Auto-generated method stub
		if(map[nr][nc] > 0) {
			map[nr][nc]--;
			if(map[nr][nc] == 0) {
				count++;
				r = nr;
				c = nc;
			}
		}else {
			r = nr;
			c = nc;
		}
	} 
}