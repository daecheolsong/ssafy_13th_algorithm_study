package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S1_11286 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				 int result = Math.abs(o1) - Math.abs(o2);
				 if (Math.abs(o1) == Math.abs(o2)) {
					 result = o1 - o2;
				 }
				 
				 return result;
			}
		}
		);
		
		for(int i = 0; i < N; i++) {
			int action = Integer.parseInt(br.readLine());
			if(action == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				} else{
					sb.append(pq.poll()).append("\n");
				}
				continue;
			}
			pq.add(action);
		}
		System.out.println(sb);
	
	
	}
}
