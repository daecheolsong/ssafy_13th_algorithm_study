package swea;

import java.util.*;
import java.io.*;

public class Solution_6109_신규원 {
    static int tc, n;
    static String str;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			str = st.nextToken();
			
			// map 입력받기
			map = new int[n][n];			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(str.equals("up")) play2048(false, 0, n, 1);
			else if(str.equals("down")) play2048(false, n-1, -1, -1);
			else if(str.equals("right")) play2048(true, n-1, -1, -1);
			else  play2048(true, 0, n, 1);
			
			sb.append("#").append(t).append("\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
        System.out.println(sb);
    }
    
    // 방향 (true:좌우, false:상하), 시작 index, 끝 index(-1 or N), 이동크기(-1 or 1)
	private static void play2048(boolean goX, int s, int e, int m) {
		int ys = 0;
		int xs = 0;
		if(goX)xs=s; // 좌우인 경우 xs = 시작 index
		else ys=s; // 상하인 경우 ys = 시작 index
		
		while(!((goX)? ys==n: xs==n)) { // 좌우인 경우 ys=n, 상하인 경우 xs=n
			Deque<Integer> d = new LinkedList<>();
			boolean flag = false; // true면 이전에 합쳐진 경우
			if(goX) xs = s; // 좌우인 경우 xs = 시작 index
			else ys = s; // 상하인 경우 ys = 시작 index
			
			while(!((goX)? xs==e: ys==e)) { // 좌우인 경우 xs 끝 index, 상하인 경우 ys 끝 index
				if(map[ys][xs] == 0) ; // 
				else if(d.isEmpty()) d.add(map[ys][xs]); // 비어있는 경우
				else if(flag||d.peekLast() != map[ys][xs]) { // 이전에 합쳐진 경우 또는 
					d.add(map[ys][xs]); // 덱에 넣기
					flag = false; // flag 원복
				}
				else if(map[ys][xs] != 0) { // flag가 false이고 같은 경우
					d.add(d.pollLast()*2);
					flag = true;
				}
				map[ys][xs] = 0;
				if(goX) xs += m;
				else ys += m;
			}
			
			// 빈간 채워주기
			if(goX) {
				int xIdx =s;
				while(!d.isEmpty()) {
					map[ys][xIdx] = d.poll();
					xIdx+=m;
				}
				ys++;
			}
			else {
				int yIdx = s;
				while(!d.isEmpty()) {
					map[yIdx][xs] = d.poll();
					yIdx+=m;
				}
				xs++;
			}
		}
		
	}
}