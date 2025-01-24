import java.util.*;
import java.io.*;
public class S2_1927 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e1 - e2);
		
		for(int i = 0; i < n ; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.isEmpty()) {
					System.out.println("0");
					continue;
				}
				System.out.println(pq.poll());
				continue;
			}
			pq.add(num);
		}
		
	}
}
