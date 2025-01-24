import java.util.Scanner;

public class G5_1074 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		int N = sc.nextInt();
		N = (int) Math.pow(2, N); // 2의 N승 * 2의 N승의 그리드가 생성
		//int[][] grid = new int[N][N]; // 하지만 그리드 안만듦
		
		int r = sc.nextInt(); // 위치 지정
		int c = sc.nextInt();
		
		while(N > 1) {
			if ((r < N/ 2) && (c < N / 2)) {
				N = N/2; // 1사분면인 경우 N/2로 크기 줄임
				//System.out.println("if1" + result);
			}
			else if ((r < N/ 2) && (c >= N / 2)) {
				N = N/2;
				result += N * N;

				c = c-N; // 2사분면인 경우 N/2로 크기 줄임과 동시에 c값 조절해주어야함
				//System.out.println("if2" + result);
			}
			else if ((r >= N/ 2) && (c < N / 2)) {
				N = N/2;
				result += N * N * 2;

				r = r-N; // 3사분면인 경우 N/2로 크기 줄임과 동시에 r값 조절해주어야함
				//System.out.println("if3" + result);
			}
			
			else if ((r >= N/ 2) && (c >= N / 2)) {
				N = N/2;
				result += N * N * 3;

				r = r-N;
				c = c-N; // 4사분면인 경우 N/2로 크기 줄임과 동시에 r,c값 모두 조절해주어야함
				//System.out.println("if4" + result);
			}
			
		}
		
		System.out.println(result);
	}

}
