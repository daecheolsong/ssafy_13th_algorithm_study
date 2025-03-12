import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_2357 {
	
	static long[] arr, minTree, maxTree;
	static int n, m;
	static long min, max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new long[n];
		minTree = new long[n * 4];
		maxTree = new long[n * 4];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		minInit(0, n - 1, 1);
		maxInit(0, n - 1, 1);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			min = minQuery(0, n - 1, a - 1, b - 1, 1);
			max = maxQuery(0, n - 1, a - 1, b - 1, 1);
			
			sb.append(min).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static long minInit(int start, int end, int node) {
		if (start == end) return minTree[node] = arr[start];
		
		int mid = (start + end) / 2;
		return minTree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
	}
	
	static long maxInit(int start, int end, int node) {
		if (start == end) return maxTree[node] = arr[start];
		
		int mid = (start + end) / 2;
		return maxTree[node] = Math.max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
	}
	
	static long minQuery(int start, int end, int left, int right, int node) {
		if (right < start || left > end) return Long.MAX_VALUE;
		if (left <= start && end <= right) {
			return minTree[node];
		}
		
		int mid = (start + end) / 2;
		return Math.min(minQuery(start, mid, left, right, node * 2), minQuery(mid + 1, end, left, right, node * 2 + 1));
	}
	
	static long maxQuery(int start, int end, int left, int right, int node) {
		if (right < start || left > end) return Long.MIN_VALUE;
		if (left <= start && end <= right) {
			return maxTree[node];
		}
		
		int mid = (start + end) / 2;
		return Math.max(maxQuery(start, mid, left, right, node * 2), maxQuery(mid + 1, end, left, right, node * 2 + 1));
	}
}
