package BOJ.class2;

import java.io.*;
import java.util.*;

public class S4_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
        	StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			
			if(S.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
			else if(S.equals("pop")) {
				if(!stack.empty()) sb.append(stack.pop()).append("\n");
				else sb.append(-1).append("\n");
			}else if(S.equals("size")) {
                sb.append(stack.size()).append("\n");
			}else if(S.equals("empty")) {
				if(!stack.empty()) sb.append(0).append("\n");
				else sb.append(1).append("\n");
			}else {
				if(!stack.empty()) sb.append(stack.peek()).append("\n");
				else sb.append(-1).append("\n");
			}
		}
        System.out.println(sb);
	}
}
