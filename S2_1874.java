package BOJ;

import java.io.*;
import java.util.*;

public class S2_1874 {

	static int n;
	static int[] a;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// 수열 저장
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int num = 1;
		boolean result = true;
		
		for (int i = 0; i < n; i++) {
			if(a[i] >= num) {
				while(a[i]>=num) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			}
			else {
				int N = stack.pop();
				if(N>a[i]) {
					System.out.println("NO");
					result = false;
					break;
				}
				else {
					sb.append("-\n");
				}
			}
		}
		if(result) System.out.println(sb.toString());
	}
}
