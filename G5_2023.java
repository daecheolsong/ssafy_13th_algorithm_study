import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
		
		
	}

	private static void dfs(int i, int cnt) {
		if(cnt == N) { // N 자리수 일 때
			if(isPrime(i)) { // 소수이면 출력
				System.out.println(i);
			}
			
			return;
		}
		
		for (int j = 0; j < 10; j++) {
			if(isPrime(i * 10 + j)) { // 다음 자릿수 숫자가 소수이면
				dfs(i * 10 + j, cnt+1); // 다음 자릿수 계속 탐색
			}
		}
		
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i <= num/2; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}

}
