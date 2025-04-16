import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class G3_14725 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			String[] list = new String[size];
			for (int j = 0; j < size; j++) {
				list[j] = st.nextToken();
			}
			trie.insert(list);
		}
		trie.print();
		System.out.println(sb);
	}
	
	static class Node {
		Map<String, Node> children = new TreeMap<>();
	}
	
	static class Trie {
		Node root = new Node();
		
		void insert(String[] list) {
			// 실제 의미있는 데이터는 아님, 시작점의 역할
			Node current = root;
			for (String item : list) {
				// computeIfAbsent: key가 존재하면 value 리턴, 없으면 key 값이 newValue 저장
				current = current.children.computeIfAbsent(item, k -> new Node());
			}
		}
		
		void print() {
			dfs(root, 0);
		}
		
		void dfs(Node node, int depth) {
			for (String key : node.children.keySet()) {
				for (int i = 0; i < depth; i++) {
					sb.append("--");
				}
				sb.append(key).append("\n");
				dfs(node.children.get(key), depth + 1);
			}
		}
	}
}
