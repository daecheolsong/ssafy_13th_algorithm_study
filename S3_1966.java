import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static ArrayList<Integer>[] list;
    static int T, N, M;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
    	StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	
        	LinkedList<int[]> q = new LinkedList<>();
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
				q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}
        	
        	int cnt = 0;
        	
        	while(!q.isEmpty()) {
        		int[] cur = q.poll();
        		boolean isMax = true;
        		
        		for (int i = 0; i < q.size(); i++) {
        			
        			if(cur[1] < q.get(i)[1]) {
        				q.offer(cur);
        				
        				for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
        				
        				isMax =false;
        				break;
        			}
					
				}
        		
        		if(isMax==false) continue;
        		
        		cnt++;
        		if(cur[0] == M) break;
        		
        	}
        	sb.append(cnt).append("\n");
			
		}
        System.out.println(sb);
        
    }

}
