package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String[] str = br.readLine().split("");
			int[] arr = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			if(arr[0] == 0) break;

			int cnt = 0;
			for (int i = 0, j = arr.length - 1; i < arr.length /2 ; i++, j--) {
					if(arr[i] == arr[j]) {
						cnt++;
					}
			}

			if(cnt == arr.length / 2) {
				sb.append("yes").append("\n");
			}
			else {
				sb.append("no").append("\n");
			}
			
			
			
		}
		System.out.println(sb);
	}	
}
