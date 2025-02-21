package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1225_신규원 {

	static int[] pw1 , pw2;
	static int move;
	public static void main(String[] args) throws Exception {
		
		pw1 = new int[8];

		//System.setIn(new FileInputStream("src/swea/input_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 0; tc < 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				pw1[i] = Integer.parseInt(st.nextToken());
			}
			
			while(true) {
				for (int dec = 1; dec <=5; dec++) {
					// 첫번째 숫자 임시 저장
					move = pw1[0];
					
					//  숫자 이동
					for (int i = 0; i < 7; i++) {
						pw1[i] = pw1[i+1];
					}
					// 마지막 자리 감소값 넣기
					pw1[7] = move - dec;
					// 0이하면 0 넣고 종료
					if(pw1[7]<=0) {
						pw1[7]=0;
						break;
					}
	                }
				// 0이하가 되면 루프 종료
                if (pw1[7] <= 0) {
                    break;
				}
			}
			System.out.print("#"+(tc+1));
			for (int i = 0; i <	8; i++) {
				System.out.print(" "+pw1[i]);
			}
			System.out.println();
		}
	}
}
