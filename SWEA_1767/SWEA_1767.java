import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1767 {
	static int [] mvr = {0, 0, 1, - 1};
	static int [] mvc = {1, -1, 0, 0};
	static int minVal = Integer.MAX_VALUE; // 최소 전선 길이의 합
	static int maxCore = Integer.MIN_VALUE; // 연결한 최대 코어의 수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc ++) {
			minVal = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			
			int [][] map = new int[n][n];
			
			for(int i = 0 ; i < n; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			List<int []> list =new ArrayList<>();
			
			for(int i = 0; i < n; i ++) {
				for(int j = 0; j < n; j ++) {
					// 가장자리 코어는 고려하지 않음
					if(!isEdge(i, j, n) && map[i][j] == 1) {
						list.add(new int[] {i, j});
					}
					
				}
			}
			
			connect(list, 0, 0, n, list.size(), map, 0);
			sb.append(minVal).append("\n");
		}
		System.out.println(sb);
	}
	
	
	private static void connect(List<int[]> list, int curSum, int depth, int n, int maxDepth, int [][] map, int coreCnt) {
		// 모든 코어를 고려했을때
		if(depth == maxDepth) {
			// 최대한 많은 코어를 연결했을때, 전원이 연결되지 않는 코어가 존재
			if(maxCore < coreCnt) {
				maxCore = coreCnt;
				minVal = curSum;
			} else if(maxCore == coreCnt) {
				// 모든 코어가 연결되었을때
				minVal = Math.min(minVal, curSum);		
			}
			return;
		}
		
		
		int r = list.get(depth)[0];
		int c = list.get(depth)[1];
		
		for(int i = 0; i < 4; i ++) {
			int sr = r + mvr[i];
			int sc = c + mvc[i];
			int count = 0; // 연결할때 필요한 전선의 길이
			while(true) {
				// 가장자리 까지 도달했다는 건 연결 가능하다라는 뜻
				if(!isIn(sr, sc, n)) {
					break;
				}
				// 중간에 코어가 발견되면 그 방향으로는 연결 불가, 전선 길이 0 으로 초기화
				if(map[sr][sc] == 1) {
					count = 0;
					break;
				}
				count++;
				sr = sr + mvr[i];
				sc = sc + mvc[i];
			}
			
			int fr = r;
			int fc = c;
			
			// 해당 방향으로 전선 연결
			for(int k = 0; k < count; k ++) {
				fr = fr + mvr[i];
				fc = fc + mvc[i];
				map[fr][fc] = 1;
			}
			
			if(count == 0) { // 해당 방향으로 연결 불가능 할 때
				connect(list, curSum, depth + 1, n, list.size(), map, coreCnt);
			} else { // 해당 방향으로 연결 가능 할때
				connect(list, curSum + count, depth + 1, n, list.size(), map, coreCnt + 1);
				// 이전 상태로 되돌림
				fr = r;
				fc = c;
				for(int k = 0; k < count; k ++) {
					fr = fr + mvr[i];
					fc = fc + mvc[i];
					map[fr][fc] = 0;
				}
			}
			
		}
	}
	
	
	private static boolean isIn(int r, int c, int n) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	
	private static boolean isEdge(int r, int c, int n) {
		return r == 0 || c == 0 || r == n - 1 || c == n - 1;
	}
}
