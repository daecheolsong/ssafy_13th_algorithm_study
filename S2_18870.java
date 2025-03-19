import java.io.*;
import java.util.*;

public class S2_18870 {
	static ArrayList<Integer> list;
	static int[] list2;
	static int count;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		list2 = new int[N];
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			list2[i] = Integer.parseInt(st.nextToken());
			list.add(list2[i]);
		}
		
		ArrayList<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
		
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int num : sortedList) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }
        
        for (int i = 0; i < N; i++) {
            sb.append(map.get(list2[i])).append(" ");
        }

        System.out.println(sb);
        
	}

}
