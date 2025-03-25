import java.util.*;
import java.io.*;


public class G3_1516 {

	static int n;
	static Node [] nodeList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nodeList = new Node[n + 1];
		
		for(int i = 1; i <= n; i ++) {
			nodeList[i] = new Node(i);
		}
		
		for(int i = 1; i <= n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nodeList[i].cost = Integer.parseInt(st.nextToken());
			nodeList[i].minCost = nodeList[i].cost;
			
			while(st.hasMoreTokens()) {
				int idx = Integer.parseInt(st.nextToken());
				if(idx == -1) {
					break;
				}
				nodeList[i].inDegreeNodes.add(nodeList[idx]);
				nodeList[idx].outDegreeNodes.add(nodeList[i]);
			}
		}
		
		Queue<Node> q = new LinkedList<>(); 
		
		for(int i = 1; i <= n ; i ++) {
			if(nodeList[i].inDegreeNodes.isEmpty()) {
				q.add(nodeList[i]);
			}
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(Node out : cur.outDegreeNodes) {
				out.minCost = Math.max(out.minCost, out.cost + cur.minCost);
				out.inDegreeNodes.remove(cur);
				if(out.inDegreeNodes.isEmpty()) {
					q.add(out);
				}
			}
		}
		
		for(int i = 1; i <=n ; i ++) {
			System.out.println(nodeList[i].minCost);
		}
	
	}
	
	static class Node {
		int idx;
		int cost;
		int minCost;
		List<Node> inDegreeNodes = new ArrayList<>();
		List<Node> outDegreeNodes = new ArrayList<>();
		public Node(int idx) {
			this.idx = idx;
		}
	}
	
}
