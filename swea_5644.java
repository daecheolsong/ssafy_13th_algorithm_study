package swea;
import java.util.*;
import java.io.*;

public class swea_5644 {
	static int[][] direction = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine()); //테스트케이스
	    for (int t = 0; t < T; t++) { //테스트케이스 반복
	        StringTokenizer st = new StringTokenizer(br.readLine()); //첫 줄
	        int m = Integer.parseInt(st.nextToken()); //첫 줄 m입력
	        int a = Integer.parseInt(st.nextToken()); //첫 줄 A입력
	        int[][] moves = new int[2][m];            // 움직이는 A와 B의 경로
	        int[][] bcs = new int[a][4];            // BC A개의 정보. 4인 이유는? 
	        for (int i = 0; i < 2; i++) {            // A와 B 경로 입력 받는 로직
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < m; j++) {
	                moves[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }
	        for (int i = 0; i < a; i++) {            //BC 4개의 정보 {idx 0 : BC의 중앙의 r값, 1 : c값, 2 : 넓이, 3 : 파워  }
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < 4; j++) {
	                bcs[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }

	        // 최댓값 구하기
	        int sum = 0;        //최댓값 구할 때 필요한 sum =0으로 초기화
	        int[][] p = { { 1, 1 }, { 10, 10 } }; //A와 B의 현 위치
	        for (int i = 0; i <= m; i++) { // 각 MOVE에 대해
	            boolean[] connect1 = new boolean[bcs.length];        // ??
	            boolean[] connect2 = new boolean[bcs.length];        // ??
	            for (int j = 0; j < 2; j++) { // A,B에 대해
	                if (i != 0) { // 이동. t=0인 시점을 고려하기 위해 i를 0~m까지 설정
	                    p[j][0] += direction[moves[j][i - 1]][0];
	                    p[j][1] += direction[moves[j][i - 1]][1];
	                }
	                for (int k = 0; k < bcs.length; k++) { // 각 BC들에 대해
	                    int[] bc = bcs[k];
	                    // bc의 0, 1번째 원소는 좌표, 2번째 원소는 범위, 3번째 원소는 power를 의미
	                    if (bc[2] >= Math.abs(bc[0] - p[j][0]) + Math.abs(bc[1] - p[j][1])) {
	                    	// 범위 >= |AP x좌표 - 현재위치 x좌표| + |AP y좌표 - 현재위치 y좌표|
	                    	//    2>= |4-3| + |4-2|
	                        if (j == 0) // 첫번째 사람이면
	                            connect1[k] = true; // 몇번째 BC에 연결되었는지
	                        if (j == 1)
	                            connect2[k] = true;
	                    }
	                }
	            }
	            int currMax = 0;
	            for (int j = 0; j < bcs.length; j++) {
	                for (int k = 0; k < bcs.length; k++) {
	                    if(bcs.length==1 && (connect1[j]||connect2[k])) { // 설치된 충전기가 1개 이고 둘 중에 한 충전기에 연결되었을 때
	                        currMax = connect1[j]?bcs[j][3]:bcs[k][3]; // 충전량
	                    }
	                    if ((!connect1[j] && !connect2[k]) || j == k) // 둘 다 연결 안됐을때나, 연결된 충전기가 같을 때
	                        continue;
	                    int power1 = connect1[j] ? bcs[j][3] : 0;
	                    int power2 = connect2[k] ? bcs[k][3] : 0;
	                    int curr = power1+power2;
	                    currMax = Math.max(currMax, curr);
	                }
	            }
	            sum += currMax;
	        }
	        System.out.println("#" + (t + 1) + " " + sum);
	    }

	    br.close();

	}
}
