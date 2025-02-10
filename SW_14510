import java.io.*;
import java.util.*;

public class SW_14510 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] heights = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			boolean[] flag = new boolean[N];
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
				if (heights[i] > max) {
					max = heights[i];
				}
			}
			
			int diff2 = 0; //2가 필요한 날의 갯수 계산
			int diff1 = 0; //1이 필요한 날의 갯수 계산
			int day = 0;
			for (int i = 0; i < N; i++) {
				diff1 += (max - heights[i]) % 2;
				diff2 += (max - heights[i]) / 2;
			}
			
			while ((diff2 > 0) || (diff1 > 0)) {
				day++;
				if (day % 2 == 1) { //홀수 날
					if (diff1 > 0) { // 1이 필요한 날 빼기
						diff1--;
					}
					else { // diff1이 없다면 diff2를 줄여서 홀 수 날을 나눠서 사용
						if (diff2 == 1) {
							continue;
						}
						else {
							diff2--;
							diff1++;
						}
						
					}
				}
				else if (day % 2 == 0) { //짝수 날
					if (diff2 != 0) { //2가 필요한 날 빼기
						diff2--;
					} //왜 2가 부족한 날엔 diff1에서 보충을 안하느냐? 
// diff1은 각 나무들에서 가져오는 것이지만 한번에 2의 높이를 세워야한다는 조건이 있기 때문에 1씩 나무를 따로 높여줄 수 없기 때문에 그냥 하루를 지내고 홀 수날이 오기를 기다려야함
				}
			}
			
			System.out.println("#" + test_case + " " + day);
			
			
			
			
			
//			int day = 0;     
//			int remain = N;
//			while(remain > 0) {
//				for (int i = 0; i < N; i++) {
//					if (heights[i] == max && flag[i] == false) {
//						flag[i] = true;
//						remain--;
//						continue;
//					}else if (heights[i] != max){
//						day++;
//						if ((max - heights[i]) > 2) {
//							if (day % 2 == 1) {
//								heights[i]++;
//							}
//							else heights[i] += 2;
//							break;
//						}	
//					else if ((max- heights[i] == 2)) {
//						if (day % 2 == 0) {
//							heights[i] += 2;
//						}
//						else {
//							if (i < N-1) {
//								day--;
//								continue;
//							} 
//							else continue;
//						}
//					}
//					else if ((max- heights[i] == 1)) {
//						if (day % 2 == 1) {
//							heights[i] ++;
//						}
//						else {
//							if (i < N-1) {
//								day--;
//								continue;
//							} 
//							else continue;
//						}
//					}
//					}
//					
//				}
//				int count = 0;
//				for (int  j = 0; j < N; j++) {
//					if (flag[j]) {
//						count++;
//					}
//				}
//
//				if (count == N) {
//					System.out.println("#" + test_case + " " + day);
//					break;
//				}
//			}
		}
	}

}
