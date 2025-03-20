import java.util.*;
import java.io.*;


public class G5_1068 {
	
	static int n;
	static int [] p;
	static int k;
	static Node[] nodeList;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		p = new int[n];
		nodeList = new Node[n];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i ++) {
			nodeList[i] = new Node(i);
			p[i]= Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i ++) {
			if(p[i] >= 0) {
				nodeList[p[i]].childNodeList.add(nodeList[i]);	
			}
		}
		k = Integer.parseInt(br.readLine());
		
		Queue<Node> q = new LinkedList<>();
		
		q.add(nodeList[k]);
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			cur.cut = 1;
			
			for(Node child : cur.childNodeList) {
				child.cut = 1;
				q.add(child);
			}
			
		}
		
		if(p[k] == -1) {
			System.out.println(0);
			return;
		}
		
		nodeList[p[k]].childNodeList.remove(nodeList[k]);
		
		int answer = 0;
		for(int i = 0; i < n; i ++) {
			if(nodeList[i].cut == 1) {
				continue;
			}
			if(nodeList[i].childNodeList.isEmpty()) {
				answer ++;
			}
		}
		System.out.println(answer);
		
	}

	static class Node {
		List<Node> childNodeList = new ArrayList<>();
		int idx;
		int cut;
		public Node (int idx) {
			this.idx = idx;
		}
	}

}
