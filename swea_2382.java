import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int T, N, M, K, res;
	static ArrayList<Node> list;
	static PriorityQueue<Node> pq;

	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init();
			go();
			gogogogo();
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static void gogogogo() {
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			res += node.power;
		}
		
	}

	private static void go() {
		for (int i = 0; i < M; i++) {
			gogo();
		}
	}

	private static void gogo() {
		Map<String, int[]> map = new HashMap<>();
		
		while (!pq.isEmpty()) {
			Node node = gogogo(pq.poll());

			if (isWall(node.x, node.y)) {
				node.power /= 2;
				node.dir = newDir(node.dir);
			}
			
			String point = node.x + " " + node.y;
			int[] pd = new int[] {node.power, node.dir};
			
			if(map.containsKey(point)) {
				int[] newPd = map.get(point);
				
				newPd[0] += pd[0];
			}else {
				map.put(point, pd);
			}
			
			
		}
		
		for (Map.Entry<String, int[]> entry : map.entrySet()) {
			String key = entry.getKey();
			st = new StringTokenizer(key);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int[] pd = entry.getValue();
			int power = pd[0];
			int dir = pd[1];
			pq.add(new Node(x, y, power, dir));
			
		}
	}

	private static int newDir(int dir) {
		switch(dir) {
		case 1 : return 2;
		case 2 : return 1;
		case 3 : return 4;
		case 4 : return 3;
		}
		return dir;
	
	}

	private static Solution.Node gogogo(Solution.Node poll) {
		int dir = poll.dir;
		switch (dir) {
		case 1:
			poll.x -= 1;
			break;
		case 2:
			poll.x += 1;
			break;
		case 3:
			poll.y -= 1;
			break;
		case 4:
			poll.y += 1;
			break;
		}
		return poll;
	}

	private static boolean isWall(int x, int y) {
		if(x == 0 || x == N -1 || y == 0 || y == N -1) return true;
		return false;
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		res = 0;
		list = new ArrayList<>();
		pq = new PriorityQueue<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int power = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			pq.add(new Node(x, y, power, dir));
		}

	}

	public static class Node implements Comparable<Node> {
		int x, y, power, dir;

		public Node(int x, int y, int power, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.power = power;
			this.dir = dir;
		}

		@Override
		public int compareTo(Solution.Node o) {
			// TODO Auto-generated method stub
			return o.power - this.power;
		}

	}

}
