import java.io.*;
import java.util.*;

public class S2_5567 {
  
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		List<List<Integer>> g = new ArrayList<>();
		
		for(int i = 0; i <= n; i ++) {
			g.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(from > to) {
				int temp = from;
				from = to;
				to = temp;
			}
			g.get(from).add(to);
			g.get(to).add(from);
		}

	
		
		int size = g.get(1).size();
		int [] v = new int[m + 1];
		v[1] = 1;
		
		for(int adj : g.get(1)) {
			v[adj] = 1;
		}
		
		for(int adj : g.get(1)) {
			for(int adjadj : g.get(adj)) {
				if(v[adjadj] == 0) {
					size ++;
					v[adjadj] = 1;
				}
			}
		}
		
		System.out.println(size);
		
		
	}
}
