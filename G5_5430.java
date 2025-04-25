import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int T, N, arr[];

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init();
			System.out.print(sb);
		}
	}

	static void init() throws IOException {
		sb.setLength(0);
		String str = br.readLine();

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String sarr = br.readLine();

		sarr = sarr.replace("[", "").replace("]", "");

		if (N == 0 && str.contains("D")) {
			sb.append("error").append("\n");
			return;
		}

		st = new StringTokenizer(sarr, ",");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		int dis = 0;
		int backIdx = N - 1;
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'R') {
				dis += 1;
			} else if (str.charAt(i) == 'D') {
			
				sum++;
				if (dis == 0 || dis % 2 == 0) { // 방향이 정방향이면
					if(idx >= N) {
						sb.append("error").append("\n");
						return;
					}
					arr[idx] = 0;
					idx++;
				}else { // 역방향이면
					if(backIdx < 0) {
						sb.append("error").append("\n");
						return;
					}
					arr[backIdx] = 0;
					backIdx--;
				}
			}
		}
	
		if(sum > N || idx - backIdx > N && str.contains("D")) {
			sb.append("error").append("\n");
			return;
		}
		dis %= 2;
		go(dis);
		
	}


	private static void go( int dis) {
		sb.setLength(0);
		sb.append("[");
		if (dis == 1) {
			for (int i = N - 1; i >= 0; i--) {
				if(arr[i] != 0) {
					sb.append(arr[i]).append(",");
				}
			}
			if (sb.length() == 1) {
				sb.append("]").append("\n");
				return;
			} else {
				sb.setCharAt(sb.length() - 1, ']');
				sb.append("\n");
				return;
			}

		} else if (dis ==0) {
			for (int i = 0; i < N; i++) {
				if(arr[i] != 0) {
					sb.append(arr[i]).append(",");
				}
			}
			if (sb.length() == 1) {
				sb.append("]").append("\n");
				return;
			} else {
				sb.setCharAt(sb.length() - 1, ']');
				sb.append("\n");
				return;
			}

		}
		
		sb.append(false).append("]").append("\n");
	}

}
