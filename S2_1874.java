import java.util.*;
import java.io.*;

public class S2_1874 {
	static int cnt = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int n= Integer.parseInt(br.readLine());
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			int num = list[i];
			
			while(cnt <= num) {
				stack.push(cnt++);
				sb.append("+\n");
			}
			
			if (!stack.empty() && stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			}
			
			else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(sb);

	}
	
//	static void stack(int x) {
//		if (x == list.size()-1) {
//			if (stack.peek() == list.get(n-1)) {
//				sb.append("-"+"\n");
//				System.out.print(sb);
//			return;
//			}
//			System.out.println("NO");
//			return;
//		}
//		if ((list.get(x) != stack.peek()) && list.get(x) >= cnt) {
//			stack.add(cnt);
//			sb.append("+"+"\n");
//			cnt++;
//			stack(x);
//		}
//		if (list.get(x) == stack.peek()) {
//			stack.pop();
//			sb.append("-"+"\n");
//			stack(x+1);
//		}
//		if (list.get(x) != stack.peek() && list.get(x) < cnt) {
//			System.out.println("NO");
//			return;
//		}
//	}

}
