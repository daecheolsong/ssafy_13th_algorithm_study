import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, cnt;
	static HashSet<String> set;
	static TreeSet<String> res;
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(res.size());
		System.out.println(sb);
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>();
		res = new TreeSet<>();
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				res.add(str);
			};
		}
		
		for (String string : res) {
			sb.append(string).append("\n");
		}
	}

}
