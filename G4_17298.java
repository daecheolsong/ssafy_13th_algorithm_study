package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class G4_17298 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] result = new int[N];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	
		for(int i = 0; i < N; i++) {
			// 스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클경우
			while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
				result[stack.pop()] = A[i];
			}
			stack.push(i); // 신규 인덱스 삽입
		}
		while( !stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(result[i]).append(" "); 
		}
		System.out.println(sb);
	}
}