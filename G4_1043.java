import java.util.*;
import java.io.*;

public class G4_1043 {
	static int N, M;
	static int[][] party;
	static List<Integer> knows = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		party = new int[M][];
		int result = 0;
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++) {
			knows.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			party[i] = new int[size];
			for (int s = 0; s < size; s++) {
				party[i][s] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		boolean changed;
		do {
			changed = false;
			for (int i = 0; i < M; i++) {
				boolean contain = false;
				for (int friend:party[i]) {
					if (knows.contains(friend)) {
						contain = true;
						break;
					}
				}
				
				if (contain) {
					for(int friend:party[i]) {
						if(!knows.contains(friend)) {
							changed = true;
							knows.add(friend);
						}
					}
				}
			}
		} while(changed);
		
		for (int i = 0; i < M; i++) {
			boolean flag = true;
			for (int friend: party[i]) {
				if (knows.contains(friend)) {
					flag = false;
				}
			}
			if (flag) result++;
		}
		
		System.out.println(result);
	}

}
