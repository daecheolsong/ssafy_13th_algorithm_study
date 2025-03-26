import java.io.*;
import java.util.*;

public class swea_3289 {
	static int N, M, T, a, b, bool;
	static int[] parents;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static void make() { // 배열 생성 및 초기화
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i]=i;
		}
	}
	
	private static int find(int a) { // 루트 노드 찾기 (집합 대표자 반환)
		if(a == parents[a]) return a; 
		
		return parents[a] = find(parents[a]); // 경로 압축
	}
	
	private static boolean union(int a, int b) { // 조직 합치기 b가 a를 햄으로 모시기
		int aRoot = parents[find(a)]; // 부모 인덱스 반환
		int bRoot = parents[find(b)];
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot; // parents 배열 bRoot 부모인덱스에 a루트 값(aRoot) 대입
		return true;
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			init();
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		make();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			bool = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(bool == 0) union(a,b);
			else {
				if(find(a) == find(b)) sb.append(1);
				else sb.append(0);
			}
			// find(a) == find(b)이면  1, != 이면 0
		}
	}
}
