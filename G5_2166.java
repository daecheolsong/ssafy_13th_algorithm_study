import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static long map[][];
	static double res;

	public static void main(String[] args) throws IOException {

		init();
		go();

		System.out.printf("%.1f\n", res);
	}

	private static void go() {
		long sumX = 0;
		long sumY = 0;

		for (int i = 0; i < N - 1; i++) {
			sumX += map[i][0] * map[i + 1][1];
			sumY += map[i][1] * map[i + 1][0];
		}
		sumX += map[N - 1][0] * map[0][1];
		sumY += map[N - 1][1] * map[0][0];
		
		res = Math.abs(sumX - sumY) / 2.0;

	}

	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new long[N][2];
		
		res = 0.0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[i][0] = x;
			map[i][1] = y;
		}
		    
			
	}
}
