import java.io.*;
import java.util.*;
public class Main {
	static int [] mvc = {0, 1, 0, -1};
	static int [] mvr = {-1, 0, 1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int minR = Integer.MAX_VALUE;
		int maxR = 0;
		
		int minC = Integer.MAX_VALUE;
		int maxC = 0;
		for(int i = 0; i < n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char [] chars = st.nextToken().toCharArray();
			for(int j = 0; j < n; j ++) {
				if(chars[j] == 'G') {
					minR = Math.min(minR, i);
					maxR = Math.max(maxR, i);

					minC = Math.min(minC, j);
					maxC = Math.max(maxC, j);
				}
			}
		}
		
		if(minR == maxR && minC == maxC) {
			System.out.println(0);
			return;
		}
		
		int cDiff = Math.min(maxC, n - minC - 1);
		int rDiff = Math.min(maxR, n - minR - 1);
		
		if(minR == maxR) {
			System.out.println(cDiff);
			return;
		}
		
		if(minC == maxC) {
			System.out.println(rDiff);
			return;
		}
		
		System.out.println(cDiff + rDiff);
		
	}
	
	
}

