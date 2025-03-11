package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_2042 {
	
	static long[] arr, tree;
	static int n, m, k;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		tree = new long[n * 4];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		build(0, n - 1, 1);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) update(0, n - 1, 1, b - 1, c);
			else {
				sb.append(query(0, n - 1, 1, b - 1, (int)c - 1)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static long build(int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
	
		int mid = (start + end) / 2;
		return tree[node] = build(start, mid, node * 2) + build(mid + 1, end, node * 2 + 1);
	}
	
	static long query(int start, int end, int node, int left, int right) {
		if (right < start || left > end) return 0;
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
	}
	
	static void update(int start, int end, int node, int index, long value) {
		if (index < start || index > end) return;
		if (start == end) {
			tree[node] = value;
			arr[index] = value;
			return;
		}
		
		int mid = (start + end) / 2;
		update(start, mid, node * 2, index, value);
		update(mid + 1, end, node * 2 + 1, index, value);
		
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}
