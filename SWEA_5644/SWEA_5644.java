import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWEA_5644 {
	static int [] mvr = {0, -1, 0, 1, 0};
	static int [] mvc = {0, 0, 1 ,0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= t; tc ++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			
			int [] aMove = new int[m];
			int [] bMove = new int[m];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < m; i ++) {
				aMove[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < m; i ++) {
				bMove[i] = Integer.parseInt(st.nextToken());
			}
			
			int [][] acList = new int [a + 1][4];
			
			for(int i = 1; i <= a; i ++) {
				int [] ac = acList[i];
				st = new StringTokenizer(br.readLine());
				ac[1] = Integer.parseInt(st.nextToken());
				ac[0] = Integer.parseInt(st.nextToken());
				ac[2] = Integer.parseInt(st.nextToken());
				ac[3] = Integer.parseInt(st.nextToken());
			}
			
			// 배터리를 처리량 순으로 내림차순 정렬
			Arrays.sort(acList, (a1, a2) -> a2[3] - a1[3]);
			
			int aR = 1;
			int aC = 1;
			int bR = 10;
			int bC = 10;
		
			int sum = 0;
			
			// 처음 위치에서 bc 처리량 계산
			int aBoundary = getCurrentBoundary(aR, aC, acList);
			if(aBoundary >= 0) {
				int [] faBC = acList[aBoundary];
				sum += faBC[3];		
			}
			
			int bBoundary = getCurrentBoundary(bR, bC, acList);
			if(bBoundary >= 0) {
				int [] fbBC = acList[bBoundary];
				sum += fbBC[3];	
			}

			
			
			for(int i = 0; i < m; i ++) {
				
				int aMoveIdx = aMove[i];
				int anr = aR + mvr[aMoveIdx];
				int anc = aC + mvc[aMoveIdx];
				
				int bMoveIdx = bMove[i];
				int bnr = bR + mvr[bMoveIdx];
				int bnc = bC + mvc[bMoveIdx];
			
				aR = anr;
				aC = anc;
	
			
				bR = bnr;
				bC = bnc;
				
				
				aBoundary = getCurrentBoundary(aR, aC, acList);
				bBoundary = getCurrentBoundary(bR, bC, acList);
				
				int temp = 0;
				// a 와 b 가 같은 bc 영역에 들어왔을때
				if((aBoundary == bBoundary) && aBoundary >= 0) {
					int [] ac = acList[aBoundary];
					temp = ac[3];
				}
				// a가 속한 영역이 있을때
				if(aBoundary >= 0) {
					int []aBC = acList[aBoundary];
					int aTemp = aBC[3];
					// a 와 다른 b의 영역을 찾는다.
					int bTemp = getNextBoundaryFrom(bR, bC, aBoundary,  acList);
					if(bTemp >= 0) {
						int [] bBC = acList[bTemp];
						bTemp = bBC[3];
					} else {
						bTemp = 0;
					}
					// a 와 b 가 동일한 bc 영역  vs a 와 b 가 서로 다른 bc 영역에 있을때
					temp = Math.max(temp, aTemp + bTemp);
				}
				// b가 속한 영역이 있을때
				if(bBoundary >= 0) {
					int []bBC = acList[bBoundary];
					int bTemp = bBC[3];
					// b 와 다른 a의 영역을 찾는다.
					int aTemp = getNextBoundaryFrom(aR, aC, bBoundary,  acList);
					if(aTemp >= 0) {
						int [] aBC = acList[aTemp];
						aTemp = aBC[3];
					} else {
						aTemp = 0;
					}
					// a 와 b 가 동일한 bc 영역  vs a 와 b 가 서로 다른 bc 영역에 있을때
					temp = Math.max(temp, aTemp + bTemp);
				}	
				sum += temp;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		
	}
	/**
	 * 한 사람이 특정 영역에 존재 할때, 다른 사람이 존재할 수 있는 이 영역이외의 영역을 계산.
	 * @param curR 다른 사람의 위치 R
	 * @param curC 다른 사람의 위치 C
	 * @param from 한 사람이 속하는 영역
	 * @param acList
	 * @return
	 */
	private static int getNextBoundaryFrom(int curR, int curC, int from, int[][] acList) {
		
		for(int i = from + 1; i < acList.length - 1; i ++) {
			int [] ac = acList[i];
			int acR = ac[0];
			int acC = ac[1];
			int c = ac[2];
			
			if(isBCBoundary(acR, acC, curR, curC, c)) {
				return i;
			}
		}
		return -1;
	}
		
	
	private static int getCurrentBoundary(int curR, int curC, int[][] acList) {
		
		for(int i = 0; i < acList.length - 1; i ++) {
			
			int [] ac = acList[i];
			int acR = ac[0];
			int acC = ac[1];
			int c = ac[2];
			
			if(isBCBoundary(acR, acC, curR, curC, c)) {
				return i;
			}
		}
		return -1;
	}
	
	private static boolean isBCBoundary(int acR, int acC, int curR, int curC, int c) {
		return Math.abs(acR - curR) + Math.abs(acC - curC) <= c;
	}
}
