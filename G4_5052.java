import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class G4_5052 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < n; t++) {
			int m = Integer.parseInt(br.readLine());
			TrieNode trieNode = new TrieNode();
			String[] list = new String[m];
			
			for (int i = 0; i < m; i++) {
				list[i] = br.readLine();
			}
			
			Arrays.sort(list);
			boolean check = true;
			for (int i = 0; i < m; i++) {
				String s = list[i];
				if (trieNode.contains(s) && check) {
					sb.append("NO").append("\n");
					check = false;
				}
				trieNode.insert(s);
			}
			
			if (check) sb.append("YES").append("\n");
		}
		System.out.println(sb);
	}
	
	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
		boolean terminal;
		
		void insert(String s) {
			TrieNode node = this;
			
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				
				// c가 없으면 추가
				node.children.putIfAbsent(c, new TrieNode());
				node = node.children.get(c);
				
				// 마지막 문자일 경우 terminal
				if (i == s.length() - 1) {
					node.terminal = true;
					return;
				}
			}
		}
		
		boolean contains(String s) {
			TrieNode trieNode = this;
			
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				TrieNode node = trieNode.children.get(c);
				
				if (node == null) return false;
				
				if (node.terminal) return true;
				trieNode = node;
			}
			return trieNode.terminal;
		}
	}
}
