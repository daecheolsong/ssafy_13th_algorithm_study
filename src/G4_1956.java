import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1956 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[V][V];
		
		for(int i =0 ;i< V ; i++) {
			for(int j =0; j<V ;j++) {
				if(i==j) {
					map[i][j]=0;
				}else {
					map[i][j] = Integer.MAX_VALUE;					
				}
			}
		}
		
		for(int i =0 ; i< E ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int value = Integer.parseInt(st.nextToken());
			
			
			map[start][end]=value;
		}
		
		
		
		for(int k =0; k<V ; k++) {
			for(int i=0; i< V ; i++) {
				for(int j=0; j<V; j++) {
					if(map[i][k]!=Integer.MAX_VALUE&&map[k][j]!=Integer.MAX_VALUE) {					
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);					
					}
								
				}
			}
			
		}
		
		int Min = Integer.MAX_VALUE;
		
		for(int i=0; i<V ; i++) {
			for(int j=0; j<V ; j++) {
				if(i==j) {
					continue;
				}
				
				if(map[i][j]!=Integer.MAX_VALUE&&map[j][i]!=Integer.MAX_VALUE) {
					Min = Math.min(map[i][j]+map[j][i], Min);
				}
				
			}
		}
		
		System.out.println(Min==Integer.MAX_VALUE?-1:Min);
		
		
	
	}

}
