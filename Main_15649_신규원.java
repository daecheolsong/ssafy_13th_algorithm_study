package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_신규원 {
	static int N, R;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		numbers = new int[R]; // 선택된 수 저장
		isSelected = new boolean[N+1]; // 1부터 사용, 선택 여부 저장
		
		permutation(0); // 초기값
	}
	
	static void permutation(int cnt) {
		if(cnt == R) {
			for(int i=0; i<R; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			//System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=1; i<=N; i++) { // 유도파트
			if(isSelected[i] ) continue;
			numbers[cnt] = i; // 선택한 수 저장
			isSelected[i] = true; // 선택한 수 플래그 true
			permutation(cnt+1); // 다음 수 선택하러 고고씽
			isSelected[i] = false; // 선택을 변경해야하므로 기존 플래그 원복
		}
		
	}

}
