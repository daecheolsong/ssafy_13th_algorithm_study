import java.util.*;
import java.io.*;

public class S2_11725 {
	static int N;
	static Map<Integer, List<Integer>> tree = new HashMap<>();
	static Map<Integer, Integer> parent = new HashMap<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) { //초기화
			tree.put(i, new ArrayList<>());
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer (br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			tree.get(x).add(y); //tree map은 각 간선별 연결된 노드의 정보 저장
			tree.get(y).add(x);
		}
		
		bfs(1);
		
		for (int i = 2; i <= N; i++) { //2번 트리부터 부모 노드 출력
			System.out.println(parent.get(i));
		}
	}
	
	static void bfs(int idx) { //루드(1번노드)
		Queue<Integer> queue = new LinkedList<>(); 
		queue.add(idx); //1번노드 add
		parent.put(idx, 0);
		while (!queue.isEmpty()) {
			int cur = queue.poll(); //현재 노드 정보
			for (int child:tree.get(cur)) { //현재 노드 기준 자식 노드들의 정보 출력
				if(!parent.containsKey(child)) { //만약 부모 노드를 아직 입력하지 않았다면?
					parent.put(child, cur); //현재 노드를 부모 노드로 입력하고 
					queue.add(child); //큐에 넣어서 자식 노드의 자식노드 찾기
				}
			}
		}
	}

}
