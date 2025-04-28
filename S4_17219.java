import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String password = st.nextToken();
			
			map.put(site, password);
			
		}
		
		for (int i = 0; i < M; i++) {
			String site = br.readLine();
			sb.append(map.get(site) + "\n");
		}
		System.out.println(sb);
		
	}

}
