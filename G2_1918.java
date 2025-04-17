import java.util.*;
import java.io.*;

public class G2_1918 {

	static String text;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		text = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			
			switch(c) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
					sb.append(stack.pop());
				}
				stack.add(c);
				break;
				
			case '(':
				stack.add(c);
				break;
				
			case ')':
				while(!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
				break;
				
			default:
				sb.append(c);
			}
			
		}
		

		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
	
	static int priority(char c) {
		if(c == '(' || c == ')') {
			return 0;
		}
		else if(c == '+' || c == '-') {
			return 1;
		}
		else if(c == '*' || c == '/') {
			return 2;
		}
		
		return -1;
	}

}
