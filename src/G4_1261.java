import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1261 {
	
	public static class Node{
		int nodeX;
		int nodeY;
		int value;
		public Node(int nodeX, int nodeY, int value) {
			this.nodeX = nodeX;
			this.nodeY = nodeY;
			this.value = value;
		}
		
	}
	
	public static int[][] dist;
	public static int[][] arr;
	
	public static int[] dx =  {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i =0 ; i< N ; i++) {
			String temp = br.readLine();
			for(int j = 0; j<M ;j++) {
				arr[i][j] = temp.charAt(j)-'0';
			}
			
		}
		
//		for(int i=0; i<N ; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		dist = new int[N][M];
		
		for(int i =0 ; i< N ; i++) {
			for(int j =0;j<M;j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dist[0][0] = 0;
		
		start(0,0);
		
//		for(int i =0; i< N ; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
//		
		System.out.println(dist[N-1][M-1]);
		
	}
	
	public static void start(int nodeX, int nodeY) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.value - o2.value);
		pq.add(new Node(nodeX,nodeY,dist[0][0]));
		
		while(!pq.isEmpty()) {
			
			Node nowNodeTemp = pq.poll();
			int nowNodeX = nowNodeTemp.nodeX;
			int nowNodeY = nowNodeTemp.nodeY;
			int nowValue = nowNodeTemp.value;
			
			if(dist[nowNodeY][nowNodeX]!=nowValue) {
				continue;
			}
			for(int i =0; i <4 ; i++) {
				int nextNodeX = nowNodeX + dx[i];
				int nextNodeY = nowNodeY + dy[i];
				
				if(nextNodeX>=0&&nextNodeY>=0&&nextNodeX<M&&nextNodeY<N) {
					
					if(dist[nextNodeY][nextNodeX]>dist[nowNodeY][nowNodeX]+arr[nextNodeY][nextNodeX]) {
						dist[nextNodeY][nextNodeX] = dist[nowNodeY][nowNodeX] + arr[nextNodeY][nextNodeX];
						pq.add(new Node(nextNodeX, nextNodeY, dist[nextNodeY][nextNodeX]));
					}
					
					
				}
			}
			
		}
		
	}

}
