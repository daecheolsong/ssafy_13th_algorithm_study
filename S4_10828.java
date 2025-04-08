package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.concurrent.locks.StampedLock;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		//스택만들기
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			//명령 처리
			String cmd = br.readLine();
			
			//push 받기 뒤에 숫자가 있기 때문에 startWith으로 받기
			if(cmd.startsWith("push")) {
				int num = Integer.parseInt(cmd.split(" ")[1]);
				stack.push(num);
			} else if (cmd.equals("pop")) { // pop 수행
				//스택이 비어있으면 -1출력 아미녀 pop()수행
				if (stack.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(stack.pop()).append("\n");
				}
			} else if(cmd.equals("size")) {
				//사이즈 출력
				sb.append(stack.size()).append("\n");
			} else if(cmd.equals("empty")) {
				//비어있는지 확인
				if(stack.isEmpty()) {
					//비면 1
					sb.append("1").append("\n");
				} else {
					//아니면 0
					sb.append("0").append("\n");
				}
			} else {
				if(stack.isEmpty()) {
					//비어있으면
					sb.append("-1").append("\n");
				}else {
					sb.append(stack.peek()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}	
}
