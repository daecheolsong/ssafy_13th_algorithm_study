import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, res;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {

		init();
		go();

		System.out.println(res);
	}


	private static void go() {
		int cut = gcd(N, M);
		res = M - cut;
	}


	private static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}


	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = 0;
			
	}
}
