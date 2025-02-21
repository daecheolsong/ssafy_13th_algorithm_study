import java.io.*;
import java.util.*;
 
public class G3_2023 {
    static int n;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dfs(0, 0);
        System.out.println(sb);
    }
    
    
    public static void dfs(int cnt, int answer) {
    
    	if(answer >= 1 && !isPrime(answer)) {
    		return;
    	}
    	if(cnt == n) {
    		if(isPrime(answer)) {
    			sb.append(answer).append("\n");	
    		}
    		return;
    	}
    	

    	for(int i = 1; i <= 9; i ++) {
    		int next = answer * 10 + i;
    		dfs(cnt + 1, next);
    	}
    }
    
    
    private static boolean isPrime(int n) {
    	if(n <= 1) {
    		return false;
    	}
    	for(int i = 2; i * i <= n ; i++) {
    		if(n % i == 0) {
    			return false;
    		}
    	}
    	return true;
    }
}
