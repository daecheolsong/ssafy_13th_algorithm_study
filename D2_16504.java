package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] room = new int[N][100];
            //건물 최대 높이
            int max = 0;
            
            int[] m = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()); // {7 4 2 0 0 6 0 7 0}
      
            //높이  받기
            for(int i = 0; i < N; i++) {
            	m[i] = Integer.parseInt(st.nextToken());
            	//최대 높이
            	if(max < m[i]) {
            		max = m[i];
            	}
            }
           
            // 높이 만큼 1 저장
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < m[i]; j++) {
            		room[i][j] = 1;
            	}
            }
            
            // 최대 낙차
            int Max = 0;
            //배열 탐색 
            for (int i = 0; i < max; i++) {
            	for(int j = 0; j < N; j++) {
            		//  비교값
            		int sum = 0;
            		if(room[j][i] == 1) {
            			for(int k = j+1; k < N; k++) {
            				if (room[k][i] == 0) {
            					sum++;
            				}
            				Max = Math.max(Max, sum);
            			}
            		}
            	}
            }
           
            sb.append("#"+t+" " + Max +"\n");
        }
        System.out.println(sb);
    }
}