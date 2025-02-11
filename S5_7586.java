package algorithm.class2;

import java.io.*;
import java.lang.*;
import java.util.*;

public class S5_7586 {

	public static void main(String[] args) throws Exception, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	
	    
	    int[][] arr = new int[n][2];
	    int[] rank = new int[n];
	    
	    for(int i=0; i<n; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        arr[i][0] = Integer.parseInt(st.nextToken());
	        arr[i][1] = Integer.parseInt(st.nextToken());        
	        
	    }
	    
//	    for(int i=0; i<n; i++) {
//	    	System.out.printf("%d %d", x[i], y[i]);
//	    	System.out.println();
//	    }
	    
	    for(int i=0; i<n; i++) {
	        int k = 0;
	    	for(int j=0; j<n; j++) {
	    		if(i==j) continue;
	    		
	    		if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) {
	    			k++;
	    		}
	    	
	    
	    }	    
	    rank[i] = k + 1;
	    System.out.println(rank[i]);
	    }
	}
}
