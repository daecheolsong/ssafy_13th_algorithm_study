import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L3_11002 {

	public static void main(String[] args) throws IOException {
		//시간초과로 인해 3중 for문은 불가능 0과 1만 들어오기 때문에 비트연산으로 진행
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //N값 입력
		int M = Integer.parseInt(st.nextToken()); //M값 입력
		int[] nums = new int[N]; //nums 저장
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine(), 2); // 2진수로 int 값 저장
		}

		
		for(int i = 0; i < N-1; i++) {
			for(int j = i+1; j < N; j++) {
				int diff = nums[i] ^ nums[j]; //각 정수의 비트값 xor(두개가 다르면 1)
                
				if (Integer.bitCount(diff)<=2) { //bitCount는 정수의 비트에서 1의 갯수를 반환
					// 만약 9라면 101 이므로 Integer.bitCount(diff) = 2
					result++;
				}
			}
		}
		System.out.println(result);
	}

}
