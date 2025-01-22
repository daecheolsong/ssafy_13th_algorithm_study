import java.io.*;
import java.util.*;

class G5_1074 {
	
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
				
		dfs((int)Math.pow(2, n), r, c);
		System.out.print(answer);
	}

	static void dfs(int size, int r, int c) {
		if (size == 1) {
			return;
		}
		
		if (r < size / 2 && c < size / 2) {
			dfs(size / 2, r, c);
		} else if (r < size / 2 && c >= size / 2) {
			answer += size * size / 4;
			dfs(size / 2, r, c - (size / 2));
		} else if (r >= size / 2 && c < size / 2) {
			answer += size * size / 4 * 2;
			dfs(size / 2, r - (size / 2), c);
		} else if (r >= size / 2 && c >= size / 2) {
			answer += size * size / 4 * 3;
			dfs(size / 2, r - (size / 2), c - (size / 2));
		}
	}
}
