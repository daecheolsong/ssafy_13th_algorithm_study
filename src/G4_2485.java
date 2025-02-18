import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_2485 {
	
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arrayLists = new ArrayList[N];
		ArrayList<Integer>[] arrayLists1 = new ArrayList[N];
		
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arrayLists[i] = new ArrayList<>();
			arrayLists1[i] = new ArrayList<>();
		
		}
			
	
		
		for(int i=0; i< M ;i++) {
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken())-1;
			int big = Integer.parseInt(st.nextToken())-1;
			
			arrayLists[small].add(big);
			arrayLists1[big].add(small);
			
			
		}
		
		int count =0;
		for(int i =0 ; i< N ; i++) {
			visited = new boolean[N];
			dfs(i,arrayLists);
			dfs(i,arrayLists1);
			
			if(check(visited)) {
				count++;
			}
			
		}
		System.out.println(count);
		
		
	}
	
	public static boolean check(boolean[] visited) {
		for(int i=0; i< visited.length ; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void dfs(int node , ArrayList<Integer>[] arrayLists) {
		visited[node] = true;
		
		for(int tempNode : arrayLists[node]) {
			if(!visited[tempNode]) {
				dfs(tempNode,arrayLists);
			}
			
		}
		
	}

}
