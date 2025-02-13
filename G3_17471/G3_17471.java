import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class G3_17471 {
	
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Node> nodeList = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i ++) {
			int pop = Integer.parseInt(st.nextToken());
			nodeList.add(new Node(i + 1, pop, new HashSet<>()));
		}
		
		for(int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int areaNum = Integer.parseInt(st.nextToken());
			Node nd = nodeList.get(i);
			
			for(int j = 0; j < areaNum; j ++) {
				int adjIdx = Integer.parseInt(st.nextToken());
				nd.adjList.add(nodeList.get(adjIdx - 1));
				nodeList.get(adjIdx - 1).adjList.add(nd);
			}
		}
		
		for(int i = 1; i <= n / 2; i ++) {
			int [] v = new int[n];
			caseSearch(v, i, nodeList, 0, 0);
		}
		System.out.println(answer == Integer.MAX_VALUE ? - 1 : answer);
	}
	
	private static void caseSearch(int [] v, int k, List<Node> nodeList, int next, int depth) {
		if(isInOneCase(depth ,k)) {
			List<Node> part1 = new ArrayList<>();
			List<Node> part2 = new ArrayList<>();
			for(int i = 0; i < nodeList.size(); i ++) {
				if(v[i] == 1) {
					part1.add(nodeList.get(i));
				} else {
					part2.add(nodeList.get(i));
				}
			}
			
			if(!isPartConnected(nodeList.size(), part1, nodeList)) {
				return;
			}
			
			if(!isPartConnected(nodeList.size(), part2, nodeList)) {
				return;
			}
			
			answer = Math.min(answer, findPopulationDifference(part1, part2));
			return;
		}
		
		for(int i = next; i < nodeList.size(); i ++) {
			v[i] = 1;
			caseSearch(v, k, nodeList, i + 1, depth + 1);
			v[i] = 0;
		}
		
	}
	
	private static boolean isInOneCase(int depth, int k) {
		return depth == k;
	}
	/**
	 * 두 파트가 서로 연결되어 있다고 확인될때, 그 때의 각 파타의 인구수 차를 구합니다.
	 * @param part1
	 * @param part2
	 * @return
	 */
	
	private static int findPopulationDifference(List<Node> part1, List<Node> part2) {
		int sum1 = 0;
		for(int i = 0; i < part1.size(); i ++) {
			sum1 += part1.get(i).population;
		}
		int sum2 = 0;
		for(int i = 0; i < part2.size(); i ++) {
			sum2 += part2.get(i).population;
		}
		return Math.abs(sum1 - sum2);
	}
	/**
	 * 나눈 파트에 대해, 한 파트가 서로 연결되어 있는지 판단합니다. 파트 한 노드에서 출발하여 인접노드를 통해 연결된 노드의 수를 판단하여
	 * 파트에 속한 수와 자신과 인접노드의 수가 동일하면 한 파트가 연결되어 있다고 판단합니다.
	 * @param nodeSize
	 * @param part
	 * @param nodeList
	 * @return
	 */
	
	private static boolean isPartConnected(int nodeSize, List<Node> part, List<Node> nodeList) {
		int [] v = new int[nodeSize];			
		Queue<Integer> q = new LinkedList<>();
		
		q.add(part.get(0).idx);
		v[part.get(0).idx - 1] = 1;
		
		int count = 1;
		while(!q.isEmpty()) {
			int idx = q.poll();
			for(Node n : nodeList.get(idx - 1).adjList) {
				if(v[n.idx - 1] == 0 && part.contains(n)) {
					q.add(n.idx);
					count++;
					v[n.idx - 1] = 1;
				}
			}
			
		}
		
		if(count == part.size()) {
			return true;
		}
		return false;
	}

	private static class Node {
		int idx;
		int population;
		Set<Node> adjList;
		
		public Node(int idx,int p, Set<Node> l) {
			this.idx = idx;
			this.population = p;
			this.adjList = l;
		}
	
		
		@Override
		public int hashCode() {
			return Objects.hash(idx);
		}
		
		@Override
		public boolean equals(Object o) {
			return ((Node)o).idx == this.idx;
		}
	}
}
