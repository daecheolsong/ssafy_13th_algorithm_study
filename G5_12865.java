import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //scanner가 아닌 bufferreader을 써보자!
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 띄어쓰기를 기점으로 tokenizer
		
		int N = Integer.parseInt(st.nextToken()); //N 먼저 토큰 저장 (형변환 필수)
		int K = Integer.parseInt(st.nextToken()); //K 저장
		
		int[] W = new int[N+1]; //무게 배열
		int[] V = new int[N+1]; //가치 배열
		int[][] dp = new int[N+1][K+1]; //dp 2차원 가치 저장 배열
		
		for(int i = 1; i<= N; i++) {
			st = new StringTokenizer(br.readLine()," "); //물건의 갯수만큼 for문 돌면서 띄어쓰기를 기준으로
			W[i] = Integer.parseInt(st.nextToken()); //무게 저장
			V[i] = Integer.parseInt(st.nextToken()); //가치 저장
		}
		
		for (int i = 1; i <= N; i++) { //2차원 배열 모두 돌면서 담을 수 있는지 없는지 확인
			for (int j = 1; j <= K; j++) {
				if(W[i]>j) { //만약 현재 확인하는 물건의 무게가 최대무게보다 크다면? 
					dp[i][j] = dp[i-1][j]; //그 전 물건 값 저장
				}
				else { //만약 현재 확인 하는 물건을 담을 수 있다면 max 함수를 통해서 그 전의 값과, 값을 뺐을때의 값 중 최대의 값 저장
					//만약 최대 값이 7이고 물건의 무게가 3일때 [N-1][4]일때의 값과 더함 어차피 [N-1][4]도 최댓값이 저장되어있기 때문
					dp[i][j] = Math.max(dp[i-1][j],  dp[i-1][j-W[i]] + V[i]);
				}
			}
		}
		System.out.println(dp[N][K]);

	}

}
