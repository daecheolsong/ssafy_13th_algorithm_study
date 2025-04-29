import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class G2_4195 {

	static int[] parent, count;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        for (int T = 0; T < t; T++) {
        	int n = Integer.parseInt(br.readLine());
        	parent = new int[n * 2];
        	count = new int[n * 2];
        	
        	for (int i = 0; i < n * 2; i++) {
        		count[i] = 1;
        		parent[i] = i;
        	}
        	Map<String, Integer> map = new HashMap<>();
        	int index = 0;
        	
        	for (int i = 0; i < n; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		String s1 = st.nextToken();
        		String s2 = st.nextToken();
        		int idx1, idx2;
        		
        		if (map.containsKey(s1)) {
        			idx1 = map.get(s1);
        		} else {
        			map.put(s1, index);
        			idx1 = index++;
        		}
        		
        		if (map.containsKey(s2)) {
        			idx2 = map.get(s2);
        		} else {
        			map.put(s2, index);
        			idx2 = index++;
        		}
        		
        		if (find(idx1) != find(idx2)) {
        			union(idx1, idx2);
        		}
        		        		
        		sb.append(count[parent[idx1]]).append("\n");
        	}
        }

        System.out.println(sb);
    }
    
    static int find(int a) {
    	if (a == parent[a]) return a;
    	
    	return parent[a] = find(parent[a]);
    }
    
    static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	
    	count[a] += count[b];
		parent[b] = a;
    }
} 
