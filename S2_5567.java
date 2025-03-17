import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_5567 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
            list[b].add(a);
		}
		
		// 이미 확인한 친구인지 알기 위한 visit
		boolean[] visit = new boolean[n + 1];
		int count = 0;
		
		for (int i = 0; i < list[1].size(); i++) {
			// 김싸피 친구
			int a = list[1].get(i);
			if (!visit[a]) {
				count++;
				visit[a] = true;
			}
			
			// 김싸피 친구의 친구
			for (int j = 0; j < list[a].size(); j++) {
				int b = list[a].get(j);
				if (!visit[b] && b != 1) {
					count++;
					visit[b] = true;
				}
			}
		}
		
		System.out.println(count);
	}
}
