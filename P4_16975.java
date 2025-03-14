import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4_16975 {	

	static long[] arr, tree, lazy;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
	
		int n = Integer.parseInt(br.readLine());
		arr = new long[n];
		tree = new long[n * 4];
		lazy = new long[n * 4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		build(0, n - 1, 1);
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				int value = Integer.parseInt(st.nextToken());
				
				updateRange(0, n - 1, start, end, 1, value);
			} else {
				int x = Integer.parseInt(st.nextToken()) - 1;
				
				sb.append(query(0, n - 1, x, 1)).append("\n");
			}
		}
		
	    System.out.println(sb);
	}
	
	static long build(int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
		
		int mid = (start + end) / 2;
		return tree[node] = build(start, mid, node * 2) + build(mid + 1, end, node * 2 + 1);
	}
	
	static void updateRange(int start, int end, int left, int right, int node, long value) {
		propagation(start, end, node);
		
		if (right < start || end < left) return;
		
		if (left <= start && end <= right) {
			tree[node] += (end - start + 1) * value;
			if (start != end) {
				lazy[node * 2] += value;
				lazy[node * 2 + 1] += value;  
			}
			
			return;
		}
		
		int mid = (start + end) / 2;
		updateRange(start, mid, left, right, node * 2, value);
		updateRange(mid + 1, end, left, right, node * 2 + 1, value);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	
	static long query(int start, int end, int index, int node) {
		propagation(start, end, node);
		
		if (index < start || end < index) return 0;
		
		if (index <= start && end <= index) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		return query(start, mid, index, node * 2) + query(mid + 1, end, index, node * 2 + 1);
	}
	
	static void propagation(int start, int end, int node) {
		if (lazy[node] == 0) return;
		
		tree[node] += (end - start + 1) * lazy[node];
		
		if (start != end) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}
		lazy[node] = 0;
	}
}
