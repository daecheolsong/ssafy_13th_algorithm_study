import java.io.*;
import java.util.*;

public class S2_1927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> list = new PriorityQueue<>();
		
		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (list.size() <= 0) {
					sb.append(0 + "\n");
				}
				else {
					sb.append(list.poll() + "\n");
				}
			}
			else {
				list.add(num);
			}
		}
		
		System.out.println(sb);

	}

}
