import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while(q.size()>1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.poll());
	
	
	
	}
}
