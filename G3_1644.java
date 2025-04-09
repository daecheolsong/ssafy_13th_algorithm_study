import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G3_1644 {
	static List<Integer> primeList;
    static int n;
    static boolean[] isPrime;
    
    public static void main(String[] args) throws IOException {
        init();

        System.out.println(check());
    }
    
    static int check() {
    	if (n == 1) return 0;
    	else if (n == 2) return 1;
    	
    	int min = 0;
    	int max = 0;
    	int sum = 0;
    	int count = 0;
    	
    	while (max < primeList.size() && min <= max) {
    		if (sum < n) {
    			sum += primeList.get(max++);
    		} else {
    			if (sum == n) count++;
    			
    			sum -= primeList.get(min++);
    		}
    	}
    	
    	return isPrime[n] ? ++count : count;
    }
    
    static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        primeList = new ArrayList<>();
        
        isPrime[0] = isPrime[1] = false;
        for (long i = 2; i <= n; i++) {
        	if (!isPrime[(int)i]) continue;
        	primeList.add((int)i);
        	for (long j = i * i; j <= n; j += i) {
        		isPrime[(int)j] = false;
        	}
        }
    }
}
