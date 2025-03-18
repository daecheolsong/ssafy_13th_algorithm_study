import java.io.*;
import java.util.*;

public class S5_11000 {

	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		PriorityQueue<T> pq = new PriorityQueue<>((t1, t2) -> t1.s == t2.s ? t1.t - t2.t : t1.s - t2.s);
		PriorityQueue<Integer> end = new PriorityQueue<>(); // 배정된 강의실 들 중 가장 빨리 비우는 시간
		for(int i = 0; i < n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new T(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		end.add(0);
		
		while(!pq.isEmpty()) {
			T task = pq.poll();
			if(end.peek() <= task.s) {
				end.poll();
			}
			end.add(task.t);
		}
		
		System.out.println(end.size());
		
	}
	
	static class T {
		int s;
		int t;
		public T (int s, int t) {
			this.s = s;
			this.t = t;
		}
	}
}
