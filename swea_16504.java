package algorithm;

import java.io.*;
import java.lang.*;
import java.util.*;

public class swea_16504 {

	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<T; t++) {			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][100];
			int max=0; // 최고 높이 값
			int[] m = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				m[i] = Integer.parseInt(st.nextToken());
				if(max < m[i]) {
					max = m[i];
				}
			}
			// 회전 후 상자 상태
			for(int i=0; i<n; i++) {
				for(int j =0; j<m[i]; j++) {
					arr[i][j]=1;
				}
			}
			
			int Max = 0; // 최대 낙차 값
			for(int i=0; i<max; i++) {
				for(int j=0;j<n;j++) {
					int sum = 0; 
					if(arr[j][i] == 1) { // 상자 시작점
						for(int k=j+1; k<n; k++) { // 상자 다음부터 낙차 카운트
							if(arr[k][i]==0) {
								sum+=1;
							}								
						}						
					}
					Max = Math.max(Max, sum);
				}
			}
			sb.append("#"+(t+1)+" "+Max+"\n");
		}
		System.out.println(sb);

	}

}
