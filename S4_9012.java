package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine()); 
        
        for (int i = 0; i < T; i++) {
            init();
        }
        
        System.out.print(sb);
    }
    
    private static void init() throws IOException {
    	String ps = br.readLine(); 
        sb.append(isValidPS(ps) ? "YES" : "NO").append("\n");
		
	}

    public static boolean isValidPS(String p) {
        Stack<Character> stack = new Stack<>(); 
        
        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c); 
            } else { 
                if (stack.isEmpty()) {
                    return false; 
                }
                stack.pop(); 
            }
        }
      
        return stack.isEmpty(); 
    }
}
