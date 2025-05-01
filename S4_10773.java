import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
        	int cash = Integer.parseInt(br.readLine());
        	if(cash == 0) stack.pop();
        	else stack.push(cash);
        	
		}
        
        int sum = 0;
        while(!stack.isEmpty()) {
        	sum+=stack.pop();
        }
        System.out.println(sum);
    }

}
