import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> noEar = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			noEar.put(br.readLine(), 1);
		}
		
		List<String> noEarEye = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			noEar.put(name, noEar.getOrDefault(name, 0) + 1);
			if(noEar.get(name)==2) noEarEye.add(name);
		}
		
		Collections.sort(noEarEye);
		
		sb.append(noEarEye.size()).append("\n");
		for(String ele : noEarEye) {
			sb.append(ele).append("\n");
		}
		System.out.println(sb);
	}

}
