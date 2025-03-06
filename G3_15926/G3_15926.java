import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G3_15926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		Stack<Integer> s = new Stack<>();
		s.push(-1);
		
		int maxL = 0;
		
		for(int i = 0; i < n; i ++) {
			char c = str.charAt(i);
			
			if(c == '(') {
				s.push(i);
			} else if(c == ')') {
				s.pop();
				if(!s.isEmpty()) {
					maxL = Math.max(i - s.peek(), maxL);
				} else {
					s.push(i);
				}
			}
		}
		System.out.println(maxL);
	}

}
