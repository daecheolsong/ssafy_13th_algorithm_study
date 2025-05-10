import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	

	static int N, M, E;
	static int[] parent; 
	public static void main(String args[]) throws IOException {
		init();
		System.out.println(E);
	}
	private static int find(int x) {
	        if (parent[x] == x) return x;
	        return parent[x] = find(parent[x]); // 경로 압축
	    }
  
	static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX; // y의 부모를 x로 설정
        }
    }
	
	private static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		E = 0;	
		
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			 if (find(i) == find(j)) {
	                E = m; 
	                break; 
	            }
			 union(i, j);
		}
		
	}
}
