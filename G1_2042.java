import java.util.*;
import java.io.*;

class SegmentTree{
	long tree[]; //각 원소가 담길 트리
	int treeSize;
	
	public SegmentTree(int arrSize) {
		int h = (int) Math.ceil(Math.log(arrSize)/Math.log(2)); // 트리 높이 구하기
		this.treeSize = (int) Math.pow(2, h+1);
		tree = new long[treeSize]; 
	}
	// 원소 배열, 현재 노드, 현재 구간 배열 시작, 현재 구간 배열 끝
	public long init(long[] arr, int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start]; // 만약 시작과 끝이 같다면 원소 값 그대로 담기
		}
		
		return tree[node] = init(arr, node*2, start, (start + end)/2) + init(arr, node*2+1, (start+end)/2+1, end);
	}
	
	public void update(int node, int start, int end, int idx, long diff) {
		if(idx < start || end < idx) return; //만약 변경할 idx 값이 start보다 작거나 end보다 크면 불필요
		//현재 노드 수정
		tree[node] += diff;
		
		//마지막 노드가 아니라면? 자식 노드들 업데이트
		if(start != end) {
			update(node*2, start, (start+end)/2, idx, diff);
			update(node*2+1, (start+end)/2+1, end, idx, diff);
		}
	}
	
	//현재 노드, 배열의 시작, 배열의 끝, 원하는 누적합의 시작, 원하는 누적합의 끝
	public long sum(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return 0;
		if (left <= start  && end <= right ) {
			return tree[node];
		}
		
		return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2 +1, end, left, right);
	}
}

public class G1_2042 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree seg = new SegmentTree(n);
		
		seg.init(arr, 1, 1, n);
		
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				seg.update(1, 1, n, b, c - arr[b]);
				arr[b] = c;
			}
			
			else if (a == 2) {
				System.out.println(seg.sum(1, 1, n, b, (int) c));
			}
		}
		
	}

}
