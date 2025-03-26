import java.io.*;
import java.util.*;


public class G4_7662 {

	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < n; t ++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for(int i = 0; i < k; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char op = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());			
				if(op == 'I') {
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					if(map.isEmpty()) {
						continue;
					}
					if(num == 1) {
						pop(map, map.lastKey());
					} else {
						pop(map, map.firstKey());
					}
				}
			}
			
			if(map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}
	}
	private static void pop(TreeMap<Integer, Integer> map, int key) {
		int cnt = map.get(key);
		if(cnt == 1) {
			map.remove(key);
		} else {
			map.put(key, cnt - 1);	
		}
		
	}
}
