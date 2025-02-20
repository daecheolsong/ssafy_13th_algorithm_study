import java.util.*;
import java.io.*;

public class G5_1931 {
	static int N;
	static int[][] list;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list, (a, b) -> { //시간 정렬
			if(a[1] == b[1]) return a[0] - b[0]; //끝나는 시간이 같으면 시작시간 기준으로 정렬
			return a[1] - b[1];
		});
		
		int count = 0;
		int end = 0;
		
		for (int i = 0; i < N; i++) { //첫번째부터 시작해서 끝나는시간보다 같거나 늦게시작하는 애들 담음
			if (list[i][0] >= end) {
				count++;
				end = list[i][1];
			}
		}
		
		System.out.println(count);
	}
	
//	static void dfs(int sum, int end) {
//		for (int i = 0; i < N; i++) {
//			if (list[i][0] >= end) {
//				dfs(sum+1, list[i][1]);
//				dfs(sum, end);
//			}
//		}
//		result = Math.max(result, sum);
//		return;
//	}

}
