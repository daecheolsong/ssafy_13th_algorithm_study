package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1486 {

	static int tc, N, B, TARGET, ans;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {

		// 2^n
		// 2^20 : 100만, 2^30 : 10억
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			input = new int[N];
			isSelected = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				
			}
			
			generateSubSet(0);
			generateSubSet2(0,0,0);
			System.out.println(ans);
		}
	}

	public static void generateSubSet(int cnt) { // 해당 원소를 부분집합 구성에 넣을지 말지 처리

		if (cnt == N) { // 더 이상 고려할 원소가 없음, 부분집합 완성!!

			int sum = 0;
			for (int i = 0; i < N; i++) {
				// sum += isSelected[i]?input[i]:0;
				if (isSelected[i])
					sum += input[i];
			}

			if (sum == B) {
				for (int i = 0; i < N; i++) {
					// System.out.print((isSelected[i]?input[i]:""));
					if (isSelected[i])
						System.out.print(input[i] + " ");
				}
				System.out.println();
			}
			return;
		}

		// 해당 원소 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubSet(cnt + 1);
		// 해당 원소 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubSet(cnt + 1);
	}
	
	// sum : 직전까지 고려한 선택된 원소들의 누적합
	public static void generateSubSet2(int cnt, int pickCnt, int sum) { // 해당 원소를 부분집합 구성에 넣을지 말지 처리

		if (cnt == N) { // 더 이상 고려할 원소가 없음, 부분집합 완성!!
			if(pickCnt>0 && sum == B) ++ans;
			return;
		}

		// 해당 원소 부분집합에 넣기
		generateSubSet2(cnt + 1, pickCnt+1, sum+input[cnt]);
		// 해당 원소 부분집합에 넣지 않기
		generateSubSet2(cnt + 1, pickCnt, sum);  
	}

}