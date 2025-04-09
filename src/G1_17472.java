import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G1_17472 {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for(int i =0;i<N ;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		num=0;
		for(int i =0 ; i< N ; i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1 && visited[i][j]==0) {
					
					dfs(j,i,++num);
				}
			}
		}
		
//		for(int i=0; i<N;i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
		edgeList = new ArrayList<>();
		for(int i =0; i< N ; i++) {// 모든 edgelist 설치
			for(int j=0; j<M ; j++) {
				if(visited[i][j]==0) {
					continue;
				}
				for(int d =0 ; d<4 ;d++) {
					makeBridge(j,i,d);					
				}
			}
		}
		
		make();
		Collections.sort(edgeList);
		
		int sol =0;
		int count =0;
		for(Edge edge : edgeList) {
			int from = edge.from-1;
			int to = edge.to-1;
			int weight = edge.weight;
			
			if(union(from,to)) {
				sol += weight;
				
				if(++count == num-1) {
					
					break;
				}
				
			}
			//System.out.println(edge);
			
		}
		
		System.out.println(count!=num-1?-1:sol);
		
	}
	public static int N,M;
	static int num;
	public static int[] p;
	public static int[][] visited;
	public static int[][] map;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static List<Edge> edgeList;
	public static void dfs(int x, int y, int num) {
		visited[y][x] = num;
		
		for(int i =0; i<4 ; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			//System.out.println(nextX + ":" + nextY);
			if(!isRange(nextX, nextY)) {
				continue;
			}
			if(visited[nextY][nextX]==0 && map[nextY][nextX] == 1 ) {
				dfs(nextX,nextY,num);
			}
		}
		
	}
	
	public static boolean isRange(int x,int y) {
		return x>=0 && x<M && y>=0 && y<N;
	}
	
	public static void makeBridge(int x,int y, int d) {
		int power =0;
		int from = visited[y][x];
		while(true) {
			x+=dx[d];
			y+=dy[d];
			if(!isRange(x,y)) {
				return;
			}
			if(visited[y][x]==from) {
				return;
			}
			
			if(visited[y][x]!=0) {
				if(power>1) {
					edgeList.add(new Edge(from, visited[y][x], power));					
				}
				return;
			}
			power++;
			
		}
		
	}
	
	public static void make() {
		p = new int[num];
		for(int i = 0 ; i<p.length ; i++) {
			p[i] = i;
		}
	}
	
	public static int find(int a) {
		if(p[a]==a) {
			return a;
		}
		return p[a] = find(p[a]);
	}
	
	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) {
			return false;
		}
		
		if(rootA < rootB) {
			p[rootA] = rootB;
		}else {
			p[rootB] = rootA;
		}
		return true;
	}

}
