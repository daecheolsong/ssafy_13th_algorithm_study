import java.util.*;
import java.io.*;

public class G5_1025 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[n][m];
		
		for(int i = 0; i < n; i ++) {
			String [] line = br.readLine().split("");
			for(int j = 0; j < m; j ++) {
				char c = line[j].charAt(0);
				map[i][j] = c - '0';
			}
			
		}
		
		int answer = -1; 
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				for(int dr = -n; dr < n; dr ++) {
					for(int dc = -m ; dc < m; dc ++) {
						if(dr == 0 && dc == 0) {
							continue;
						}
						int r = i;
						int c = j;
						int num = 0;
						while(r >= 0 && r < n && c >= 0 && c < m) {
							num *= 10;
							num += map[r][c];
							r += dr;
							c += dc;
              int sqrt = (int) Math.sqrt(num);
						
						  if(num == sqrt * sqrt) {
							  answer = Math.max(answer, num);
						    }
						}
						
						
						
					}
				}
			}
			
		}
		System.out.println(answer);
		
	}
	
}
