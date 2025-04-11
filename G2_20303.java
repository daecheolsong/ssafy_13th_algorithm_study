import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G2_20303 {

	static int n, m, k;
	static int[] candies, parent, dp, count;
	static List<Child> list = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        init();
        solution();

        System.out.println(dp[k - 1]);
    }
    
    static void solution() {
    	for (int i = 1; i <= n; i++) {
    		if (i != parent[i]) continue;

    		list.add(new Child(candies[i], count[i]));
    	}
    	
    	for (Child c : list) {
    		for (int i = k - 1; i >= c.count; i--) {
    			dp[i] = Math.max(dp[i], dp[i - c.count] + c.candy);
    		}
    	}
    }
    
    static int find (int a) {
    	if (parent[a] == a) return a;
    	
    	return parent[a] = find(parent[a]);
    }
    
    static void union(int a, int b) {
    	int rootA = find(a);
    	int rootB = find(b);
    	
    	if (rootA < rootB) {
    		parent[rootB] = rootA;
    		candies[rootA] += candies[rootB];
    		count[rootA] += count[rootB];
    	} else if (rootA > rootB) {
    		parent[rootA] = rootB;
    		candies[rootB] += candies[rootA];
    		count[rootB] += count[rootA];
    	}
    }

    
    static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        candies = new int[n + 1];
        parent = new int[n + 1];
        count = new int[n + 1];
        dp = new int[k + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
        	candies[i] = Integer.parseInt(st.nextToken());
        	parent[i] = i;
        	count[i] = 1;
        } 
        
        for (int i = 1; i <= m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if (find(a) != find(b)) {
        		union(a, b);
        	}
        }
        
        for (int i = 1; i <= n; i++) {
        	parent[i] = find(i);
        }
    }
    
    static class Child{
    	int candy;
    	int count;
    	
		public Child(int candy, int count) {
			this.candy = candy;
			this.count = count;
		}
    }
}
